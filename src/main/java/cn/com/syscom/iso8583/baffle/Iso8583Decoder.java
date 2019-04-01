package cn.com.syscom.iso8583.baffle;


import java.io.FileInputStream;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.com.syscom.iso8583.CustomField63;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.impl.SimpleTraceGenerator;
import cn.com.syscom.iso8583.util.HexUtil;
import cn.com.syscom.iso8583.util.MessageTemplate;

public class Iso8583Decoder {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Resource
    private CustomField63 customField63;
    private final MessageFactory<IsoMessage> messageFactory;
    private final MessageFactory<IsoMessage> messageFactoryCup;
    public Iso8583Decoder(MessageFactory<IsoMessage> messageFactory,MessageFactory<IsoMessage> messageFactoryCup) {
        this.messageFactory = messageFactory;
        this.messageFactory.setTraceNumberGenerator(new SimpleTraceGenerator((int) (System
                .currentTimeMillis() % 1000000)));
        this.messageFactoryCup = messageFactoryCup;
        this.messageFactoryCup.setTraceNumberGenerator(new SimpleTraceGenerator((int) (System
                .currentTimeMillis() % 1000000)));
    }
	
	
    public MessageFactory<IsoMessage> getMessageFactory() {
		return messageFactory;
	}



    
    /**
     * @implNote Message body starts immediately, no length header,
     * see <code>"lengthFieldFameDecoder"</code> in
     * {@link com.github.kpavlov.jreactive8583.netty.pipeline.Iso8583ChannelInitializer#initChannel}
     */
    @SuppressWarnings("unused")
	public IsoMessage decode(byte[] byteBuf,int decodeType) throws Exception {
        if (byteBuf.length < 2) {
            return null;
        }

/*        int len = ((byteBuf[0] & 0xff) << 8) | (byteBuf[1] & 0xff);
		byte[] buf = new byte[len];
		
		System.arraycopy(byteBuf, 2, buf, 0, len);
		
		int headerLen = buf[0] & 0xff;*/
		IsoMessage isoMessage = new IsoMessage();
		IsoMessage isoMessageCup = new IsoMessage();
		if (decodeType == 1) {
			logger.debug(MessageTemplate.MSG_ISO8583_DECODER_LOG +"-------------VISA报文解包-------------");
	        int headerLen = byteBuf[0] & 0xff;
			byte[] head = new byte[headerLen];
			System.arraycopy(byteBuf, 0, head, 0, headerLen);
			isoMessage = messageFactory.parseMessage(byteBuf, headerLen,true);
		} else if (decodeType == 2){
			logger.debug(MessageTemplate.MSG_ISO8583_DECODER_LOG +"-------------CUP银联报文解包------------- "+ HexUtil.toHexString(byteBuf));
			isoMessage = messageFactoryCup.parseMessage(byteBuf, 0);
		} else {
            throw new Exception(MessageTemplate.MSG_ISO8583_DECODER_LOG +"decodeType error：" + HexUtil.toHexString(byteBuf) );
        }
		
        if (isoMessage != null) {
        	IsoMessageLoggingHandler isoMessageLoggingHandler = new IsoMessageLoggingHandler(false,true);
        	logger.info(MessageTemplate.MSG_ISO8583_DECODER_LOG + isoMessageLoggingHandler.formatIsoMessage(isoMessage));
            return isoMessage;
        } else {
            throw new ParseException(MessageTemplate.MSG_ISO8583_DECODER_LOG +"Can't parse ISO8583 message", 0);
        }

    }
}
