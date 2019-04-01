package cn.com.syscom.inter.visainterface;

import java.util.Date;
import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import com.rabbitmq.client.Channel;

import cn.com.syscom.iso8583.CustomField63;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.baffle.Iso8583Decoder;
import cn.com.syscom.iso8583.baffle.Iso8583Encoder;
import cn.com.syscom.iso8583.baffle.IsoMessageLoggingHandler;
import cn.com.syscom.iso8583.util.HexUtil;
import cn.com.syscom.iso8583.util.MessageTemplate;
import cn.com.syscom.iso8583.util.Serializer;
import cn.com.syscom.mcsp.service.impl.PtlfIncreServiceImpl;
import cn.com.syscom.mcsp.service.impl.PtlfServiceImpl;
import cn.com.syscom.mysql.model.PTLFIncre;
import cn.com.syscom.mysql.model.PTLFIncreExample;
import cn.com.syscom.mysql.model.PTLFIncreExample.Criteria;
import cn.com.syscom.mysql.model.Vtlf;


/*@Service
public class Consumer {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("reveice msg=" + message.toString());
       
        latch.countDown();
    }
}*/


public class VisaConsumerQFifth implements ChannelAwareMessageListener {
    private Logger logger = LoggerFactory.getLogger(VisaConsumerQFifth.class);
    private static org.apache.logging.log4j.Logger transMonLogger = LogManager.getLogger("mylog");
    
    @Resource
    private AmqpTemplate amqpTemplateVisa;
    
    @Resource
    private AmqpTemplate amqpTemplateEsb;
    
    @Resource
    private AmqpTemplate amqpTemplateMonit;
 
    @Resource
    private MessageHashMap messageHashMap;
    
    @Resource
    private Iso8583Encoder<?> iso8583Encoder;
    
    @Resource 
    private CustomField63 customField63;
    
    @Resource
    private Iso8583Decoder iso8583Decoder;

    @Resource
    private Vtlf vtlf;
    
    @Resource
    private PtlfServiceImpl ptlfServiceImpl;
    
    @Resource
    private PtlfIncreServiceImpl ptlfIncreServiceImpl;
   
    
    @Override
	public void onMessage(Message message, Channel channel) throws Exception {
        try {
        	logger.info(MessageTemplate.MSG_VISA_INTER_LOG + "Q5接收到序列号消息对象" /*+ HexUtil.toHexString(message.getBody())*/);
        	IsoMessage isoMessageCup = (IsoMessage) Serializer.deserialize(message.getBody());
            
            StringBuilder mapKey = new StringBuilder();
            mapKey.setLength(0);
            
            mapKey.append(isoMessageCup.getField(2)).append(isoMessageCup.getField(11)).append(isoMessageCup.getField(37));
     
            IsoMessage isoMessageVisa = messageHashMap.getIsoMessages().get(mapKey.toString()); 
            
            if ((isoMessageVisa == null) && isoMessageCup.getType() == 0x430) {
				logger.info(MessageTemplate.MSG_VISA_INTER_LOG +"收到冲正应答报文");
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
				return;
			}
            
            if (isoMessageVisa != null) {
            	
            	messageHashMap.getMessageTimer().get(mapKey.toString()).cancel();
            	messageHashMap.getMessageTimer().remove(mapKey.toString());
            	messageHashMap.getIsoMessages().remove(mapKey.toString());
            	isoMessageVisa.setEndEsbTime(isoMessageCup.getEndEsbTime());
                isoMessageVisa.setEndVisaTime(new Date().getTime());
                
                isoMessageVisa.setValue(39, isoMessageCup.getField(39).toString(), IsoType.ALPHA, 2);
                if (isoMessageVisa.getType() == 0x0100) {
					isoMessageVisa.removeFields(14,18,22,28,35,43,52,53,60);
				}
                
                byte[] by=iso8583Encoder.encode(isoMessageVisa);

                byte[] sendMessage = new byte[by.length + isoMessageVisa.getNetworkMatch().length];
                System.arraycopy(isoMessageVisa.getNetworkMatch(), 0, sendMessage, 0, Constants.RQST_MESSAGE_HEADER_LENGTH);
                System.arraycopy(by, 0, sendMessage, Constants.RQST_MESSAGE_HEADER_LENGTH, by.length);
                
                //amqpTemplateVisa.convertAndSend("VISA_Response", by);

                logger.info(MessageTemplate.MSG_VISA_INTER_LOG +"Q5发送消息至Q7：" + HexUtil.toHexString(by));

                if (isoMessageVisa.getEndVisaTime() != 0 && isoMessageVisa.getBeginEsbTime() != 0 && isoMessageVisa.getEndEsbTime() != 0) {
                    vtlf.setResptime(vtlf.getResptime() + (float) (isoMessageVisa.getEndVisaTime() - isoMessageVisa.getBeginVisaTime())/1000);
                    vtlf.setIchgtime(vtlf.getIchgtime() + (float) (isoMessageVisa.getEndEsbTime() - isoMessageVisa.getBeginEsbTime())/1000);
				}
               
                //ptlfServiceImpl.insert(isoMessageVisa, isoMessageCup);
                ptlfIncreServiceImpl.insert(isoMessageVisa, isoMessageCup);
                amqpTemplateVisa.convertAndSend("VISA_Response", sendMessage);
                
                IsoMessageLoggingHandler isoMessageLoggingHandler = new IsoMessageLoggingHandler();
                transMonLogger.info(isoMessageLoggingHandler.formatMonitorMessage(isoMessageVisa));
			}else {
				logger.error(MessageTemplate.MSG_VISA_INTER_LOG +"HashMap中不存在该Key：{}",mapKey.toString());
				logger.error(MessageTemplate.MSG_VISA_INTER_LOG +"发送冲正报文");
				isoMessageCup.setType(4*16*16 + 2*16 + 0*16);
				isoMessageCup.removeFields(39);
	    		//byte[] bycup = isoMessageCup.writeToBuffer(0).array();
				
	    		//发送冲正报文至esb
	            //amqpTemplateEsb.convertAndSend("ESB_Request", bycup);
	            
/*	            PTLF ptlf = new PTLF();
	            ptlf.setCardNum(isoMessageCup.getField(2).toString());
	            ptlf.setDatDat(isoMessageCup.getObjectValue(7));
	            ptlf.setDatTim(isoMessageCup.getObjectValue(7));
	            ptlf.setTraceNumber(isoMessageCup.getField(11).toString());
	            ptlf.setRvrlCde("R");
	            
	            ptlfServiceImpl.updateByPrimaryKeySelective(ptlf);*/
	    		
	    		PTLFIncre ptlfIncre = new PTLFIncre();
	    		ptlfIncre.setRvrlCde("R");
	    		PTLFIncreExample ptlfIncreExample= new PTLFIncreExample();
	    		Criteria criteria = ptlfIncreExample.createCriteria();
	    		criteria.andCardNumEqualTo(isoMessageCup.getField(2).toString());
	    		criteria.andDatDatEqualTo(isoMessageCup.getObjectValue(7));
	    		criteria.andDatTimEqualTo(isoMessageCup.getObjectValue(7));
	    		criteria.andTraceNumberEqualTo(isoMessageCup.getField(11).toString());
	    		
	            ptlfIncreServiceImpl.updateByExampleSelective(ptlfIncre, ptlfIncreExample);
			}
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        } catch (Exception e) {
        	channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            logger.error(MessageTemplate.MSG_VISA_INTER_LOG +"{}",e);
        }
	}
	
}