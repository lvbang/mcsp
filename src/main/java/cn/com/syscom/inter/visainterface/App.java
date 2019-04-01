package cn.com.syscom.inter.visainterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.com.syscom.iso8583.CustomField63;
import cn.com.syscom.iso8583.HeaderField;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.IsoValue;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.impl.SimpleTraceGenerator;
import cn.com.syscom.iso8583.util.MessageTemplate;
import cn.com.syscom.iso8583.util.TransactionTimer;
import cn.com.syscom.mysql.mapper.ProcessParamMapper;
import cn.com.syscom.mysql.model.ProcessParam;

public class App 
{
	private static Logger logger = LoggerFactory.getLogger(VisaConsumerQFifth.class);
	//private static org.apache.logging.log4j.Logger logger = LogManager.getLogger("mylog");;

//从自定义路径加载log4j2.xml文件，自定义logger	
/*	public static void loadLog4j2() throws IOException{
		ConfigurationSource source;
		try {
			String config=System.getProperty("user.dir");
			source = new ConfigurationSource(new FileInputStream(config+"\\config\\log4j2.xml"));
			Configurator.initialize(null, source);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ConfigurationSource source;
        try {  
        	String config=System.getProperty("user.dir");
			source = new ConfigurationSource(new FileInputStream(config+"\\config\\log4j2.xml"));
            Configurator.initialize(null, source);
            logger = LogManager.getLogger("mylog");
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        }

	}*/
	
    public static void main( String[] args ) throws Exception
    {

/*    	//loadLog4j2();
    	*//**从数据库中读取程序启动参数：AutoSignOn，如果为Y，发送签到报文至Visa**/
    	@SuppressWarnings("resource")
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"Mybatis/applicationContext.xml",
    													"applicationContext.xml","application_ibmmq.xml"});
    	ProcessParamMapper processParamMapper =(ProcessParamMapper) context.getBean("processParamMapper");
    	ProcessParam processParam = processParamMapper.selectByByInterfaceId(1);
    	
    	if (processParam.getAutoSignon().equals("Y")) {
    	    MessageFactory<?> isoMessageFactory = new MessageFactory<>();
    		isoMessageFactory.setCharacterEncoding("Cp1047");
    		isoMessageFactory.setUseBinaryBitmap(true);
    		isoMessageFactory.setUseBinaryMessages(true);
    		isoMessageFactory.setAssignDate(true);
    		isoMessageFactory.setTraceNumberGenerator(new SimpleTraceGenerator((int)(System.currentTimeMillis() % 100000)));
    		try {
    			isoMessageFactory.setConfigPath("j8583_config.xml");
    		} catch (IOException e) {
    			logger.error("{}",e);
    			return;
    		}
    		
    		MessageHashMap messageHashMap = (MessageHashMap) context.getBean("messageHashMap");

    		CustomField63 customField63 =(CustomField63) context.getBean("customField63");
			isoMessageFactory.setSetRetrievalReferenceNumber(true);
    		isoMessageFactory.setCustomField(63, customField63);
			customField63.getIsoMessage().setField(1, new IsoValue<>(IsoType.NUMERIC, 2, 4));
			isoMessageFactory.setCustomField(63, customField63);
			IsoMessage isoMessage = isoMessageFactory.newMessage(0x800);
			 
			isoMessage.setValue(70, 71, IsoType.NUMERIC, 3);
			isoMessage.setValue(63, customField63, isoMessageFactory.getCustomField(63), IsoType.LLLVAR, 0);

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
			
			RabbitTemplate amqpTemplateVisa =  (RabbitTemplate) context.getBean("amqpTemplateVisa");
    		byte[] byMessage = isoMessage.writeData();
    		
    		byte[] by = new byte[50];
    		byte[] sendBy = new byte[50 + byMessage.length];
    		
    		System.arraycopy(Constants.RQST_MESSAGE_HEADER.getBytes(), 0, by, 0, Constants.RQST_MESSAGE_HEADER.length());
    		System.arraycopy(by, 0, sendBy, 0, Constants.RQST_MESSAGE_HEADER_LENGTH);
    		System.arraycopy(byMessage, 0, sendBy, Constants.RQST_MESSAGE_HEADER_LENGTH, byMessage.length);
    		
			amqpTemplateVisa.convertAndSend("VISA_Response", sendBy);
			logger.info(MessageTemplate.MSG_VISA_INTER_LOG + "程序启动，发送签到报文");
			
			String mapKey= isoMessage.getAt(7).toString() + isoMessage.getAt(11).toString();
            messageHashMap.getIsoMessages().put(mapKey, isoMessage);
            TimerTaskImpl timerTask = new TimerTaskImpl(mapKey,messageHashMap,amqpTemplateVisa,null,null);
            messageHashMap.getMessageTimer().put(mapKey.toString(), timerTask);
            //消息定时器，当消息存入hashmap中时间超过timeout时，并删除map中的该消息
            new TransactionTimer(timerTask,mapKey, 3000, TimeUnit.MILLISECONDS, messageHashMap);
		}else {
			logger.info("自动签到标志为'N',当前签到状态为:"+ new String(ProcessStatus.boolProcessStatus ? "LOGON" :"LOGOFF"));
		}
    	
/*        SendMonitMessageToMQ sendMonitMessageToMQ = (SendMonitMessageToMQ) context.getBean("sendMonitMessageToMQ");
        new Thread(sendMonitMessageToMQ).start();*/		
    }
}
