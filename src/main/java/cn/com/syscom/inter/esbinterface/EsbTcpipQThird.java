package cn.com.syscom.inter.esbinterface;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.MessageConverter;

import com.rabbitmq.client.Channel;

import cn.com.syscom.ibmmq.JmsQueueSender;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.baffle.Iso8583Decoder;
import cn.com.syscom.iso8583.baffle.Iso8583Encoder;
import cn.com.syscom.iso8583.util.HexUtil;
import oracle.net.aso.s;

public class EsbTcpipQThird implements ChannelAwareMessageListener {
    private Logger logger = LoggerFactory.getLogger(EsbConsumerQSecond.class);
   
    @Resource
    private AmqpTemplate amqpTemplateEsb;
    
    @Resource
    private Iso8583Decoder iso8583Decoder;
    
    @Resource
    private JmsQueueSender jmsQueueSender;
    
    @Resource
    private MessageFactory<IsoMessage> isoMessageFactoryCup;
   // private IsoMessage isoMessageCup;
    

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		// TODO Auto-generated method stub
        //logger.info("receive message:{}",message);

        try {
            //���ֽ�������ת����Java����
           // Person person=(Person) new ObjectInputStream(new ByteArrayInputStream(message.getBody())).readObject();
        	logger.info("Q3���յ���Ϣ��" + HexUtil.toHexString(message.getBody()));
        	IsoMessage isoMessageCup = iso8583Decoder.decode(message.getBody(),2);
            Iso8583Encoder<?> iso8583Encoder = new Iso8583Encoder<Object>((MessageFactory<IsoMessage>) isoMessageFactoryCup,0);
            byte[] b=iso8583Encoder.encode(isoMessageCup,2);
            
            amqpTemplateEsb.convertAndSend("ESB_Response", b);
            logger.info("Q3������Ϣ��Q4��" + HexUtil.toHexString(b));
            
/*            jmsQueueSender.simpleBytesSend(b);
            logger.info("Q3������IbmMq��" + HexUtil.toHexString(b));*/
            
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        } catch (Exception e) {
        	channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            logger.error("{}",e);
        }
	}
}
