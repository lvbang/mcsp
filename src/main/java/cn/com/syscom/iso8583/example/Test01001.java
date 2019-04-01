package cn.com.syscom.iso8583.example;

 
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.codecs.CompositeField;
import cn.com.syscom.iso8583.parse.ConfigParser;
import cn.com.syscom.iso8583.util.HexUtil;

public class Test01001 {
	   private Socket socket = null;
	    private OutputStream os = null;
	    private InputStream is = null;

	    public static void main(String[] args) throws Exception {
           MessageFactory<IsoMessage> mfact = ConfigParser.createFromClasspathConfig("j8583_config.xml");
    		//设置工厂是否应在新创建的消息上设置当前日期，在字段7中。默认值为false
    		//mfact.setAssignDate(true);
    		//设置此工厂将从中获取新追踪号的生成器
    		//mfact.setTraceNumberGenerator(new SimpleTraceGenerator((int)(System.currentTimeMillis() % 100000)));   		
            
           /**解析0800报文
    		 * 按照xml中0800配置进行解析
    		 */
			//MessageFactory<IsoMessage> mfact = new MessageFactory<IsoMessage>();
    		byte[] resp = new byte[2];
    		FileInputStream  fin = new FileInputStream("config/test0100.bin");
    		//FileInputStream fin = new FileInputStream("4.bin");
    		fin.read(resp);
    		int len = ((resp[0] & 0xff) << 8) | (resp[1] & 0xff);

    		resp = new byte[len];
    		fin.read(resp);
    		fin.close();
    				
    		int headerLen = resp[0] & 0xff;
    		byte[] head = new byte[headerLen];
    		System.arraycopy(resp, 0, head, 0, headerLen);  
    		
	
    		mfact.setUseBinaryMessages(true);		
    		mfact.setBinaryIsoHeader(0x100, head);
/*    		CustomField62 cf1 = new CustomField62();
    		mfact.setCustomField(62,cf1);
    		
    		CustomField63 cf63 = new CustomField63();
    		mfact.setCustomField(63,cf63);*/
    		
    		//CustomFieldTlv cf55 = new CustomFieldTlv();
    		//mfact.setCustomField(55,cf55);
    		
    		//CustomFieldTlv cf120 = new CustomFieldTlv();
    		//mfact.setCustomField(120,cf120);
    		
    		IsoMessage m = mfact.parseMessage(resp, headerLen);
    		//mfact.setCharacterEncoding("Cp1047");
    		m.setBinary(true);

    		//cf1.getIsoMessage().setValue(1,"A", IsoType.ALPHA, 1);
    		//cf1.print();
    		//m.setValue(3, 123456, IsoType.NUMERIC, 6);
    		//m.setValue(5, "abcdefgk", IsoType.LLVAR, 0);
    		//m.setValue(8, "abcdefgk", IsoType.LLVAR, 0);
    		//m.setValue(33, "ABCDEFG", IsoType.LLBIN, 0);
    		print(m);
    		
    		CompositeField cs60 = m.getObjectValue(60);
    		System.out.println(HexUtil.toHexString(m.getField(60).toString().getBytes("Cp1047")));
    		System.out.println(m.getField(60));
    		System.out.println(cs60.getField(0));
    		//System.out.println(cf55.tlvs.toString());
    		
    		//System.out.println(cf55.tlvs.getList().get(0).getHexValue());
    		

 //   		System.out.println(cf120.tlvs.toString());
    		
    		//System.out.println(HexUtil.toHexString(cf55.tlvs.getList().get(0).getTextValue().getBytes("cp1047")));
    		

//    		CompositeField cf = m.getObjectValue(62);
//    		System.out.println(cf.getValues().size());
//    		System.out.println(cf.getField(0));
//    		System.out.println(cf.getField(1));
//    		System.out.println(cf.getField(2));

//    		System.out.println(cf.getValues());
    		
    		
//    		cf = m.getObjectValue(3);
//    		System.out.println(cf.getValues().size());
//    		System.out.println(cf.getField(0));
//    		System.out.println(cf.getField(1));
//    		System.out.println(cf.getField(2));

    		
    		m.setBinaryIsoHeader(mfact.getBinaryIsoHeader(0x100));            		
    		/**组装0110报文
    		 * 按照xml中0110配置进行组装
    		 */
    		IsoMessage rm = mfact.createResponse(m);
    		rm.setBinary(true);
    		//rm = mfact.createResponse(m);
    		rm.setType(0x110);
//    		rm.setValue(38, "123456", IsoType.ALPHA, 6);
//    		rm.setValue(39, "01", IsoType.ALPHA, 2);
//    		rm.setValue(44, "123456", IsoType.LLVAR, 0);
    		
//    		cf = rm.getObjectValue(62);
//    		System.out.println(cf.getValues().size());
//    		System.out.println(cf.getField(0));
//    		System.out.println(cf.getField(1));
//    		System.out.println(cf.getField(2));
//    		
//    		System.out.println(cf.getValues());
    		
    		
    		len = rm.getMessageLen();
    		byte[] byteLen = new byte[2];
    		byteLen[0] = (byte) ((len >> 8) & 0xFF);  
    		byteLen[1] = (byte) (len & 0xFF);
    		
    		//替换head中的报文长度
    		System.arraycopy(byteLen, 0, head, 3, 2);
    		
    		rm.setBinaryIsoHeader(head);
    		//cf1.getIsoMessage().setValue(2, 12233435, IsoType.NUMERIC, 15);
    		//cf1.print();
    		print(rm);
    		
    		rm.setForceStringEncoding(true);
    		//rm.removeFields(55,60,62,63,116,120);
    		rm.setBinary(false);
    		rm.setBinaryBitmap(true);


    		byte[] by= rm.writeToBuffer(2).array();
    		FileOutputStream fos = new FileOutputStream("test01002.bin");
    		fos.write(by);
    		fos.close();
    		
    		
    		
//    		byte[] by62Type = new byte[]{0x00, (byte)0x62};
//    		byte[] by62Value = rm.getField(62).toString().getBytes("Cp1047");
//    		byte[] by62 = new byte[by62Type.length + by62Value.length];
//    		System.arraycopy(by62Type,0,by62,0,by62Type.length);
//    		System.arraycopy(by62Value,0,by62,by62Type.length,by62Value.length);
    		
//    		FileOutputStream fos2 = new FileOutputStream("field104.bin");
//    		fos2.write(m.getField(104).toString().getBytes("Cp1047"));
//    		fos2.close();
    		
    		//MessageFactory<IsoMessage> mf62 = new MessageFactory<IsoMessage>();
//    		IsoMessage m62 = mfact.parseCustomField(by62, 0, false);
//    		m62.updateValue(1, "A");
 //   		print(m62);
	    }
	    
	    public static void print(IsoMessage m) {
			System.out.println("TYPE: " + Integer.toHexString(m.getType()));
			for (int i = 1; i < 128; i++) {
				if (m.hasField(i)) {
					System.out.println("F " + i + "(" + m.getField(i).getType() + "): " + m.getObjectValue(i) + " -> '"
						+ m.getField(i).toString() + "'");
				}
			}
		}
	    
}


