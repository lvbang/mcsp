package cn.com.syscom.iso8583.baffle;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.MessageFactory;


public class Iso8583Client<T extends IsoMessage>{
	
    private SocketAddress socketAddress;    
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private final MessageFactory<T> isoMessageFactory;
    private final MessageFactory<T> isoMessageFactoryCup;
    private final Socket socker = new Socket();
    private InputStream is = null;
    private OutputStream os = null;
    private Iso8583Decoder iso8583Decoder;
    private IsoMessage isoMessage;
   
    
    
    public Iso8583Client(SocketAddress socketAddress, MessageFactory<T> isoMessageFactory) throws IOException {
    	this.isoMessageFactory = isoMessageFactory;
    	this.isoMessageFactoryCup = isoMessageFactory;
    	this.iso8583Decoder = new Iso8583Decoder((MessageFactory<IsoMessage>) isoMessageFactory, (MessageFactory<IsoMessage>) isoMessageFactoryCup);
        setSocketAddress(socketAddress);
    }
    
    
    public void setSocketAddress(SocketAddress socketAddress) {
        this.socketAddress = socketAddress;
    }


	public SocketAddress getSocketAddress() {
		// TODO Auto-generated method stub
		return socketAddress;
	}
	
    public MessageFactory<T> getIsoMessageFactory() {
        return isoMessageFactory;
    }
    
	@SuppressWarnings("unchecked")
	public void connect() throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-producer.xml");
        //routing key 不同的两个发送消息模板
        RabbitTemplate template = (RabbitTemplate)ctx.getBean("amqpTemplateVisa");
		while (true) {
                if (!socker.isConnected()) { 
						try {
							socker.connect(socketAddress);
							os = socker.getOutputStream();
							logger.info("连接服务器{}", socketAddress);
						} catch (Exception e) {
			                Thread.sleep(1000);
						}
				}
                
                is = socker.getInputStream();
                
                int size = is.available();
                if (size <= 0) {
                    continue;
                }

                byte[] resp = new byte[size];
                is.read(resp);

        	    template.convertAndSend(resp);

                
        	    /* try {
                	isoMessage = iso8583Decoder.decode(resp);
				} catch (Exception e) {
				
					logger.info("{}", e);
				}
                
                               Iso8583Encoder<?> iso8583Encoder = new Iso8583Encoder<Object>(2);
                byte[] b=iso8583Encoder.encode((MessageFactory<IsoMessage>) isoMessageFactory, isoMessage);
                 os.write(b);*/
		}
	}
	
	public byte[] response(byte[] by) throws Exception
	{
   /*         if (!socker.isConnected()) { 
					try {
						socker.connect(socketAddress);
						os = socker.getOutputStream();
						logger.info("连接服务器{}", socketAddress);
					} catch (Exception e) {
		                Thread.sleep(1000);
					}
			}*/
            
           // try {
            	isoMessage = iso8583Decoder.decode(by,2);
/*			} catch (Exception e) {
			
				logger.info("{}", e);
				return null;
			}*/
            
            @SuppressWarnings("unchecked")
			Iso8583Encoder<?> iso8583Encoder = new Iso8583Encoder<Object>((MessageFactory<IsoMessage>) isoMessageFactory,0);
            byte[] b=iso8583Encoder.encode(isoMessage);
            return b;
            // os.write(b);
	}
}
