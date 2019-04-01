package cn.com.syscom.iso8583.baffle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisClusterNode.Flag;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.util.HexUtil;

public class Iso8583Server<T extends IsoMessage>{
	
    protected final Logger logger = LoggerFactory.getLogger(getClass());
     
    private int port; 
    private ServerSocket serverSocket;
    private Socket socket = new Socket();
    private InputStream is = null;
    private OutputStream os = null;
    private Iso8583Decoder iso8583Decoder;
    private IsoMessage isoMessage;
    private final MessageFactory<T> isoMessageFactory;
    private final MessageFactory<T> isoMessageFactoryCup;
    
    @SuppressWarnings("unchecked")
	public Iso8583Server(int port, MessageFactory<T> messageFactory,MessageFactory<T> messageFactoryCup) {
        this.port = port;
        this.isoMessageFactory = messageFactory;
        this.isoMessageFactoryCup = messageFactoryCup;
        this.iso8583Decoder = new Iso8583Decoder((MessageFactory<IsoMessage>) isoMessageFactory, (MessageFactory<IsoMessage>) isoMessageFactoryCup);
        serverSocket = null;
    }
    	   
    @SuppressWarnings("unchecked")
	public void start() throws IOException, InterruptedException
    {
    	serverSocket = new ServerSocket(port);
 
		while (true) {
			
			if (!socket.isConnected()) {
				try {
			    	socket = serverSocket.accept();
					os = socket.getOutputStream();
					logger.info("连接服务器{},端口：{}",socket.getInetAddress(),socket.getPort());

				} catch (Exception e) {
	                try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				is = socket.getInputStream();
	            int size = is.available();
	            if (size <= 0) {
	                continue;
	            }

	            byte[] resp = new byte[size];
	            is.read(resp);

	            if (resp.length > 20) {
	                try {
	             	  // System.out.println(HexUtil.toHexString(resp));
	             	   
	             	   byte[] by = new byte[resp.length - 4];
	             	   System.arraycopy(resp, 4, by, 0, by.length);
	                 	isoMessage = iso8583Decoder.decode(by,2);
	             	   
	                    Iso8583Encoder<?> iso8583Encoder = new Iso8583Encoder<Object>((MessageFactory<IsoMessage>) isoMessageFactoryCup,4);
	                    byte[] b=iso8583Encoder.encode(isoMessage,2);
	                   // System.out.println("-------------------------------");
	                   // System.out.println(HexUtil.toHexString(b));
	                    //Thread.sleep(10000);
/*	                    FileOutputStream fos = new FileOutputStream("cup.bin");
	                    fos.write(b);
	                    fos.close();*/
	                     os.write(b);
	     			} catch (Exception e) {
	     				logger.info("{}", e);
	     				continue;
	     			}
				}    
			
		}
    }
}
