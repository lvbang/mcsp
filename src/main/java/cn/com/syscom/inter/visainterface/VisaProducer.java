package cn.com.syscom.inter.visainterface;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class VisaProducer {

    @Autowired
    private AmqpTemplate amqpTemplateVisa;

    private final static Logger logger = LoggerFactory.getLogger(VisaProducer.class);

    public void sendDataToQueue(String queueKey, Object object) {
        try {
        	amqpTemplateVisa.convertAndSend(queueKey, object);
           // amqpTemplate.
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("exeception={}",e);
        }

    }
}
