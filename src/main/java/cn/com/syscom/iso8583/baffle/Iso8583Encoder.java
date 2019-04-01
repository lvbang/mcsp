package cn.com.syscom.iso8583.baffle;

import java.io.FileInputStream;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.MessageFactory;
import cn.com.syscom.iso8583.util.MessageTemplate;

public class Iso8583Encoder<T> {
    private Logger logger = LoggerFactory.getLogger(Iso8583Encoder.class);
    private final int lengthHeaderLength;
    private final MessageFactory<IsoMessage> messageFactory;
    
    public Iso8583Encoder(MessageFactory<IsoMessage> messageFactory,int lengthHeaderLength) {
    	this.messageFactory = messageFactory;
        this.lengthHeaderLength = lengthHeaderLength;
    }
    
    
    public byte[] encode(IsoMessage isomessage) {
    	IsoMessage respMessage = (IsoMessage) messageFactory.createResponse( isomessage);
    	//respMessage.setValue(39, "01", IsoType.ALPHA, 2);
    	
    	IsoMessageLoggingHandler isoMessageLoggingHandler = new IsoMessageLoggingHandler(false,true);
    	logger.debug(MessageTemplate.MSG_ISO8583_ENCODER_LOG + isoMessageLoggingHandler.formatIsoMessage(respMessage));
    	
    	int len = 0;
  		respMessage.setBinaryIsoHeader(isomessage.getBinaryIsoHeader());
 		len = respMessage.getMessageLen();
 		byte[] byteLen = new byte[2];
 		byteLen[0] = (byte) ((len >> 8) & 0xFF);  
 		byteLen[1] = (byte) (len & 0xFF);

 		//替换head中的报文长度
 		byte[] head = isomessage.getBinaryIsoHeader();
 		System.arraycopy(byteLen, 0, head, 3, 2);
 		respMessage.setBinaryIsoHeader(head);
    	 
        if (lengthHeaderLength == 0) {
            byte[] bytes = respMessage.writeData();
            return bytes;
        } else {
        	byte[] byteBuffer = respMessage.writeToBuffer(lengthHeaderLength).array();
            return byteBuffer;
        }
    }

    public byte[] encode(IsoMessage isomessage,int encodeType) throws Exception {
		if (encodeType == 1) {
			logger.info(MessageTemplate.MSG_ISO8583_ENCODER_LOG + "-------------VISA报文组包-------------");
			return encode(isomessage);
		} else if (encodeType == 2){
			logger.info(MessageTemplate.MSG_ISO8583_ENCODER_LOG + "-------------CUP银联报文组包-------------");
	    	IsoMessage respMessage = (IsoMessage) messageFactory.createResponse( isomessage);
	    	respMessage.setValue(39, "00", IsoType.ALPHA, 2);
	    	IsoMessageLoggingHandler isoMessageLoggingHandler = new IsoMessageLoggingHandler(false,true);
	    	logger.debug(isoMessageLoggingHandler.formatIsoMessage(respMessage));
	        if (lengthHeaderLength == 0) {
	            byte[] bytes = respMessage.writeData();
	            return bytes;
	        } else {
	        	byte[] byteBuffer = respMessage.writeToBuffer(lengthHeaderLength).array();
	            return byteBuffer;
	        }
		} else {
            throw new Exception(MessageTemplate.MSG_ISO8583_ENCODER_LOG + "encodeType error");
        }
    }
    
	public MessageFactory<IsoMessage> getMessageFactory() {
		return messageFactory;
	}
}
