/*
 * The MIT License
 *
 * Copyright 2015 Vanio Informatika Kft..
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package cn.com.syscom.ibmmq;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;
import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;

import cn.com.syscom.inter.esbinterface.EsbConsumerQSecond;
import cn.com.syscom.iso8583.util.HexUtil;

/**
 * Reading queue.
 *
 * @author Pato Istvan <istvan.pato@vanio.hu>
 */
public class JmsQueueListener implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(JmsQueueListener.class);
    
    @Resource
    private AmqpTemplate amqpTemplateEsb;
    
    AtomicInteger a = new AtomicInteger(0);

    public void onMessage(Message message) {
        a.addAndGet(1);
        logger.info("\nIncoming message! (" + a + ")");
        if (message instanceof TextMessage) {
            try {
            	logger.info(((TextMessage) message).getText());
            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        }else if (message instanceof BytesMessage) {
            try {
            	byte[] bytesValue = new byte[(int) ((BytesMessage) message).getBodyLength()];
            	((BytesMessage) message).readBytes(bytesValue);
            	   amqpTemplateEsb.convertAndSend("ESB_Response", bytesValue);
                   logger.info("Q3发送消息至Q4：" + HexUtil.toHexString(bytesValue));
            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        }else{
            throw new IllegalArgumentException("Message must be of type TextMessage or BytesMessage");
        }
    }

}
