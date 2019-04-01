package cn.com.syscom.inter.visainterface;

import java.io.ObjectInputStream.GetField;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.data.redis.core.RedisTemplate;

import com.rabbitmq.client.Channel;

import cn.com.syscom.iso8583.CustomField;
import cn.com.syscom.iso8583.CustomField62;
import cn.com.syscom.iso8583.CustomField63;
import cn.com.syscom.iso8583.CustomFieldTlv;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.baffle.Iso8583Decoder;
import cn.com.syscom.iso8583.baffle.Iso8583Encoder;
import cn.com.syscom.iso8583.tlv.BerTag;
import cn.com.syscom.iso8583.util.HexUtil;
import cn.com.syscom.iso8583.util.MessageTemplate;
import cn.com.syscom.iso8583.util.Serializer;
import cn.com.syscom.iso8583.util.TPS;
import cn.com.syscom.mcsp.service.impl.FileMaintServiceImpl;
import cn.com.syscom.mysql.model.FileMaint;
import cn.com.syscom.mysql.model.FileMaintExample;


public class VisaConsumerQFirst implements ChannelAwareMessageListener {
    private Logger logger = LoggerFactory.getLogger(VisaConsumerQFirst.class);
    @Resource
    private AmqpTemplate amqpTemplateVisa;
    @Resource   
    private AmqpTemplate amqpTemplateVisaToESB;
    @Resource
    private MessageHashMap messageHashMap;

 //   private IsoMessage isoMessage;
    
    @Resource
    private Iso8583Decoder iso8583Decoder;
    
    @Resource
    private Iso8583Encoder<?> iso8583Encoder;
    
    @Resource
    private CustomField63 customField63;
    
    @Resource
    private TPS tps;
   
    @Resource
    private FileMaintServiceImpl fileMaintServiceImpl;
    
	@SuppressWarnings("unused")
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
        try {
        	logger.info(MessageTemplate.MSG_VISA_INTER_LOG +"Q1接收到消息：" + HexUtil.toHexString(message.getBody()));
        	//前50个字节为网络匹配码，需返回给VisaRespQueue
        	byte[] bNetworkMatch = new byte[Constants.RQST_MESSAGE_HEADER_LENGTH];
        	byte[] visaMessage = new byte[message.getBody().length - Constants.RQST_MESSAGE_HEADER_LENGTH];
        	
        	System.arraycopy(message.getBody(), 0, bNetworkMatch, 0, Constants.RQST_MESSAGE_HEADER_LENGTH);
        	System.arraycopy(message.getBody(), Constants.RQST_MESSAGE_HEADER_LENGTH, visaMessage, 0, visaMessage.length);
        	
        	IsoMessage isoMessage = iso8583Decoder.decode(visaMessage,1);
        	
 /*       	CustomFieldTlv field55 = new CustomFieldTlv();
        	byte[] byField55 = (byte[]) isoMessage.getField(55).getValue();
        	field55.decodeBinaryField(byField55, 0, byField55.length);
        	System.out.println(field55.tlvs);
        	System.out.println(field55.tlvs.find(new BerTag(HexUtil.parseHex("9F26"))).getHexValue());
        
        	//field55.decodeBinaryField(isoMessage.getField(55).getValue(), 0, );
*/        	
            isoMessage.setBeginVisaTime(new Date().getTime());
            isoMessage.setNetworkMatch(bNetworkMatch);
		
            if (isoMessage == null) {
				logger.error(MessageTemplate.MSG_VISA_INTER_LOG +"解报文出错{}",HexUtil.toHexString(message.getBody()));
	            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
				return;
			}
            byte[] by = null;
            if (isoMessage.getType() == 0x800) {
            	if (isoMessage.getAt(70).toString().equals("071")) {
            		logger.info(MessageTemplate.MSG_VISA_INTER_LOG +"收到签到报文");
                	ProcessStatus.boolProcessStatus = true;
				} else if (isoMessage.getAt(70).toString().equals("072")) {
					logger.info(MessageTemplate.MSG_VISA_INTER_LOG +"收到签退报文");
					ProcessStatus.boolProcessStatus = false;
				}
            	isoMessage.setValue(39, "01", IsoType.ALPHA, 2);
				logger.info(MessageTemplate.MSG_VISA_INTER_LOG +"发送0810应答报文到Q7");
            	by = iso8583Encoder.encode(isoMessage);
            	
            	byte[] sendBy = new byte[bNetworkMatch.length + by.length];
            	System.arraycopy(bNetworkMatch, 0, sendBy, 0, bNetworkMatch.length);
            	System.arraycopy(by, 0,sendBy, bNetworkMatch.length, by.length);
            	
                amqpTemplateVisa.convertAndSend("VISA_Response", sendBy);
                logger.info(MessageTemplate.MSG_VISA_INTER_LOG +"Q1发送消息至Q7："+HexUtil.toHexString(by));
			} else if(isoMessage.getType() == 0x810){
				if (messageHashMap.getIsoMessages().get(isoMessage.getAt(7).toString() + isoMessage.getAt(11).toString()) != null) {
					if (isoMessage.hasEveryField(39,70)) {
						if (isoMessage.getAt(39).toString().equals("00")) {
							if (isoMessage.getAt(70).toString().equals("071")) {
			            		logger.info(MessageTemplate.MSG_VISA_INTER_LOG +"收到签到应答报文");
			                	ProcessStatus.boolProcessStatus = true;
							} else if (isoMessage.getAt(70).toString().equals("072")) {
								logger.info(MessageTemplate.MSG_VISA_INTER_LOG +"收到签退应答报文");
								ProcessStatus.boolProcessStatus = false;
							}else if (isoMessage.getAt(70).toString().equals("078")) {
								logger.info(MessageTemplate.MSG_VISA_INTER_LOG +"收到AdviceSignOn签到应答报文");
								ProcessStatus.boolAdviceSignStatus = true;
							}else if (isoMessage.getAt(70).toString().equals("079")) {
								logger.info(MessageTemplate.MSG_VISA_INTER_LOG +"收到AdviceSignOff签退应答报文");
								ProcessStatus.boolAdviceSignStatus = false;
							}
						}
					} else {
						logger.error(MessageTemplate.MSG_VISA_INTER_LOG +"收到 签到/签退 应答报文出错");
					}
				} else {
					logger.error(MessageTemplate.MSG_VISA_INTER_LOG +"收到0810报文，但Hashmap中不存在对应的KEY{}",isoMessage.getAt(7).toString() + isoMessage.getAt(11).toString());
				}

			}else if(isoMessage.getType() == 0x312){
				logger.info("收到0312 FileMaint respone message");
				FileMaintExample example = new FileMaintExample();
				example.createCriteria().andAccountnumberEqualTo(isoMessage.getField(2).toString())
					.andDateEqualTo(isoMessage.getObjectValue(7))
					.andTimeEqualTo(isoMessage.getObjectValue(7));
				
				FileMaint record= new FileMaint();
				record.setRespcode(isoMessage.getField(39).toString());
				
				fileMaintServiceImpl.updateByExampleSelective(record, example);
			}else {
	            isoMessage.setBeginESBTime(new Date().getTime());
		          by = Serializer.serialize(isoMessage);
		           /* byte[] by = message.getBody();*/
		          amqpTemplateVisaToESB.convertAndSend("VISAToESB", by);
		            tps.tick();
		            logger.info(MessageTemplate.MSG_VISA_INTER_LOG +"Q1发送消息序列化消息对象至Q2："/*+HexUtil.toHexString(by)*/);
			}
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        } catch (Exception e) {
            logger.error(MessageTemplate.MSG_VISA_INTER_LOG,e);
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
	}
}
