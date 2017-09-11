package 多线程_线程间的通信.生产者消费者模型;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueHosee {
	//数据生产器
	private static AtomicInteger count = new AtomicInteger();
	
	final BlockingQueue<Integer> bq = new LinkedBlockingQueue<Integer>(10);
	
	 class Producer implements Runnable {
		//多线程间是否启动变量，有强制从主内存中刷新的功能。即时返回线程的状态
		private volatile boolean isRunning = true;
		//随机对象
		private  Random r = new Random(); 
		@Override
		public void run() {
			while(isRunning){
				try {
					//随机休眠0 - 1000 毫秒 表示获取数据(产生数据的耗时) 
					Thread.sleep(r.nextInt(1000));
					//获取的数据进行累计..
					int incrementCount = count.incrementAndGet();
					bq.put(incrementCount);
					System.out.println(
							"当前线程:" + Thread.currentThread().getName() + ", 生产了数据"+incrementCount+", 进行装载到公共缓冲区中..."
							);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		public void stop(){
			this.isRunning = false;
		}
	}

	class Consumer implements Runnable {
		//随机对象
		private  Random r = new Random(); 
		@Override
		public void run() {
			while(true){
				try {
					Integer take = bq.take();
					//进行数据处理。休眠0 - 1000毫秒模拟耗时
					Thread.sleep(r.nextInt(1000));
					System.out.println("当前消费线程：" + Thread.currentThread().getName() + "， 消费成功，消费数据为id: " + take);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BlockingQueueHosee hosee = new BlockingQueueHosee();
		Producer producer = hosee.new Producer();
		new Thread(producer,"生产者").start();
		new Thread(hosee.new Consumer(),"消费者1").start();
		new Thread(hosee.new Consumer(),"消费者2").start();
		Thread.sleep(3000);
		producer.stop();
	}
}
