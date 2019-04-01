package cn.com.syscom.inter.esbinterface;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import com.rabbitmq.client.Channel;

import cn.com.syscom.inter.visainterface.MessageHashMap;
import cn.com.syscom.inter.visainterface.TimerTaskImpl;
import cn.com.syscom.iso8583.CustomField63;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.baffle.Iso8583Decoder;
import cn.com.syscom.iso8583.baffle.Iso8583Encoder;
import cn.com.syscom.iso8583.util.HexUtil;
import cn.com.syscom.iso8583.util.MessageTemplate;
import cn.com.syscom.iso8583.util.Serializer;
import cn.com.syscom.iso8583.util.TPS;
import cn.com.syscom.iso8583.util.TransactionTimer;
import cn.com.syscom.mcsp.service.impl.PtlfIncreServiceImpl;
import cn.com.syscom.mcsp.service.impl.PtlfServiceImpl;


public class EsbConsumerQSecond implements ChannelAwareMessageListener {
    private Logger logger = LoggerFactory.getLogger(EsbConsumerQSecond.class);
    @Resource
    private AmqpTemplate amqpTemplateEsb;
    
    @Resource
    private AmqpTemplate amqpTemplateVisa;
    
    @Resource
    private MessageHashMap messageHashMap;
    
    @Resource
    private Iso8583Encoder<?> iso8583Encoder;
    
    @Resource
    private Iso8583Decoder iso8583Decoder;
    
    @Resource
    private MessageFactory<IsoMessage> isoMessageFactory;
    
    @Resource 
    private CustomField63 customField63;
    
    @Resource
    private MessageFactory<IsoMessage> isoMessageFactoryCup;
    
    @Resource 
    private CustomField63 customField63Cup;
    
    @Resource
    private PtlfServiceImpl ptlfServiceImpl;

    @Resource
    private PtlfIncreServiceImpl ptlfIncreServiceImpl;
    
    @Resource
    private TPS tps;
    
/*    private IsoMessage isoMessage;

    private StringBuilder mapKey = new StringBuilder();*/
    //private TimerTask timerTask = null;
    
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		// TODO Auto-generated method stub
        //logger.info("receive message:{}",message);
        try {  
            //将字节流对象转换成Java对象
        	logger.info(MessageTemplate.MSG_ESB_INTER_LOG + "Q2接收到序列化消息，反序列化消息对象" /*+ HexUtil.toHexString(message.getBody())*/);
        	IsoMessage isoMessage = (IsoMessage) Serializer.deserialize(message.getBody());
  
			IsoMessage isoMessageCup=isoMessageFactoryCup.newMessage(isoMessage.getType());
			
			for (int i = 2; i < 128; i++) {
				if (isoMessage.hasField(i)) {
					isoMessageCup.setField(i, isoMessage.getField(i).clone());
				}
			}

    		byte[] bycup = isoMessageCup.writeToBuffer(0).array();	         
            
    		StringBuilder mapKey = new StringBuilder();
            mapKey.setLength(0);//清空StringBuilder
            
            //以visa对象2域、11域、37域为key，存入hashmap中
            mapKey.append(isoMessage.getField(2)).append(isoMessage.getField(11)).append(isoMessage.getField(37));
            
            if (messageHashMap.getIsoMessages().containsKey(mapKey.toString())) {
				logger.error("已经存在KEY：{}",mapKey.toString());
				channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
				return;
			}
            messageHashMap.getIsoMessages().put(mapKey.toString(), isoMessage);
            TimerTaskImpl timerTask = new TimerTaskImpl(mapKey.toString(),messageHashMap,amqpTemplateVisa,ptlfIncreServiceImpl,tps);
            messageHashMap.getMessageTimer().put(mapKey.toString(), timerTask);
            //消息定时器，当消息存入hashmap中时间超过timeout时，发送超时报文，并删除map中的该消息
            //new TransactionTimer(mapKey.toString(), 10, TimeUnit.SECONDS, messageHashMap);
            new TransactionTimer(timerTask,mapKey.toString(), 30000, TimeUnit.MILLISECONDS, messageHashMap);
         
            amqpTemplateEsb.convertAndSend("ESB_Request", bycup);
            logger.info(MessageTemplate.MSG_ESB_INTER_LOG+"Q2发送消息至Q3" + HexUtil.toHexString(bycup)); 
            
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            logger.error(MessageTemplate.MSG_ESB_INTER_LOG+"{}",e);
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
	}
}
