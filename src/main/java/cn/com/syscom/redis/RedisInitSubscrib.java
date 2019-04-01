package cn.com.syscom.redis;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

@Service
public class RedisInitSubscrib {  
    
	@Resource
    JedisPool jedisPool;

    public void begin() throws Exception {
    	jedisPool.getResource().psubscribe(new OrderSubscribe(), "*");
    }
    
}
