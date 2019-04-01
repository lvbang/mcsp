package cn.com.syscom.iso8583.baffle;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.impl.SimpleTraceGenerator;
import cn.com.syscom.iso8583.parse.ConfigParser;

/*@Configuration*/
@PropertySource("application-test.properties")
public class Iso8583ServerConfig {


    @Value("${iso8583.connection.port}")
    private int port;


    @Bean
    public Iso8583Server<IsoMessage> iso8583Client() throws IOException {
        return new Iso8583Server<>(port, serverMessageFactory(),serverMessageFactoryCup());
    }

    private MessageFactory<IsoMessage> serverMessageFactory() throws IOException {
        final MessageFactory<IsoMessage> messageFactory = ConfigParser.createFromClasspathConfig("j8583_config.xml");
        
        messageFactory.setUseBinaryMessages(true);
        messageFactory.setUseBinaryBitmap(true);
        messageFactory.setCharacterEncoding("Cp1047");
        messageFactory.setAssignDate(true);
        messageFactory.setTraceNumberGenerator(new SimpleTraceGenerator((int) (System
                .currentTimeMillis() % 1000000)));
        return messageFactory;
    }
    
    private MessageFactory<IsoMessage> serverMessageFactoryCup() throws IOException {
        final MessageFactory<IsoMessage> messageFactory = ConfigParser.createFromClasspathConfig("cup8583_config.xml");
        
        messageFactory.setUseBinaryMessages(false);
        messageFactory.setUseBinaryBitmap(true);
        messageFactory.setCharacterEncoding("GBK");
        messageFactory.setAssignDate(true);
        messageFactory.setTraceNumberGenerator(new SimpleTraceGenerator((int) (System
                .currentTimeMillis() % 1000000)));
        return messageFactory;
    }
}
