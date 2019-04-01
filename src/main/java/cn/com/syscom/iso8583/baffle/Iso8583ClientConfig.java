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
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.impl.SimpleTraceGenerator;
import cn.com.syscom.iso8583.parse.ConfigParser;

/*@Configuration
@PropertySource("application-test.properties")*/
@Service
public class Iso8583ClientConfig {

/*    @Value("${iso8583.connection.host}")
    private String host;

    @Value("${iso8583.connection.port}")
    private int port;

    @Value("${iso8583.connection.idleTimeout}")
    private int idleTimeout;*/

    @Bean
    public Iso8583Client<IsoMessage> iso8583Client() throws IOException {
        SocketAddress socketAddress = new InetSocketAddress("192.168.10.110", 9999);

        return new Iso8583Client<>(socketAddress, clientMessageFactory());
    }

    private static MessageFactory<IsoMessage> clientMessageFactory() throws IOException {
        final MessageFactory<IsoMessage> messageFactory = ConfigParser.createFromClasspathConfig("j8583_config.xml");
        
        messageFactory.setUseBinaryMessages(true);
        messageFactory.setUseBinaryBitmap(true);
        messageFactory.setCharacterEncoding("Cp1047");
        messageFactory.setAssignDate(true);
        messageFactory.setTraceNumberGenerator(new SimpleTraceGenerator((int) (System
                .currentTimeMillis() % 1000000)));
        return messageFactory;
    }
}
