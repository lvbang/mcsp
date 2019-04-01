package cn.com.syscom.iso8583.example;

import java.awt.print.Printable;
import java.io.IOException;

import cn.com.syscom.iso8583.CustomField62;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.MessageFactory;

public class testCustomField {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//MessageFactory<IsoMessage> mf = ConfigParser.createFromClasspathConfig("config.xml");
		MessageFactory<IsoMessage> mf;
		mf = new MessageFactory<IsoMessage>();
		mf.setCharacterEncoding("UTF-8");
		mf.setCustomField(48, new CustomField62());
		mf.setConfigPath("config.xml");
		
		IsoMessage iso1 = mf.newMessage(0x200);
		
		print(iso1);
		CustomField62 cf48_1 = iso1.getObjectValue(48);
//		cf48_1.setValue2(origv + 1000);
//		CustomField62 cf48_2 = iso1.getObjectValue(48);
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
