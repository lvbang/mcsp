package cn.com.syscom.iso8583.example;

 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.parse.ConfigParser;

public class Test0100 {
	   private Socket socket = null;
	    private OutputStream os = null;
	    private InputStream is = null;

	    public static void main(String[] args) {
	        new Test0100().new SocketThread().start();
	    }

	    
	    private class SocketThread extends Thread {

	        @Override
	        public void run() {
	            long startTime = System.currentTimeMillis();
	            while (true) {
	                try {
	                    if (socket == null || socket.isClosed()) { 
	                    	//IP，端口号
	                        socket = new Socket("192.168.10.150", 9999); // 连接socket
	                        System.out.println(socket.getPort()+","+socket.getInetAddress());
	                        os = socket.getOutputStream();
	                    }
	                    Thread.sleep(100);
	                    is = socket.getInputStream();
	                    int size = is.available();
	                    if (size <= 0) {
/*	                        if ((System.currentTimeMillis() - startTime) > 3 * 10 * 1000) { // 如果超过30秒没有收到服务器发回来的信息，说明socket连接可能已经被远程服务器关闭
	                            socket.close(); // 这时候可以关闭socket连接
	                            startTime = System.currentTimeMillis();
	                        }*/
	                        continue;
	                    } else {
	                        startTime = System.currentTimeMillis();
	                    }
	                    byte[] resp = new byte[size];
	                    is.read(resp);
	                    
	            		FileOutputStream fout = new FileOutputStream("config/test0100.bin");
	                    fout.write(resp);
	                    fout.close();
	            		
	                    MessageFactory<IsoMessage> mfact = ConfigParser.createFromClasspathConfig("j8583_config.xml");
	            		//设置工厂是否应在新创建的消息上设置当前日期，在字段7中。默认值为false
	            		//mfact.setAssignDate(true);
	            		//设置此工厂将从中获取新追踪号的生成器
	            		//mfact.setTraceNumberGenerator(new SimpleTraceGenerator((int)(System.currentTimeMillis() % 100000)));
	                    
	                    
	                   /**解析0800报文
	            		 * 按照xml中0800配置进行解析
	            		 */
	            		
	            		int len = ((resp[0] & 0xff) << 8) | (resp[1] & 0xff);
	            		byte[] buf = new byte[len];
	            		
	            		System.arraycopy(resp, 2, buf, 0, len);
	            		
	            		int headerLen = buf[0] & 0xff;
	            		byte[] head = new byte[headerLen];
	            		System.arraycopy(buf, 0, head, 0, headerLen);  

	            		
	            		mfact.setUseBinaryMessages(true);		
	            		mfact.setBinaryIsoHeader(0x100, head);
	            		
	            		IsoMessage m = mfact.parseMessage(buf, headerLen);
	            		
	            		print(m);
	            		m.setBinaryIsoHeader(mfact.getBinaryIsoHeader(0x100));            		
	            		/**组装0110报文
	            		 * 按照xml中0110配置进行组装
	            		 */
	            		IsoMessage rm = mfact.newMessage(0x110);
	            		rm.setBinary(true);
	            		
	            		rm = mfact.createResponse(m);
	            		
//	            		rm.setValue(38, "123456", IsoType.ALPHA, 6);
//	            		rm.setValue(39, "01", IsoType.ALPHA, 2);
//	            		rm.setValue(44, "123456", IsoType.LLVAR, 0);
	            		
	            		len = rm.getMessageLen();
	            		System.out.println(len);
	            		byte[] byteLen = new byte[2];
	            		byteLen[0] = (byte) ((len >> 8) & 0xFF);  
	            		byteLen[1] = (byte) (len & 0xFF);
	            		
	            		System.arraycopy(byteLen, 0, head, 3, 2);
	            		
	            		rm.setBinaryIsoHeader(head);
	            		print(rm);
	            		
	            		byte[] by = rm.writeToBuffer(2).array();
	                    os.write(by);
	                    
	            		FileOutputStream fout2 = new FileOutputStream("2.bin");
	                    fout2.write(by);
	                    fout2.close();
	                    
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

