package cn.com.syscom.iso8583.tlv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("field104.bin");
		byte[] by = new byte[fis.available()];
		fis.read(by);
		System.out.println(HexUtil.toHexString(by));

		// TODO Auto-generated method stub
		  byte[] bytes = HexUtil.parseHex("01001C1F01043149534157131000023100000033D44122011003400000481F5");

		//  final BerTlvLoggerSlf4j LOG = new BerTlvLoggerSlf4j();

		  BerTlvParser parser = new BerTlvParser();
		//  BerTlvs tlvs = parser.parse(by, 3, 15);
		  BerTlvs tlvs = parser.parse(by,null,null);
		//  tlvs.getList().set(1, new BerTlv(new BerDataset(0x02), new BerTag(0x01), "sfd".getBytes("Cp1047")));
		  BerDataset a = new BerDataset(0x01);
		 // tlvs.getList().add(0, new BerTlv(a,new BerTag(0x02), "abc".getBytes("Cp1047")));
		  tlvs.addTlv(1, new BerTlv(a,new BerTag(0x02), "abc".getBytes("Cp1047")));

		  //tlvs.getList().set(0, new BerTlv(new BerTag(0x9F1A), "aaa".getBytes()));
		  System.out.println(tlvs.find(new BerTag((new byte[]{(byte) 0x9F, 0x1A}))));
		  System.out.println(tlvs.find(new BerDataset(0x02), new BerTag(0x01)));
		//  tlvs.update(new BerDataset(0x02), new BerTag(0x01),"aa".getBytes("Cp1047"));
		//  System.out.println(tlvs.find(new BerTag(0x9F, 0x1A)));
		//  System.out.println(tlvs.find(new BerTag(0x02)));
		  System.out.println(tlvs.toString());
		//  BerTlvLogger.log("    ", tlvs, LOG);
		  
	        BerTlvBuilder builder = new BerTlvBuilder(tlvs);

	        System.out.println(HexUtil.toHexString(builder.buildArray()));
	}

}
