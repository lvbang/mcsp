package cn.com.syscom.inter.visainterface;

import java.util.Date;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.syscom.inter.visainterface.MessageHashMap;
import cn.com.syscom.iso8583.IsoMessage;
import cn.com.syscom.iso8583.IsoType;
import cn.com.syscom.iso8583.util.TPS;
import cn.com.syscom.mcsp.service.impl.PtlfIncreServiceImpl;
import cn.com.syscom.mcsp.service.impl.PtlfServiceImpl;

public class TimerTaskImpl extends TimerTask {
    private Logger logger = LoggerFactory.getLogger(TimerTaskImpl.class);
	private String transKey;
	private MessageHashMap messageHashMap;
	
    private AmqpTemplate amqpTemplateVisa;
   // private IsoMessage isoMessage;
    
    private PtlfServiceImpl ptlfServiceImpl;
    
    private PtlfIncreServiceImpl ptlfIncreServiceImpl;
    
    private TPS tps;
    
	public TimerTaskImpl(String transKey,MessageHashMap messageHashMap,AmqpTemplate amqpTemplateVisa,PtlfIncreServiceImpl ptlfIncreServiceImpl,TPS tps) {
		// TODO Auto-generated constructor stub
		this.transKey = transKey;
		this.messageHashMap = messageHashMap;
		this.amqpTemplateVisa = amqpTemplateVisa;
		this.ptlfIncreServiceImpl = ptlfIncreServiceImpl;
		this.tps = tps;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		IsoMessage isoMessage = messageHashMap.getIsoMessages().get(transKey);
		if ((isoMessage != null)  && (isoMessage.getType() != 0x800)) {
			isoMessage.setType(isoMessage.getType() + 16);
			isoMessage.setValue(39, "05", IsoType.ALPHA, 2);
			tps.denycntTick();
		   	int len = 0;
	 		len = isoMessage.getMessageLen();
	 		byte[] byteLen = new byte[2];
	 		byteLen[0] = (byte) ((len >> 8) & 0xFF);  
	 		byteLen[1] = (byte) (len & 0xFF);

	 		//替换head中的报文长度
	 		byte[] head = isoMessage.getBinaryIsoHeader();
	 		System.arraycopy(byteLen, 0, head, 3, 2);
	 		isoMessage.setBinaryIsoHeader(head);
			logger.info(transKey + "消息超时,发送超时报文到Q7");
            byte[] by = isoMessage.writeData();
            byte[] sendMessage = new byte[by.length + isoMessage.getNetworkMatch().length];
            System.arraycopy(isoMessage.getNetworkMatch(), 0, sendMessage, 0, 50);
            System.arraycopy(by, 0, sendMessage, 50, by.length);

	        amqpTemplateVisa.convertAndSend("VISA_Response", sendMessage);
	        isoMessage.setTimeOutTrans(true);
	        isoMessage.setEndEsbTime(new Date().getTime());
	        isoMessage.setEndVisaTime(new Date().getTime());
	        if (ptlfIncreServiceImpl != null) {
	        	ptlfIncreServiceImpl.insert(isoMessage, null);
			}
		} 
		messageHashMap.getIsoMessages().remove(transKey);
		messageHashMap.getMessageTimer().remove(transKey);
	}

}
