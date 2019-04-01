package cn.com.syscom.inter.visainterface;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.syscom.iso8583.util.MessageTemplate;
import cn.com.syscom.iso8583.util.Serializer;
import cn.com.syscom.iso8583.util.TPS;
import cn.com.syscom.mysql.model.Vtlf;

@Service
public class SendMonitMessageToMQ implements Runnable {

	private Logger logger = LoggerFactory.getLogger(VisaConsumerQFifth.class);
	//private static org.apache.logging.log4j.Logger logger = LogManager.getLogger("mylog");;
	public SendMonitMessageToMQ() {
		// TODO Auto-generated constructor stub
	}
	
    @Autowired
    private AmqpTemplate amqpTemplateMonit;
    
    @Autowired
    private Vtlf vtlf;
    
    @Autowired
    private TPS tps;
    
    private MessageProperties messageProperties = new MessageProperties();
    
	@Override
	public void run() {
		while (true){
			// TODO Auto-generated method stub
				messageProperties.setExpiration("60000");
				try {
					Thread.sleep(9955L);
					vtlf.setTrancnt((int) tps.getCount());
					vtlf.setDenycnt((int) tps.getDenyCount());
					tps.reset();
					vtlf.setAprvcnt(vtlf.getTrancnt() - vtlf.getDenycnt());
					if (vtlf.getTrancnt() > 0) {
						vtlf.setAprvperc((float) ((float)vtlf.getAprvcnt() / (float)vtlf.getTrancnt()) * 100);
						vtlf.setResptime((float)vtlf.getResptime()/vtlf.getTrancnt());
						vtlf.setIchgtime((float)vtlf.getIchgtime()/vtlf.getTrancnt());
					}else {
						vtlf.setAprvperc((float)0);
						vtlf.setResptime((float)0);
						vtlf.setIchgtime((float)0);
					}
					
					vtlf.setTrantime(new Date());
					logger.info(MessageTemplate.MSG_VISA_INTER_LOG + "发送交易统计数据至MQ" +vtlf.toString());
					Message message = new Message(Serializer.serialize(vtlf), messageProperties);
					vtlf.setResptime((float) 0);
					vtlf.setIchgtime((float) 0);
					amqpTemplateMonit.send("key", message);
					
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					logger.error("{}",e1);
				}
		}
	}
	

}
