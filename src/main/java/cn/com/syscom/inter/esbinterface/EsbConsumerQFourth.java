package cn.com.syscom.inter.esbinterface;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

import cn.com.syscom.inter.visainterface.MessageHashMap;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.baffle.Iso8583Decoder;
import cn.com.syscom.iso8583.util.HexUtil;
import cn.com.syscom.iso8583.util.MessageTemplate;
import cn.com.syscom.iso8583.util.Serializer;


/*@Service
public class Consumer {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("reveice msg=" + message.toString());
       
        latch.countDown();
    }
}*/

public class EsbConsumerQFourth implements ChannelAwareMessageListener {
    private Logger logger = LoggerFactory.getLogger(EsbConsumerQFourth.class);
    @Resource
    private AmqpTemplate amqpTemplateEsb;
    
    @Resource
    private Iso8583Decoder iso8583Decoder;
    //private IsoMessage isoMessageCup;
    @Resource
    private MessageHashMap messageHashMap;   

//    private StringBuilder mapKey = new StringBuilder();
    
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		// TODO Auto-generated method stub
        //logger.info("receive message:{}",message);
        try {
            //将字节流对象转换成Java对象
            logger.info(MessageTemplate.MSG_ESB_INTER_LOG+"Q4接收到消息" + HexUtil.toHexString(message.getBody()));
            IsoMessage isoMessageCup = iso8583Decoder.decode(message.getBody(),2);
            isoMessageCup.setEndEsbTime(new Date().getTime());
            byte[] by = Serializer.serialize(isoMessageCup);
            amqpTemplateEsb.convertAndSend("ESBToVISA", by);
            logger.info(MessageTemplate.MSG_ESB_INTER_LOG+"Q4发送序列化消息至Q5"/* + HexUtil.toHexString(message.getBody())*/);
            
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        } catch (Exception e) {
            logger.error(MessageTemplate.MSG_ESB_INTER_LOG+"{}",e);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
	}
}
