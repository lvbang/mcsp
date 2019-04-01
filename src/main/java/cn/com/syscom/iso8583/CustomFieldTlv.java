package cn.com.syscom.iso8583;

import java.io.UnsupportedEncodingException;

import org.apache.ibatis.jdbc.Null;

import cn.com.syscom.iso8583.tlv.BerTlvBuilder;
import cn.com.syscom.iso8583.tlv.BerTlvParser;
import cn.com.syscom.iso8583.tlv.BerTlvs;
import cn.com.syscom.iso8583.util.HexCodec;
import cn.com.syscom.iso8583.util.HexUtil;

/** This is an example of a custom field codec, which converts between strings and instances of this same class.
 * It's used to test the encoding and decoding of custom fields by the message factory.
 * 
 * @author Enrique Zamudio
 */
public class CustomFieldTlv implements CustomBinaryField<CustomFieldTlv> {

	private BerTlvParser parser = new BerTlvParser();
	//  BerTlvs tlvs = parser.parse(by, 3, 15);
	public  BerTlvs tlvs = null;
	
	BerTlvBuilder builder = null;
	
	private String v1;
	
	private String decodeCharacter;
	
	public String getCharacterdecode() {
		return decodeCharacter;
	}
	
	public void setCharacterdecode(String value) {
		decodeCharacter = value;
	}

	private String encodingCharacter;
	
	public String getCharacterEncoding() {
		return encodingCharacter;
	}
	
	public void setCharacterEncoding(String value) {
		encodingCharacter = value;
	}
	
	public void setValue1(String value) {
		v1 = value;
	}
	public String getValue1() {
		return v1;
	}

	@Override
	public CustomFieldTlv decodeField(String value) {
		CustomFieldTlv cf = null;
		if (value != null) {
				cf = new CustomFieldTlv();
				try {
					tlvs = parser.parse(value.getBytes("Cp1047"),encodingCharacter,decodeCharacter);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				cf.v1 = value;
		}
		return cf;
	}

	@Override
	public String encodeField(CustomFieldTlv value) {
		byte[] by = null;
		if (tlvs != null) {
			builder = new BerTlvBuilder(tlvs);
			by = builder.buildArray();
		}
		try {
			return new String(by,"Cp1047");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		StringBuilder sb = new StringBuilder();
//		if (value.getValue1() != null) {
//			sb.append(value.getValue1());
//		}
//		return sb.toString();
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof CustomFieldTlv)) {
			return false;
		}
		CustomFieldTlv other = (CustomFieldTlv)obj;
			if (other.getValue1() == null) {
				return v1 == null;
			} else {
				return other.getValue1().equals(v1);
			}
	}

	@Override
	public int hashCode() {
		return v1 == null ? 0 : v1.hashCode();
	}
	@SuppressWarnings("unused")
	@Override
	public CustomFieldTlv decodeBinaryField(byte[] value, int offset, int length) {
		byte[] _v = new byte[length];
		System.arraycopy(value, offset, _v, 0, length);
		CustomFieldTlv cf = null;
		if (_v != null) {
				cf = new CustomFieldTlv();
				tlvs = parser.parse(_v,encodingCharacter,decodeCharacter);
				try {
					cf.v1 = (encodingCharacter == null?new String(_v, "CP1047"):new String(_v, encodingCharacter));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
				return cf;
			}
		return null;
	}
		
	@Override
	public byte[] encodeBinaryField(CustomFieldTlv value) {
		byte[] by = null;
		if (tlvs != null) {
			builder = new BerTlvBuilder(tlvs);
			by = builder.buildArray();
		}
		return by;
	}

}
