package cn.com.syscom.redis;

import redis.clients.jedis.JedisPubSub;

public class OrderSubscribe extends JedisPubSub {
    
    public void onPSubscribe(String pattern, int subscribedChannels) {   
    }  
      
    public void onPMessage(String pattern, String channel, String message) {    
            if ("__keyevent@0__:expired".equals(channel)) {
                //do some thing
            	System.out.println("pattern:" + pattern + "   channel:" + channel + "   message:" + message + "ÏûÏ¢³¬Ê±");
            }
    }
}
