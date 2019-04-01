package cn.com.syscom.iso8583.baffle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import cn.com.syscom.iso8583.CustomFieldTlv;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.parse.ConfigParser;


public class Test {

	
	public static void print(IsoMessage m) {
		System.out.println("TYPE: " + Integer.toHexString(m.getType()));
		for (int i = 2; i < 128; i++) {
			if (m.hasField(i)) {
				System.out.println("F " + i + "(" + m.getField(i).getType() + "): " + m.getObjectValue(i) + " -> '"
					+ m.getField(i).toString() + "'");
			}
		}
	}
	

	public static void main(String[] args) throws Exception {
		
/*		Iso8583Client<IsoMessage> iso8583Client;
		Iso8583ClientConfig iso8583ClientConfig = new Iso8583ClientConfig();
		iso8583Client = iso8583ClientConfig.iso8583Client();
		System.out.println(iso8583Client.getSocketAddress());*/
		

		//挡板为客户端
/*		AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(Iso8583ClientConfig.class);	
		Iso8583Client<?> iso8583Client = applicationContext2.getBean(Iso8583Client.class);
		Iso8583Client<?> iso8583Client2 = applicationContext2.getBean(Iso8583Client.class);*/
		/*		iso8583Client.connect();
		applicationContext2.close();*/

		//挡板为服务端
		AnnotationConfigApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(Iso8583ServerConfig.class);
		Iso8583Server iso8583Server = applicationContext2.getBean(Iso8583Server.class);
		iso8583Server.start();	
		applicationContext2.close();

	
	}

	public static void baffleTest()
			throws IOException, FileNotFoundException, ParseException, UnsupportedEncodingException {
		// TODO Auto-generated method stub

		MessageFactory<IsoMessage> mfact = ConfigParser.createFromClasspathConfig("j8583_config.xml");
		mfact.setUseBinaryMessages(true);
		mfact.setUseBinaryBitmap(true);
		mfact.setCharacterEncoding("Cp1047");
		
		CustomFieldTlv cf55 = new CustomFieldTlv();
		mfact.setCustomField(55,cf55);
		cf55.setCharacterEncoding("Cp1047");
		
		System.out.println("PARSE BINARY FROM FILE");
		byte[] buf = new byte[2];
		FileInputStream fin = new FileInputStream("test0100.bin");
		fin.read(buf);
		int len = ((buf[0] & 0xff) << 8) | (buf[1] & 0xff);
		buf = new byte[len];
		fin.read(buf);
		fin.close();

		IsoMessage m = mfact.parseMessage(buf, 22,true);
		
		print(m);
		
		IsoMessage rm = mfact.createResponse(m);
		rm.setField(39, IsoType.ALPHA.value("01", 2));
		rm.setType(0x0110);
		print(rm);
		
		rm.setBinary(true);
		rm.setCharacterEncoding("cp1047");
		
		
		rm.setBinaryIsoHeader(m.getBinaryIsoHeader());
		len = rm.getMessageLen();
		byte[] byteLen = new byte[2];
		byteLen[0] = (byte) ((len >> 8) & 0xFF);  
		byteLen[1] = (byte) (len & 0xFF);
		//替换head中的报文长度
		byte[] head = m.getBinaryIsoHeader();
		System.arraycopy(byteLen, 0, head, 3, 2);
		rm.setBinaryIsoHeader(head);

		
/*		FileOutputStream fout = new FileOutputStream("test0110.bin");
		rm.write(fout, 2);
		fout.close();*/
	}

}
