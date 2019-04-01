package cn.com.syscom.inter.esbinterface;

import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.syscom.iso8583.CustomField63;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.IsoValue;
import cn.com.syscom.iso8583.parse.LlllvarParseInfo;
import cn.com.syscom.iso8583.parse.LlvarParseInfo;
import oracle.net.aso.s;


public class App 
{
	// @SuppressWarnings("rawtypes")
	// @Autowired 
	// public RedisTemplate redisTemplate;
	 
    @SuppressWarnings({ "resource", "unchecked", "deprecation" })
	public static void main( String[] args ) throws IOException, ClassNotFoundException
    {
    	
    	InetAddress ia = InetAddress.getLocalHost();
    	System.out.println(ia.getHostName());
		 Calendar c=new GregorianCalendar();
    	System.out.println(String.format("%03d", c.get(Calendar.DAY_OF_YEAR)));
    	
    	
    	LlvarParseInfo llvarParseInfo = new LlvarParseInfo();
    	try {
			IsoValue<?> isoValue = llvarParseInfo.parse(0, "03awwa".getBytes(), 0, null);
			System.out.println(isoValue.getValue().toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	System.setProperty("123", "abc");
    	System.out.println(System.getProperty("123"));

    	
    	new IsoValue(IsoType.LLVAR, "12345", new CustomField63());
/*        final String queueName = "Q1";
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Producer producer=(Producer) context.getBean("producer") ; 
		proceducer.sendDataToQueue(queueName, "aasdfagas");
		final String q1_route_Key = "*.visa";
		 MessageProperties messageProperties = new MessageProperties();
		Message message = new Message("fdasf".getBytes(), messageProperties);
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        RabbitTemplate amqpTemplate = (RabbitTemplate) context.getBean("amqpTemplateLog");
     
      //  amqpTemplate.setReplyAddress("VisaLogInfoReplyQueue");
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(amqpTemplate.getConnectionFactory());
		container.setQueueNames("VisaLogInfoQueue");
		//container.setMessageListener(amqpTemplate);
		container.start();

		MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(new Object() {

			@SuppressWarnings("unused")
			public void handleMessage(byte[] message) {
				System.out.println(new String(message));
			}
		});
		
		container.setMessageListener(messageListenerAdapter);
		amqpTemplate.setQueue("VisaLogInfoQueue");*/


		//System.out.println(amqpTemplate.receive());
/*		amqpTemplate.receiveAndReply((ReceiveAndReplyCallback<Message, Message>) payload -> {
			//receiveCount.incrementAndGet();
			payload.getMessageProperties().setCorrelationIdString("123456");
			payload.getMessageProperties().setHeader("aaa", "bbb");
			System.out.println(payload);
			return payload;
		});*/
       // System.out.println(new String(amqpTemplate.receive("LogInfoQueue").getBody()));
/*        amqpTemplate.receiveAndReply("LogInfoQueue",new ReceiveAndReplyCallback<Message, Message>() {

			@Override
			public Message handle(Message payload) {
				// TODO Auto-generated method stub
				System.out.println(payload + "======");
				return message;
			}
		});*/
/*		new Thread(new Runnable() {
			
			@Override
			public void run() {
				RedisInitSubscrib redisInitSubscrib= (RedisInitSubscrib) context.getBean("redisInitSubscrib");
				try {
					redisInitSubscrib.begin();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();*/
/*	    EsbProducer producer=(EsbProducer) context.getBean("producer");
	    producer.sendDataToQueue(q1_route_Key, message);*/
//	    System.out.println("发送消息至Q1：" + message);
/*		@SuppressWarnings("rawtypes")
		RedisTemplate redisTemplate =(RedisTemplate) context.getBean("redisTemplate");
		redisTemplate.opsForValue().set("1", "abc");
		System.out.println(redisTemplate.opsForValue().get("1"));
		redisTemplate.expire("1", 5, TimeUnit.SECONDS);*/
	
    }
}
