package liugh.test05;

import redis.clients.jedis.Jedis;

//订阅者：
public class Subscriber {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.31.168", 6379, 0);
		//链接集群
//		Set<HostAndPort> nodes = new HashSet<HostAndPort>();  
//	    nodes.add( new HostAndPort("192.168.0.103" , 6379));  
//	    nodes.add( new HostAndPort("192.168.0.103" , 6380));  
//	    nodes.add( new HostAndPort("192.168.0.104" , 6379));  
//	    nodes.add( new HostAndPort("192.168.0.104" , 6380));  
//	    nodes.add( new HostAndPort("192.168.0.105" , 6379));  
//	    nodes.add( new HostAndPort("192.168.0.105" , 6380));  
//      JedisCluster jedisCluster = new JedisCluster(nodes); 
		
		
		jedis.set("notify", "刘大神");
	    jedis.expire("notify", 10);
	    
	    
        jedis.psubscribe(new KeyExpiredListener(), "__keyevent@0__:expired");
	    System.out.println( jedis.get("notify"));
	    
	    

    }
}
