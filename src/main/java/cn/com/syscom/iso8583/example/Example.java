package cn.com.syscom.iso8583.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.channels.NonWritableChannelException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.data.redis.core.RedisTemplate;

import cn.com.syscom.iso8583.CustomField62;
import cn.com.syscom.iso8583.CustomField63;
import cn.com.syscom.iso8583.CustomFieldTlv;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.codecs.CompositeField;
import cn.com.syscom.iso8583.parse.ConfigParser;
import cn.com.syscom.iso8583.tlv.BerDataset;
import cn.com.syscom.iso8583.tlv.BerTag;
import cn.com.syscom.iso8583.util.HexUtil;
import cn.com.syscom.iso8583.util.TPS;


public class Example {
	
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
		//demo1();
		
		ebcdic2Ascii();

		//ascii2Ebcdic();
		
//		//PARSE Header
//		HeaderField headerField = new HeaderField();
//		headerField.decodeBinaryField(HexUtil.parseHex("111213123131313123123213213213213213213213213213213213213"), 0, 22);
//		//headerField.getValues().set(0, new IsoValue<>(IsoType.BINARY, "a".getBytes(), 1));
//		System.out.println(headerField);
//		
//		
//		System.out.println(FixTlvParser.parseTlvList("AB00212AC003124"));
//		System.out.println(FixTlvParser.parseTlvMap("AB00212AC003124").get("AB"));
//		
//		
//		System.out.println(System.currentTimeMillis());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println(sdf.format(System.currentTimeMillis()));

		
/*        TPS tps = new TPS(10000L,true);
        for (int i=0; i<999; i++)
            tps.tick();
        Thread.sleep (25000L);
        System.out.println(tps.intValue() +"....." +tps.floatValue() +"....." +tps.getAvg()+"...."+tps.getCount());
        Thread.sleep (1000L);
        System.out.println(tps.intValue() +"....." +tps.floatValue() +"....." +tps.getAvg()+"...."+tps.getCount());
        tps.stop();*/


        
/*        TPS tps2 = new TPS();
        for (int i=0; i<1000; i++)
            tps2.tick();
        Thread.sleep (1050L);
        System.out.println(tps2.intValue() +"....." +tps2.floatValue() +"....." +tps2.getAvg()+"...."+tps.getCount());
        Thread.sleep (1000L);
        System.out.println(tps2.intValue() +"....." +tps2.floatValue() +"....." +tps2.getAvg()+"...."+tps.getCount());
        */
		
/*		File file=new File("transmonit");
        FileInputStream fi=new FileInputStream(file);
        ObjectInputStream oos = new ObjectInputStream(fi);
        Vtlf vtlf = (Vtlf) oos.readObject();
        System.out.println(vtlf.getTrancnt());*/
		
//计时器		
/*		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("定时器开始执行");
			}
		}, 5000, 3000);*/
		
		
/*		long t1 = new Date().getTime();
		System.out.println(t1);
		Thread.sleep(10000);
		long t2 =new Date().getTime();
		System.out.println(t2);
		System.out.println(t2-t1);*/
		
/*		RedisTemplate redisTemplate = null;
		redisTemplate.opsForValue().get("aaa");
		redisTemplate.opsForValue().set("aaa", "aaaa");*/
	}

	public static void ascii2Ebcdic()
			throws IOException, FileNotFoundException, ParseException, UnsupportedEncodingException {
		MessageFactory<IsoMessage> mfact = ConfigParser.createFromClasspathConfig("j8583_config.xml");
		IsoMessage m = mfact.newMessage(0x100);

		
//EBCDIC解码
/*				mfact.setUseBinaryMessages(true);
		mfact.setUseBinaryBitmap(true);
		mfact.setCharacterEncoding("Cp1047");
		
		CustomField62 cf62 = new CustomField62();
		cf62.getIsoMessage().setBinary(true);
		cf62.getMf().setUseBinaryMessages(true);
		cf62.getMf().setCharacterEncoding("Cp1047");
		mfact.setCustomField(62,cf62);
		
		CustomField63 cf63 = new CustomField63();
		cf63.getIsoMessage().setBinary(true);
		cf63.getMf().setUseBinaryMessages(true);
		cf63.getMf().setCharacterEncoding("Cp1047");
		mfact.setCustomField(63,cf63);*/
		
/*		CustomFieldTlv cf55 = new CustomFieldTlv();
		mfact.setCustomField(55,cf55);
		
		CustomFieldTlv cf116 = new CustomFieldTlv();
		mfact.setCustomField(116,cf116);
		
		CustomFieldTlv cf120 = new CustomFieldTlv();
		mfact.setCustomField(120,cf120);*/		
		
		//ascii解码
		mfact.setUseBinaryMessages(false);
		mfact.setUseBinaryBitmap(true);
		
		CustomField62 cf62 = new CustomField62();
		 
		cf62.getIsoMessage().setBinary(false);
		cf62.getMf().setUseBinaryMessages(false);
		cf62.getMf().setUseBinaryBitmap(true);
		mfact.setCustomField(62,cf62);
	
		CustomField63 cf63 = new CustomField63();
		cf63.getIsoMessage().setBinary(false);
		cf63.getMf().setUseBinaryMessages(false);
		cf63.getMf().setUseBinaryBitmap(true);
		mfact.setCustomField(63,cf63);	
		
		CustomFieldTlv cf55 = new CustomFieldTlv();
		mfact.setCustomField(55,cf55);
		cf55.setCharacterEncoding("Cp1047");
		
		CustomFieldTlv cf120 = new CustomFieldTlv();
		mfact.setCustomField(120,cf120);
		cf120.setCharacterdecode("GBK");
		cf120.setCharacterEncoding("Cp1047");
/*		Map<Integer, FieldParseInfo> pinfo = mfact.getParseMap().get(0x110);
		pinfo.get(120).setCharacterEncoding("Cp1047");*/
		
		System.out.println("PARSE ASCII FROM FILE");
		byte[] buf = new byte[2];
		FileInputStream fin = new FileInputStream("testascii.bin");
		fin.read(buf);
		int len = ((buf[0] & 0xff) << 8) | (buf[1] & 0xff);
		buf = new byte[len];
		fin.read(buf);
		fin.close();

		m = mfact.parseMessage(buf, 22);
//		m.updateValue(60, "你好");
//		
		CompositeField cs59 = m.getObjectValue(59);
		CompositeField cs59_1 = cs59.getObjectValue(3);

		
		
		System.out.println(cs59.getValues().toString());
//		System.out.println(cs59.getValues().set(1, new IsoValue<String>(IsoType.ALPHA,"aaa",3)));
//		System.out.println(cs59_1.getValues().size());
//		System.out.println(cs59_1.getValues().set(1, new IsoValue<String>(IsoType.ALPHA,"b",1)));
//		
		cf62.print();
		cf63.print();
//		cf120.tlvs.addTlv(1, new BerTlv(new BerDataset(0x56), new BerTag(0x06), "abc".getBytes()));
//		System.out.println(cf55.tlvs.find(new BerDataset(0x01),new BerTag((new byte[]{(byte) 0x9F, 0x33}))).getHexValue());
//		cf55.tlvs.update(new BerDataset(0x01),new BerTag((new byte[]{(byte) 0x9F, 0x33})), HexUtil.parseHex("112233"));
/*		System.out.println(cf55.tlvs.find(new BerDataset(0x01),new BerTag((new byte[]{(byte) 0x9F, 0x33}))).getHexValue());
		System.out.println(cf120.tlvs.getList().get(1).getCharacterEncoding());
		System.out.println(cf55.tlvs);*/
		//m.updateValue(60, "aaa");
		
//		CompositeField f = new CompositeField().addValue(new IsoValue<String>(IsoType.ALPHA, "one", 5))
//			    .addValue(new IsoValue<String>(IsoType.LLVAR, "two"))
//			    .addValue(new IsoValue<Long>(IsoType.NUMERIC, 123l, 6))
//			    .addValue(new IsoValue<String>(IsoType.ALPHA, "OK", 2));
//			m.setValue(125, f, f, IsoType.LLLVAR, 0);
//			
//		m.setValue(5, "aa", IsoType.BINARY, 4);
		print(m);
		
		CompositeField cs60 = m.getObjectValue(60);
		System.out.println("F 60:" + cs60.getValues());
		System.out.println(cf120.tlvs);
		
		
		System.out.println(cf55.tlvs.getList().get(1).getTextValue());
		System.out.println(cf55.tlvs.getList().get(1).getHexValue());
		
		
		IsoMessage rm = mfact.createResponse(m);
		rm.setType(0x0110);
		
//		print(rm);
//		m.setBinary(true);
//		m.setCharacterEncoding("GBK");
//		m.setBinaryIsoHeader(m.getIsoHeader().getBytes("cp1047"));
		
		//ASCII格式报文
/*		rm.setBinary(false);
		rm.setCharacterEncoding("gbk");
		cf62.getIsoMessage().setBinary(false);
		cf63.getIsoMessage().setBinary(false);
		cf62.getIsoMessage().setCharacterEncoding("gbk");
		cf63.getIsoMessage().setCharacterEncoding("gbk");
		rm.setBinaryIsoHeader(m.getIsoHeader().getBytes());
		FileOutputStream fout = new FileOutputStream("testascii1.bin");
		rm.write(fout, 2);
		fout.close();*/

		//二进制EBCDIC格式报文
		rm.setBinary(true);
		rm.setCharacterEncoding("cp1047");
		cf62.getIsoMessage().setBinary(true);
		cf63.getIsoMessage().setBinary(true);
		cf62.getIsoMessage().setCharacterEncoding("cp1047");
		cf63.getIsoMessage().setCharacterEncoding("cp1047");
		cf55.setCharacterdecode("Cp1047");
		cf120.setCharacterdecode("Cp1047");
		
		rm.setBinaryIsoHeader(m.getIsoHeader().getBytes());
		FileOutputStream fout = new FileOutputStream("testebcdic.bin");
		rm.write(fout, 2);
		fout.close();
	}

	public static void ebcdic2Ascii()
			throws IOException, FileNotFoundException, ParseException, UnsupportedEncodingException {
		MessageFactory<IsoMessage> mfact = ConfigParser.createFromClasspathConfig("j8583_config.xml");
		//IsoMessage m = mfact.newMessage(0x100);

//EBCDIC解码
				mfact.setUseBinaryMessages(true);
		mfact.setUseBinaryBitmap(true);
		mfact.setCharacterEncoding("Cp1047");
		
		CustomField62 cf62 = new CustomField62();
		cf62.getMf().setUseBinaryMessages(true);
		cf62.getMf().setCharacterEncoding("Cp1047");
		mfact.setCustomField(62,cf62);
		
		
		
		CustomField63 cf63 = new CustomField63();
		cf63.setDeUseBinary(true);
		cf63.getMf().setUseBinaryMessages(true);
		cf63.getMf().setCharacterEncoding("Cp1047");
		mfact.setCustomField(63,cf63);
		
		CustomFieldTlv cf55 = new CustomFieldTlv();
		mfact.setCustomField(55,cf55);
		cf55.setCharacterEncoding("Cp1047");
		
//		CustomFieldTlv cf116 = new CustomFieldTlv();
//		mfact.setCustomField(116,cf116);
		
		CustomFieldTlv cf120 = new CustomFieldTlv();
		mfact.setCustomField(120,cf120);
		cf120.setCharacterdecode("Cp1047");
		cf120.setCharacterEncoding("GBK");
		
		//ascii解码
/*		mfact.setUseBinaryMessages(false);
		mfact.setUseBinaryBitmap(true);
		
		CustomField62 cf62 = new CustomField62();
		cf62.getIsoMessage().setBinary(false);
		cf62.getMf().setUseBinaryMessages(false);
		cf62.getMf().setUseBinaryBitmap(true);
		mfact.setCustomField(62,cf62);
		
		CustomField63 cf63 = new CustomField63();
		cf63.getIsoMessage().setBinary(false);
		cf63.getMf().setUseBinaryMessages(false);
		cf63.getMf().setUseBinaryBitmap(true);
		mfact.setCustomField(63,cf63);	*/
		
		System.out.println("PARSE BINARY FROM FILE");
		byte[] buf = new byte[2];
		FileInputStream fin = new FileInputStream("testebcdic.bin");
		fin.read(buf);
		int len = ((buf[0] & 0xff) << 8) | (buf[1] & 0xff);
		buf = new byte[len];
		fin.read(buf);
		fin.close();

		IsoMessage m = mfact.parseMessage(buf, 22,true);
//		m.updateValue(60, "你好");
//		
		CompositeField cs59 = m.getObjectValue(59);
//		CompositeField cs59_1 = cs59.getObjectValue(3);
//		CompositeField cs60 = m.getObjectValue(60);
		
		System.out.println(cs59.getValues().toString());
//		System.out.println(cs60.getValues());
//		System.out.println(cs59.getValues().set(1, new IsoValue<String>(IsoType.ALPHA,"aaa",3)));
//		System.out.println(cs59_1.getValues().size());
//		System.out.println(cs59_1.getValues().set(1, new IsoValue<String>(IsoType.ALPHA,"b",1)));
//		
		cf62.print();
		cf63.print();
		System.out.println(cf120.tlvs.getList().get(1).getTextValue());
		System.out.println(cf120.tlvs.find(new BerDataset(0x56), new BerTag(0x02)));
		System.out.println(cf120.tlvs);

		System.out.println(cf55.tlvs);
		//m.updateValue(60, "aaa");
		
//		CompositeField f = new CompositeField().addValue(new IsoValue<String>(IsoType.ALPHA, "one", 5))
//			    .addValue(new IsoValue<String>(IsoType.LLVAR, "two"))
//			    .addValue(new IsoValue<Long>(IsoType.NUMERIC, 123l, 6))
//			    .addValue(new IsoValue<String>(IsoType.ALPHA, "OK", 2));
//			m.setValue(125, f, f, IsoType.LLLVAR, 0);
//			
//		m.setValue(5, "aa", IsoType.BINARY, 4);
//		m.setField(8, new IsoValue<Long>(IsoType.NUMERIC,12345678l,8));
		
		print(m);
		
/*		CompositeField cs60 = m.getObjectValue(60);
		System.out.println(m.getField(60));
		System.out.println(cs60.getField(0));*/
		
		IsoMessage rm = mfact.createResponse(m);
		rm.setType(0x0110);
		
//		print(rm);
//		m.setBinary(true);
//		m.setCharacterEncoding("GBK");
//		m.setBinaryIsoHeader(m.getIsoHeader().getBytes("cp1047"));
		
		//ASCII格式报文		
		rm.setBinary(false);
		//rm.setCharacterEncoding("gbk");
		rm.setCharacterEncoding("GBK");
		cf62.getIsoMessage().setBinary(false);
		cf63.getIsoMessage().setBinary(false);
		cf62.getIsoMessage().setCharacterEncoding("gbk");
		cf63.getIsoMessage().setCharacterEncoding("gbk");
		
		System.out.println(cf63);
		System.out.println(cf63.encodeField(cf63));
		rm.setBinaryIsoHeader(m.getBinaryIsoHeader());

		FileOutputStream fout = new FileOutputStream("testascii.bin");
		rm.write(fout, 2);
		fout.close();
		
		//二进制EBCDIC格式报文
/*		rm.setBinary(true);
		rm.setCharacterEncoding("cp1047");
		cf62.getIsoMessage().setBinary(true);
		cf63.getIsoMessage().setBinary(true);
		cf62.getIsoMessage().setCharacterEncoding("cp1047");
		cf63.getIsoMessage().setCharacterEncoding("cp1047");
		rm.setBinaryIsoHeader(m.getBinaryIsoHeader());
		FileOutputStream fout = new FileOutputStream("testebcdic.bin");
		rm.write(fout, 2);
		fout.close();*/
	}

	public static void demo1() throws IOException, ParseException{
		MessageFactory<IsoMessage> mfact = ConfigParser.createFromClasspathConfig("j8583_config.xml");
		mfact.setUseBinaryMessages(true);
		mfact.setUseBinaryBitmap(true);
		mfact.setCharacterEncoding("Cp1047");
		
		CustomFieldTlv cf55 = new CustomFieldTlv();
		mfact.setCustomField(55,cf55);
		cf55.setCharacterEncoding("Cp1047");
		
		CustomField62 cf62 = new CustomField62();
		cf62.getIsoMessage().setBinary(true);
		cf62.getMf().setUseBinaryMessages(true);
		cf62.getMf().setCharacterEncoding("Cp1047");
		mfact.setCustomField(62,cf62);
		
		CustomField63 cf63 = new CustomField63();
		cf63.getIsoMessage().setBinary(true);
		cf63.getMf().setUseBinaryMessages(true);
		cf63.getMf().setCharacterEncoding("Cp1047");
		mfact.setCustomField(63,cf63);
		
		System.out.println("PARSE BINARY FROM FILE");
		//byte[] buf = new byte[2];
		FileInputStream fin = new FileInputStream("test0100.bin");
		byte[] buf = new byte[fin.available()];
		fin.read(buf);
		int len = ((buf[0] & 0xff) << 8) | (buf[1] & 0xff);
/*		buf = new byte[len];
		fin.read(buf);*/
		fin.close();

		IsoMessage m = mfact.parseMessage(buf, 22,true);
		cf62.print();
		cf63.print();
		
		CompositeField cs60 = m.getObjectValue(60);
		System.out.println("F 60:" + cs60.getValues());
		print(m);
		
		IsoMessage rm = mfact.createResponse(m);
		rm.setField(39, IsoType.ALPHA.value("01", 2));
		rm.setType(0x0110);
		print(rm);
		
		System.out.println(rm.getField(63).toString());
		cf63.decodeField(rm.getField(63).toString());
		cf63.print();
		
		
		
		rm.setBinary(true);
		rm.setCharacterEncoding("cp1047");
		cf55.setCharacterdecode("Cp1047");
		cf62.getIsoMessage().setBinary(true);
		cf63.getIsoMessage().setBinary(true);
		cf62.getIsoMessage().setCharacterEncoding("cp1047");
		cf63.getIsoMessage().setCharacterEncoding("cp1047");
		
		rm.setBinaryIsoHeader(m.getBinaryIsoHeader());
		len = rm.getMessageLen();
		byte[] byteLen = new byte[2];
		byteLen[0] = (byte) ((len >> 8) & 0xFF);  
		byteLen[1] = (byte) (len & 0xFF);
		//替换head中的报文长度
		byte[] head = m.getBinaryIsoHeader();
		System.arraycopy(byteLen, 0, head, 3, 2);
		rm.setBinaryIsoHeader(head);

		
		FileOutputStream fout = new FileOutputStream("test0110.bin");
		rm.write(fout, 2);
		fout.close();
	}

}
