package cn.com.syscom.iso8583.codecs;

import cn.com.syscom.iso8583.CustomField;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.IsoValue;
import cn.com.syscom.iso8583.parse.FieldParseInfo;
import cn.com.syscom.iso8583.util.HexUtil;
import oracle.jdbc.oracore.PickleContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * A codec to manage subfields inside a field of a certain type.
 *
 * @author Enrique Zamudio
 *         Date: 25/11/13 11:25
 */
public class CompositeField implements CustomField<CompositeField>,Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CompositeField.class);
	
	private String encoding = System.getProperty("file.encoding");
	
    /** Stores the subfields. */
    @SuppressWarnings("rawtypes")
    private List<IsoValue> values;
    /** Stores the parsers for the subfields. */
    private List<FieldParseInfo> parsers;

    @SuppressWarnings("rawtypes")
    public void setValues(List<IsoValue> values) {
        this.values = values;
    }
    @SuppressWarnings("rawtypes")
    public List<IsoValue> getValues() {
        return values;
    }
    
    /** Sets the encoding to use. */
    public void setCharacterEncoding(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot set null encoding.");
        }
    	encoding = value;
    }
    
    @SuppressWarnings("rawtypes")
    public CompositeField addValue(IsoValue<?> v) {
        if (values == null) {
            values = new ArrayList<>(4);
        }
        values.add(v);
        return this;
    }
    public <T> CompositeField addValue(T val, CustomField<T> encoder, IsoType t, int length) {
        return addValue(t.needsLength() ? new IsoValue<>(t, val, length, encoder)
                : new IsoValue<>(t, val, encoder));
    }

    @SuppressWarnings("unchecked")
    public <T> IsoValue<T> getField(int idx) {
        if (idx < 0 || idx >= values.size())return null;
        return values.get(idx);
    }
    
    
    public <T> T getObjectValue(int idx) {
        IsoValue<T> v = getField(idx);
        return v==null ? null : v.getValue();
    }

    public void setParsers(List<FieldParseInfo> fpis) {
        parsers = fpis;
    }
    public List<FieldParseInfo> getParsers() {
        return parsers;
    }
    public CompositeField addParser(FieldParseInfo fpi) {
        if (parsers == null) {
            parsers = new ArrayList<>(4);
        }
        parsers.add(fpi);
        return this;
    }

    @Override
    public CompositeField decodeBinaryField(byte[] buf, int offset, int length) {
        @SuppressWarnings("rawtypes")
        List<IsoValue> vals = new ArrayList<>(parsers.size());
        byte[] by = new byte[length];
        System.arraycopy(buf, offset, by, 0, length);

        int pos = 0;
        try {
            for (FieldParseInfo fpi : parsers) {
            	fpi.setCharacterEncoding("Cp1047");
	            	if (pos < (offset +length)) {
		                IsoValue<?> v = fpi.parseBinary(0, by, pos, fpi.getDecoder());
		                if (v != null) {
		                    if (v.getType() == IsoType.NUMERIC || v.getType() == IsoType.DATE10
		                            || v.getType() == IsoType.DATE4 || v.getType() == IsoType.DATE_EXP
		                            || v.getType() == IsoType.AMOUNT || v.getType() == IsoType.TIME
		                            || v.getType() == IsoType.DATE12) {
		                        pos += (v.getLength() / 2) + (v.getLength() % 2);
		                    } else {
		                        pos += v.getLength();
		                    }
		                    if (v.getType() == IsoType.LLVAR || v.getType() == IsoType.LLBIN) {
		                        pos++;
		                    } else if (v.getType() == IsoType.LLLVAR || v.getType() == IsoType.LLLBIN
		                            || v.getType() == IsoType.LLLLVAR || v.getType() == IsoType.LLLLBIN) {
		                        pos+=2;
		                    }
		                    vals.add(v);
		                }
	            }
            }
            final CompositeField f = new CompositeField();
            f.setValues(vals);
            return f;
        } catch (ParseException ex) {
            log.error("Decoding binary CompositeField", ex);
            return null;
        } catch (UnsupportedEncodingException ex) {
            log.error("Decoding binary CompositeField", ex);
            return null;
        }
    }

    @Override
    public CompositeField decodeField(String value) {
        @SuppressWarnings("rawtypes")
        List<IsoValue> vals = new ArrayList<>(parsers.size());
        byte[] buf = null;
		try {
			buf = value.getBytes(encoding);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int pos = 0;
        try {
            for (FieldParseInfo fpi : parsers) {
            	if (pos < buf.length) {
            	      IsoValue<?> v = fpi.parse(0, buf, pos, fpi.getDecoder());
                      if (v != null) {
                          pos += v.toString().getBytes(fpi.getCharacterEncoding()).length;
                          if (v.getType() == IsoType.LLVAR || v.getType() == IsoType.LLBIN) {
                              pos+=2;
                          } else if (v.getType() == IsoType.LLLVAR || v.getType() == IsoType.LLLBIN) {
                              pos+=3;
                          } else if (v.getType() == IsoType.LLLLBIN || v.getType() == IsoType.LLLLVAR) {
                              pos+=4;
                          }
                          vals.add(v);
                      }
				}
            }
            final CompositeField f = new CompositeField();
            f.setValues(vals);
            return f;
        } catch (ParseException | UnsupportedEncodingException ex) {
            log.error("Decoding CompositeField", ex);
            return null;
        }
    }

    @Override
    public byte[] encodeBinaryField(CompositeField value) {
        final ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try {
            String encoding = null;
            for (IsoValue<?> v : value.getValues()) {
                if (encoding == null)encoding = v.getCharacterEncoding();
                v.write(bout, true, true,encoding);
            }
        } catch (IOException ex) {
            log.error("Encoding binary CompositeField", ex);
            //shouldn't happen
        }
        return bout.toByteArray();
    }

    @Override
    public String encodeField(CompositeField value) {
        try {
            String encoding = null;
            final ByteArrayOutputStream bout = new ByteArrayOutputStream();
            for (IsoValue<?> v : value.getValues()) {
                if (encoding == null)encoding = v.getCharacterEncoding();
                v.write(bout, false, true,encoding);
            }
            final byte[] buf = bout.toByteArray();
            return new String(buf, encoding==null?"UTF-8":encoding);
        } catch (IOException ex) {
            log.error("Encoding text CompositeField", ex);
            return "";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CompositeField[");
        if (values!=null) {
            boolean first=true;
            for (IsoValue<?> v : values) {
                if (first)first=false;else sb.append(',');
                sb.append(v.getType());
            }
        }
        return sb.append(']').toString();
    }
}
