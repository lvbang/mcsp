package cn.com.syscom.inter.visainterface;

import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import cn.com.syscom.iso8583.IsoMessage;

@Service
public class MessageHashMap {
    private ConcurrentHashMap<String, IsoMessage> isoMessages = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String ,TimerTask> messageTimer = new ConcurrentHashMap<>();
    
	public ConcurrentHashMap<String, IsoMessage> getIsoMessages() {
		return isoMessages;
	}

	public void setIsoMessages(ConcurrentHashMap<String, IsoMessage> isoMessages) {
		this.isoMessages = isoMessages;
	}

	public ConcurrentHashMap<String ,TimerTask> getMessageTimer() {
		return messageTimer;
	}

	public void setMessageTimer(ConcurrentHashMap<String ,TimerTask> messageTimer) {
		this.messageTimer = messageTimer;
	}
}
