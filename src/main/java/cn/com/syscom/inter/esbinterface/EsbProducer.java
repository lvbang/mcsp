package cn.com.syscom.inter.esbinterface;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EsbProducer {

    @Autowired
    private RabbitTemplate amqpTemplateEsb;

    private final static Logger logger = LoggerFactory.getLogger(EsbProducer.class);

    public void sendDataToQueue(String queueKey, Object object) {
        try {
        	amqpTemplateEsb.convertAndSend(queueKey, object);
        } catch (Exception e) {
          //  e.printStackTrace();
            logger.error("exeception={}",e);
        }

    }
}
