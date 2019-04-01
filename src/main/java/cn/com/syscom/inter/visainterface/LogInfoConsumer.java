package cn.com.syscom.inter.visainterface;

import java.util.concurrent.TimeUnit;

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
import cn.com.syscom.iso8583.impl.SimpleTraceGenerator;
import cn.com.syscom.iso8583.util.TransactionTimer;

public class LogInfoConsumer implements ChannelAwareMessageListener {
	private Logger logger = LoggerFactory.getLogger(LogInfoConsumer.class);
    
    @Resource
    private RabbitTemplate amqpTemplateLog;

    @Resource
    private RabbitTemplate amqpTemplateVisa;
    
    @Resource
    private CustomField63 customField63;
    
    @Resource
    private MessageHashMap messageHashMap;
    
    @Resource
    private MessageFactory<?> isoMessageFactory;
    
    private IsoMessage isoMessage = null;
    private boolean loadFactoryParameter = false;
	Message messagereply;
	MessageProperties messageProperties = new MessageProperties();
	
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		// TODO Auto-generated method stub
		logger.info("收到状态管理通知：{}",new String(message.getBody()));
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

		messageProperties.setExpiration("18000");
		if (new String(message.getBody()).equals("STATUS")) {
			StringBuilder sb = new StringBuilder();
			if (ProcessStatus.boolProcessStatus) {
				sb.append("UP,");
			} else {
				sb.append("DWON,");
			}
			if (ProcessStatus.boolAdviceSignStatus) {
				sb.append("UP");
			} else {
				sb.append("DWON");
			}
			messagereply = new Message(sb.toString().getBytes(), messageProperties);
			amqpTemplateLog.send("visa.rep", messagereply);
			logger.info("当前为{}状态",new String(messagereply.getBody()));
		} else if (new String(message.getBody()).equals("SignOn")) {
			sendNetworkManagementMessage(new IsoValue<Integer>(IsoType.NUMERIC, 71, 3));
		}else if (new String(message.getBody()).equals("SignOff")) {
			sendNetworkManagementMessage(new IsoValue<Integer>(IsoType.NUMERIC, 72, 3));
		}else if (new String(message.getBody()).equals("AdviceSignOn")) {
			sendNetworkManagementMessage(new IsoValue<Integer>(IsoType.NUMERIC, 78, 3));
		}else if (new String(message.getBody()).equals("AdviceSignOff")) {
			sendNetworkManagementMessage(new IsoValue<Integer>(IsoType.NUMERIC, 79, 3));
		}
	}

	public void sendNetworkManagementMessage(IsoValue<?> isoField72) throws InterruptedException
	{
		if (!loadFactoryParameter) {
			isoMessageFactory.setAssignDate(true);
			isoMessageFactory.setSetRetrievalReferenceNumber(true);
			isoMessageFactory.setTraceNumberGenerator(new SimpleTraceGenerator((int)(System.currentTimeMillis() % 100000)));
			
			isoMessage = isoMessageFactory.newMessage(0x800);
			
			if (isoMessageFactory.getCustomField(63) != null) {
				customField63.getIsoMessage().setField(1, new IsoValue<>(IsoType.NUMERIC, 2, 4));
				isoMessage.setValue(63, customField63, isoMessageFactory.getCustomField(63), IsoType.LLLVAR, 0);
			}
			
			HeaderField headerField = new HeaderField();
			int headerLen = 0;
			headerLen = headerField.encodeBinaryField(headerField).length;
			byte[] byteheaderLen = new byte[1];
			byteheaderLen[0] = (byte) (headerLen & 0xFF);
			
	    	int len = 0;
	 		len = isoMessage.getMessageLen() + headerLen;
	 		byte[] byteLen = new byte[2];
	 		byteLen[0] = (byte) ((len >> 8) & 0xFF);  
	 		byteLen[1] = (byte) (len & 0xFF);
			
			headerField.getValues().set(0, new IsoValue<>(IsoType.BINARY, byteheaderLen, 1));
			headerField.getValues().set(3, new IsoValue<>(IsoType.BINARY, byteLen, 2));
			isoMessage.setBinaryIsoHeader(headerField.encodeBinaryField(headerField));
			
			loadFactoryParameter = true;
		}
		
		isoMessage.setField(70, isoField72);
		
		String mapKey= isoMessage.getAt(7).toString() + isoMessage.getAt(11).toString();
        messageHashMap.getIsoMessages().put(mapKey, isoMessage);
        TimerTaskImpl timerTask = new TimerTaskImpl(mapKey,messageHashMap,amqpTemplateVisa,null,null);
        messageHashMap.getMessageTimer().put(mapKey.toString(), timerTask);
        //消息定时器，当消息存入hashmap中时间超过timeout时，并删除map中的该消息
        //new TransactionTimer(mapKey.toString(), 10, TimeUnit.SECONDS, messageHashMap);
        new TransactionTimer(timerTask,mapKey, 3000, TimeUnit.MILLISECONDS, messageHashMap);
        
        
		byte[] byMessage = isoMessage.writeData();
		
		byte[] by = new byte[50];
		byte[] sendBy = new byte[50 + byMessage.length];
		
		System.arraycopy(Constants.RQST_MESSAGE_HEADER.getBytes(), 0, by, 0, Constants.RQST_MESSAGE_HEADER.length());
		System.arraycopy(by, 0, sendBy, 0, Constants.RQST_MESSAGE_HEADER_LENGTH);
		System.arraycopy(byMessage, 0, sendBy, Constants.RQST_MESSAGE_HEADER_LENGTH, byMessage.length);
		
		amqpTemplateVisa.send("VISA_Response", new Message(sendBy, messageProperties));
		Thread.sleep(2000);
		
		StringBuilder sb = new StringBuilder();
		if (ProcessStatus.boolProcessStatus) {
			sb.append("UP,");
		} else {
			sb.append("DWON,");
		}
		if (ProcessStatus.boolAdviceSignStatus) {
			sb.append("UP");
		} else {
			sb.append("DWON");
		}
		messagereply = new Message(sb.toString().getBytes(), messageProperties);
		amqpTemplateLog.send("visa.rep", messagereply);
		logger.info("当前为{}状态",new String(messagereply.getBody()));
	
	}
}
