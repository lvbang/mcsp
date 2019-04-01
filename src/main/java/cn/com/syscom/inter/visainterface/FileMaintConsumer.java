package cn.com.syscom.inter.visainterface;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.rabbitmq.client.Channel;

import cn.com.syscom.iso8583.CustomField63;
import cn.com.syscom.iso8583.HeaderField;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.IsoValue;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.baffle.IsoMessageLoggingHandler;
import cn.com.syscom.iso8583.impl.SimpleTraceGenerator;
import cn.com.syscom.iso8583.util.HexUtil;
import cn.com.syscom.mcsp.service.impl.FileMaintServiceImpl;

public class FileMaintConsumer implements ChannelAwareMessageListener {
	private Logger logger = LoggerFactory.getLogger(FileMaintConsumer.class);
    
    @Resource
    private RabbitTemplate amqpTemplateLog;

    @Resource
    private RabbitTemplate amqpTemplateVisa;
    
    @Resource
    private CustomField63 customField63;
    
    @Resource
    private MessageHashMap messageHashMap;
    
    @Resource
    private FileMaintServiceImpl fileMaintServiceImpl;
	
    private MessageFactory<?> isoMessageFactory = new MessageFactory<>();
	public FileMaintConsumer() {	
		isoMessageFactory.setCharacterEncoding("Cp1047");
		isoMessageFactory.setUseBinaryBitmap(true);
		isoMessageFactory.setUseBinaryMessages(true);
		isoMessageFactory.setCustomField(63, customField63);
		isoMessageFactory.setAssignDate(true);
		isoMessageFactory.setSetRetrievalReferenceNumber(true);
		isoMessageFactory.setTraceNumberGenerator(new SimpleTraceGenerator((int)(System.currentTimeMillis() % 100000)));
		try {
			isoMessageFactory.setConfigPath("j8583_config.xml");
		} catch (IOException e) {
			logger.error("{}",e);
		}
	}
	MessageProperties messageProperties = new MessageProperties();
	
	@Override
	public void onMessage(Message message, Channel channel) {
		try {
		String strFileMaint = new String(message.getBody());

		IsoMessage isoMessageFileMaint=isoMessageFactory.newMessage(0x302);
		
		Date soon = new Date(System.currentTimeMillis());
		isoMessageFileMaint.setField(7, new IsoValue<>(IsoType.DATE10, soon));
		
		String[] arrStrFileMaint = strFileMaint.split(",");
		if (arrStrFileMaint.length > 2) {
			isoMessageFileMaint.setField(2, new IsoValue<>(IsoType.LLNUM,arrStrFileMaint[0], arrStrFileMaint[0].length()));
			isoMessageFileMaint.setField(91, new IsoValue<>(IsoType.ALPHA, arrStrFileMaint[1],1));
			isoMessageFileMaint.setField(101, new IsoValue<>(IsoType.LLVAR, arrStrFileMaint[2], arrStrFileMaint[2].length()));
		}else{
			logger.error("²ÎÊý´íÎó"+strFileMaint);
			return;
		}
		
		IsoMessageLoggingHandler isoMessageLoggingHandler = new IsoMessageLoggingHandler();
		HeaderField headerField = new HeaderField();			
		int headerLen = 0;
		headerLen = headerField.encodeBinaryField(headerField).length;
		byte[] byteheaderLen = new byte[1];
		byteheaderLen[0] = (byte) (headerLen & 0xFF);
		
    	int len = 0;
 		len = isoMessageFileMaint.getMessageLen() + headerLen;
 		byte[] byteLen = new byte[2];
 		byteLen[0] = (byte) ((len >> 8) & 0xFF);  
 		byteLen[1] = (byte) (len & 0xFF);
		
		headerField.getValues().set(0, new IsoValue<>(IsoType.BINARY, byteheaderLen, 1));
		headerField.getValues().set(3, new IsoValue<>(IsoType.BINARY, byteLen, 2));
		isoMessageFileMaint.setBinaryIsoHeader(headerField.encodeBinaryField(headerField));
		
		byte[] byMessage = isoMessageFileMaint.writeData();
		
		byte[] by = new byte[50];
		byte[] sendBy = new byte[50 + byMessage.length];
		
		System.arraycopy(Constants.RQST_MESSAGE_HEADER.getBytes(), 0, by, 0, Constants.RQST_MESSAGE_HEADER.length());
		System.arraycopy(by, 0, sendBy, 0, Constants.RQST_MESSAGE_HEADER_LENGTH);
		System.arraycopy(byMessage, 0, sendBy, Constants.RQST_MESSAGE_HEADER_LENGTH, byMessage.length);
		
		amqpTemplateVisa.send("VISA_Response", new Message(sendBy, messageProperties));
		
		fileMaintServiceImpl.insert(isoMessageFileMaint);
		} catch (Exception e) {
			logger.error("{}",e);
		}finally {
			try {
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			} catch (IOException e) {
				logger.error("{}",e);
			}
		}
	}

}
