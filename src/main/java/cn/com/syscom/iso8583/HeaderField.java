package cn.com.syscom.iso8583;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.syscom.iso8583.codecs.CompositeField;
import cn.com.syscom.iso8583.parse.FieldParseInfo;
import cn.com.syscom.iso8583.util.HexUtil;

public class HeaderField {
	
	private String path;
	
	public HeaderField() {
		this.path = "header_config.xml";
		init();
	}
	
	public HeaderField(String path) {
		this.path =path;
		init();
	}
	
	
	public MessageFactory<IsoMessage> getMf() {
		return mf;
	}

	private MessageFactory<IsoMessage> mf;
	
	private IsoMessage mHead;
	
	public IsoMessage getIsoMessage() {
		return mHead;
	}
	private Map<Integer, FieldParseInfo> parseGuide;
	private List<Integer> index;
	
	public void init() {
		try {
			this.addValue(new IsoValue<>(IsoType.BINARY, HexUtil.parseHex("16"), 1));
			this.addValue(new IsoValue<>(IsoType.BINARY, HexUtil.parseHex("01"), 1));
			this.addValue(new IsoValue<>(IsoType.BINARY, HexUtil.parseHex("02"), 1));
			this.addValue(new IsoValue<>(IsoType.BINARY, HexUtil.parseHex("0000"), 2));
			this.addValue(new IsoValue<>(IsoType.NUMERIC, 0, 6));
			this.addValue(new IsoValue<>(IsoType.NUMERIC, 0, 6));
			this.addValue(new IsoValue<>(IsoType.BINARY, HexUtil.parseHex("00"), 1));
			this.addValue(new IsoValue<>(IsoType.BINARY, HexUtil.parseHex("0000"), 2));
			this.addValue(new IsoValue<>(IsoType.BINARY, HexUtil.parseHex("000000"), 3));
			this.addValue(new IsoValue<>(IsoType.BINARY, HexUtil.parseHex("00"), 1));
			this.addValue(new IsoValue<>(IsoType.BINARY, HexUtil.parseHex("000000"), 3));
			this.addValue(new IsoValue<>(IsoType.BINARY, HexUtil.parseHex("00"), 1));
			
			mHead = new IsoMessage();
			mf = new MessageFactory<IsoMessage>();
			mf.setConfigPath(path);
			
			 parseGuide = mf.getParseMap().get(0x1111);
			index = mf.getParseOrder().get(0x1111);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mf.setUseBinaryBitmap(true);
			//mHead = mf.parseCustomField(by, 0, false);
	}
	
    private static final Logger log = LoggerFactory.getLogger(CompositeField.class);
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

    public HeaderField addValue(IsoValue<?> v) {
        if (values == null) {
            values = new ArrayList<>(4);
        }
        values.add(v);
        return this;
    }
    public <T> HeaderField addValue(T val, CustomField<T> encoder, IsoType t, int length) {
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
    public HeaderField addParser(FieldParseInfo fpi) {
        if (parsers == null) {
            parsers = new ArrayList<>(4);
        }
        parsers.add(fpi);
        return this;
    }

    @SuppressWarnings({ "rawtypes", "unused" })
	public void decodeBinaryField(byte[] buf, int offset, int length) {
        List<IsoValue> vals = new ArrayList<>(parseGuide.size());
        
        byte[] by = new byte[length]; 
        int pos = offset;
        try {
        	for (Integer i : index) {
        		FieldParseInfo fpi = parseGuide.get(i);
	            	if (pos < (offset +length)) {
		                IsoValue<?> v = fpi.parseBinary(0, buf, pos, fpi.getDecoder());
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

            setValues(vals);
            return;
        } catch (ParseException ex) {
            log.error("Decoding binary CompositeField", ex);
            return;
        } catch (UnsupportedEncodingException ex) {
            log.error("Decoding binary CompositeField", ex);
            return;
        }
    }

    @SuppressWarnings("rawtypes")
	public HeaderField decodeField(String value) {
        List<IsoValue> vals = new ArrayList<>(parseGuide.size());
        byte[] buf = value.getBytes();
        int pos = 0;
        try {
        	for (Integer i : index) {
        		FieldParseInfo fpi = parseGuide.get(i);
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
            final HeaderField f = new HeaderField();
            f.setValues(vals);
            return f;
        } catch (ParseException | UnsupportedEncodingException ex) {
            log.error("Decoding CompositeField", ex);
            return null;
        }
    }

    public byte[] encodeBinaryField(HeaderField value) {
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

    public String encodeField(HeaderField value) {
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
        StringBuilder sb = new StringBuilder("HeadField:\n");
        if (values!=null) {
            int i = 0;
            for (IsoValue<?> v : values) {
               sb.append('\n');
                sb.append("F " + (++i) + "(" + v.getType() + "): " + v.toString());
            }
        }
        return sb.toString();
    }
}
