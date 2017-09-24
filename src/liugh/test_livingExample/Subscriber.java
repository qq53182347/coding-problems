package liugh.test_livingExample;

import redis.clients.jedis.Jedis;

//订阅者：
public class Subscriber {
	public static void main(String[] args) throws InterruptedException {
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
		
		//测试redis键空间通知机制
		
//		jedis.set("notify", "刘大神");
//	    jedis.expire("notify", 5);
//      jedis.psubscribe(new KeyExpiredListener(), "__keyevent@0__:expired");
	    
        
		
		
		
		
		//使用redis的setNX命令可以实现分布式锁
		
        //将key的值设为value，当且仅当key不存在时。返回1
		 //若key已经存在，不做任何动作 。  返回0
        jedis.setnx("NX", "刘大神");
        jedis.expire("NX", 5);
//        如果 SETNX 返回1，说明该进程获得锁，SETNX将键 lock.foo 的值设置为锁的超时时间（当前时间 + 锁的有效时间）。 
//        如果 SETNX 返回0，说明其他进程已经获得了锁，进程不能进入临界区。进程可以在一个循环中不断地尝试 SETNX 操作，以获得锁。
         System.out.println(jedis.get("NX"));
        

    }
}
