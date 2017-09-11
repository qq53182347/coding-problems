package 多线程_线程间的通信.生产者消费者模型.height.concurrent017;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class UseExecutors {

	public static void main(String[] args) {
		
		ExecutorService cachePool = Executors.newCachedThreadPool();
		ExecutorService Pool1 = Executors.newFixedThreadPool(3);
		ExecutorService Pool2 = Executors.newSingleThreadExecutor();
		ExecutorService Pool3 = Executors.newScheduledThreadPool(2);
		
		
		
	}
}
