package cn.com.syscom.redis;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;

public class MyRedisKeyExpiredMessageDelegate implements MessageDelegate {

	 @Resource
	 private RedisTemplate<String, String> redisTemplate;
	 
	public MyRedisKeyExpiredMessageDelegate() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public void handleMessage(String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMessage(Map message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMessage(byte[] message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMessage(Serializable message) {
		// TODO Auto-generated method stub
		System.out.println("消息超时key：" + message.toString());
		System.out.println("消息内容：" + redisTemplate.opsForValue().get(message.toString()));
	}

	@Override
	public void handleMessage(Serializable message, String channel) {
		// TODO Auto-generated method stub
	}

	public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    
}
