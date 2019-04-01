package cn.com.syscom.iso8583;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;

import cn.com.syscom.iso8583.util.HexUtil;

public class CustomField62 implements CustomField<CustomField62> , Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private byte[] mValue;
	
	//解报文是否二进制格式
	private boolean deUseBinary;
	//解报文bitmap是否二进制格式
    private boolean deBinBitmap;
    //解报文的字符编码
	private String deEncoding = System.getProperty("file.encoding");
	
	//组报文是否二进制格式
	private boolean enUseBinary;
	//组报文bitmap是否二进制格式
    private boolean enBinBitmap;
    //组报文的字符编码
	private String enEncoding = System.getProperty("file.encoding");
	
	private MessageFactory<IsoMessage> mf;
	
	private IsoMessage m62;
	
	public CustomField62() {
		super();
		// TODO Auto-generated constructor stub
		m62 = new IsoMessage();
		mf = new MessageFactory<IsoMessage>();
	}

	public MessageFactory<IsoMessage> getMf() {
		return mf;
	}
	
	public IsoMessage getIsoMessage() {
		return m62;
	}

	public void init(byte[] by) throws IOException, ParseException {
		//mf.setCharacterEncoding("Cp1047");
		mf.setConfigPath("field62_config.xml");
		mf.setUseBinaryMessages(deUseBinary);
		mf.setCharacterEncoding(deEncoding);
		m62 = mf.parseCustomField(by, 0, false);
		
	}
	
	public byte[] getIsomessage(String value) throws IOException {
		if(value == null) {
			return null;
		}

		byte[] by62Type =null;
			by62Type = new byte[]{(byte)0x00,(byte)0x62};

		byte[] by62Value = null;
		by62Value = value.getBytes("Cp1047");
		byte[] by62 = new byte[by62Type.length + by62Value.length];
		System.arraycopy(by62Type,0,by62,0,by62Type.length);
		System.arraycopy(by62Value,0,by62,by62Type.length,by62Value.length);
		
		return by62;
	}
	@Override
	public CustomField62 decodeField(String value) {
		mf.setCharacterEncoding(deEncoding);
		mf.setUseBinaryMessages(deUseBinary);
		CustomField62 cf = null;
		if (value != null) {
			cf = new CustomField62();
			try {
				byte[] by62= getIsomessage(value);
				init(by62);
				mValue = m62.writeData();
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cf.setM62(m62);
		return cf;
	}

	@Override
	public String encodeField(CustomField62 value) {
//		StringBuilder sb = new StringBuilder();
//		if (value.getValue1() != null) {
//			sb.append(value.getValue1());
//		}
//		sb.append('|');
//		sb.append(value.getValue2());
//		return sb.toString();
		//byte[] by = value.m62.writeData();
		m62.setBinary(enUseBinary);
		m62.setCharacterEncoding(enEncoding);
		value.mValue = m62.customFieldWriteData();
		try {
			return new String(value.mValue,"Cp1047");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof CustomField62)) {
			return false;
		}
		CustomField62 other = (CustomField62)obj;
		return false;
	}

	@Override
	public int hashCode() {
	//	return (v1 == null ? 0 : v1.hashCode()) | v2;
		return 0;
	}

    public void print() {
		System.out.print("Field62: ");
		for (int i = 1; i < 64; i++) {
			if (m62.hasField(i)) {
				System.out.println("F " + i + "(" + m62.getField(i).getType() + "): " + m62.getObjectValue(i) + " -> '"
					+ m62.getField(i).toString() + "'");
			}
		}
	}

	@Override
	public CustomField62 decodeBinaryField(byte[] value, int offset, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] encodeBinaryField(CustomField62 value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setmValue(byte[] mValue) {
		this.mValue = mValue;
	}

	public void setDeUseBinary(boolean deUseBinary) {
		this.deUseBinary = deUseBinary;
		mf.setUseBinaryMessages(deUseBinary);
	}

	public void setDeBinBitmap(boolean deBinBitmap) {
		this.deBinBitmap = deBinBitmap;
		mf.setUseBinaryBitmap(deBinBitmap);
	}

	public void setDeEncoding(String deEncoding) {
		this.deEncoding = deEncoding;
		mf.setCharacterEncoding(deEncoding);
	}

	public void setEnUseBinary(boolean enUseBinary) {
		this.enUseBinary = enUseBinary;
		m62.setBinary(enUseBinary);
	}

	public void setEnBinBitmap(boolean enBinBitmap) {
		this.enBinBitmap = enBinBitmap;
		m62.setBinaryBitmap(enBinBitmap);
	}

	public void setEnEncoding(String enEncoding) {
		this.enEncoding = enEncoding;
		m62.setCharacterEncoding(enEncoding);
	}

	public void setMf(MessageFactory<IsoMessage> mf) {
		this.mf = mf;
	}

	public void setM62(IsoMessage m62) {
		this.m62 = m62;
	}
}
