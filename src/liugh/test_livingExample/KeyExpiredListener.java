package liugh.test_livingExample;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class KeyExpiredListener extends JedisPubSub {  
	
	 static Jedis jedis = new Jedis("192.168.31.168", 6379, 0);
	
	 @Override
	    public void onPSubscribe(String pattern, int subscribedChannels) {
		 String str = KeyExpiredListener.jedis.get("notify");
		 System.out.println("onPSubscribe:"+str);
//		 System.out.println("onPSubscribe method...");
//	        System.out.println("onPSubscribe "
//	                + pattern + " " + subscribedChannels);
	    }

	    @Override
	    public void onPMessage(String pattern, String channel, String message) {
	    	 String str = KeyExpiredListener.jedis.get("notify");
			 System.out.println("onPMessage:"+str);
//          System.out.println("onPMessage method...");
//	        System.out.println("onPMessage pattern "
//	                        + pattern + " " + channel + " " + message);
	    }

}  
