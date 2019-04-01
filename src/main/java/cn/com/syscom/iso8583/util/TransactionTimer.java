package cn.com.syscom.iso8583.util;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import cn.com.syscom.iso8583.util.DefaultTimer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.TimeoutUtils;

import cn.com.syscom.inter.visainterface.MessageHashMap;

public class TransactionTimer {
	
	public Logger logger = LoggerFactory.getLogger(TransactionTimer.class);
	
	Timer timer = DefaultTimer.getTimer();
	public TransactionTimer() {
	}
	
	public TransactionTimer(TimerTask timerTask, final String transKey,final long timeout,final TimeUnit unit,MessageHashMap messageHashMap ) {
		
		long rawTimeout = TimeoutUtils.toMillis(timeout, unit);
		
		timer.schedule(timerTask, rawTimeout);
	}
}
