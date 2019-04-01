package cn.com.syscom.inter.visainterface;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import com.rabbitmq.client.Channel;

import cn.com.syscom.iso8583.baffle.Iso8583Client;
import cn.com.syscom.iso8583.util.HexUtil;


/*@Service
public class Consumer {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("reveice msg=" + message.toString());
       
        latch.countDown();
    }
}*/

public class VisaConsumerQSeventh implements ChannelAwareMessageListener {
    private Logger logger = LoggerFactory.getLogger(VisaConsumerQSeventh.class);
    @Resource
    private AmqpTemplate amqpTemplateVisa;
    @SuppressWarnings("rawtypes")
	@Resource
    private Iso8583Client iso8583Client;
    private CountDownLatch latch = new CountDownLatch(1);


	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		// TODO Auto-generated method stub
        //logger.info("receive message:{}",message);
        try {
            //将字节流对象转换成Java对象
           // Person person=(Person) new ObjectInputStream(new ByteArrayInputStream(message.getBody())).readObject();
        	logger.info("Q7接收到消息：{}" + HexUtil.toHexString(message.getBody()));
            //channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            //System.out.println(HexUtil.toHexString(message.getBody()));
            iso8583Client.response(message.getBody());
            latch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("{}",e);
        }
	}
	
	
}
