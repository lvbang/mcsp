package cn.com.syscom.iso8583.example;

 
import java.awt.event.FocusAdapter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.impl.SimpleTraceGenerator;
import cn.com.syscom.iso8583.parse.ConfigParser;

public class TestSocket {
	   private Socket socket = null;
	    private OutputStream os = null;
	    private InputStream is = null;

	    public static void main(String[] args) {
	        new TestSocket().new SocketThread().start();
	    }

	    
	    class SocketThread extends Thread {

	        @Override
	        public void run() {
	            long startTime = System.currentTimeMillis();
	            while (true) {
	                try {
	                	
	                    if (socket == null || socket.isClosed()) { 
	                        socket = new Socket("192.168.10.137", 8888); 
	                        System.out.println(socket.getPort()+","+socket.getInetAddress());
	                        os = socket.getOutputStream();
	                    }
	                    Thread.sleep(100);
	                    is = socket.getInputStream();
	                    int size = is.available();
	                    if (size <= 0) {
	                        if ((System.currentTimeMillis() - startTime) > 3 * 10 * 1000) { 
	                            socket.close(); 
	                            startTime = System.currentTimeMillis();
	                        }
	                        continue;
	                    } else {
	                        startTime = System.currentTimeMillis();
	                    }
	                    byte[] resp = new byte[size];
	                    is.read(resp);
	                    
	            		FileOutputStream fout = new FileOutputStream("config/test08002.bin");
	                    fout.write(resp);
	                    fout.flush();
	            		
	                    MessageFactory<IsoMessage> mfact = ConfigParser.createFromClasspathConfig("j8583_config.xml");
	            		
	            		mfact.setAssignDate(true);
	            		
	            		mfact.setTraceNumberGenerator(new SimpleTraceGenerator((int)(System.currentTimeMillis() % 100000)));
	                                        
	                  
	            		/*byte[] buf = new byte[2];
	            		buf[0]=resp[0];
	            		buf[1]=resp[1];
	            		int len=resp.length-2;
	            		buf=new byte[len];
	            		for(int i=0;i<len;i++) {
	            			buf[i]=resp[i+2];
	            		}*/
	            		
	            		int len = ((resp[0] & 0xff) << 8) | (resp[1] & 0xff);
	            		byte[] buf = new byte[len];
	            		System.arraycopy(resp, 2, buf, 0, len);            		
	            			            		
	            		mfact.setUseBinaryMessages(true);
	            		IsoMessage m = mfact.parseMessage(buf, 22);
	            		print(m);
	            	
	            		FileOutputStream fout3 = new FileOutputStream("config/test08001.bin");
	            		m.write(fout3, 2);
	                    fout3.flush();	            		

	            		IsoMessage rm = mfact.newMessage(0x810);
	            		rm.setBinary(true);
	            		
	            		//rm = mfact.createResponse(m);
	            		
	            		byte[] newHeader="160102003E9962010000000000000000000000000000".getBytes();
	            		rm.setBinaryIsoHeader(newHeader);
	            		rm.setValue(7, m.getObjectValue(7), IsoType.DATE10, 0);
	            		rm.setValue(11, m.getObjectValue(11), IsoType.NUMERIC, 6);
	            		//rm.setValue(37, m.getObjectValue(37), IsoType.ALPHA, 12);
	            		String str="00";
	            		//rm.setValue(39, AsciiAndEbcdicCodec.ASCIIToEBCDIC(str), IsoType.ALPHA, 2);
	            		rm.setValue(70, m.getObjectValue(70), IsoType.NUMERIC, 3);
	            		print(rm);
	            		FileOutputStream fout2 = new FileOutputStream("config/test08102.bin");
	            		rm.write(fout2, 2);
	            		fout2.close();
	            		
	            		byte[] by = rm.writeToBuffer(2).array();
	                    os.write(by);
	                    System.out.println(socket.getPort()+","+socket.getInetAddress());
	                    
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    try {
	                        socket.close();
	                        is.close();
	                        os.close();
	                    } catch (IOException e1) {
	                        e1.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	    
	    public static void print(IsoMessage m) {
			System.out.println("TYPE: " + Integer.toHexString(m.getType()));
			for (int i = 2; i < 128; i++) {
				if (m.hasField(i)) {
					System.out.println("F " + i + "(" + m.getField(i).getType() + "): " + m.getObjectValue(i) + " -> '"
						+ m.getField(i).toString() + "'");
				}
			}
		}
	    
}
