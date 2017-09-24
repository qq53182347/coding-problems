package multiThreading.自定义线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;



public class UseThreadPoolExecutor1 {
	public static void main(String[] args) {
		ThreadPoolExecutor pool = new ThreadPoolExecutor(
				1, 				//coreSize
				2, 				//MaxSize
				60, 			//60
				TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(3)			//指定一种队列 （有界队列）
				//new LinkedBlockingQueue<Runnable>()
				, new MyRejected()
				//, new DiscardOldestPolicy()//直接抛出异常
				);
		
		MyTask mt1 = new MyTask(1, "任务1");//第一个任务会直接执行
		MyTask mt2 = new MyTask(2, "任务2");//第二个任务会放入队列里,等第一个任务执行完以后才执行
		MyTask mt3 = new MyTask(3, "任务3");//因为队列里有三个容量,所以任务3也会放入队列里
		MyTask mt4 = new MyTask(4, "任务4");//因为队列里有三个容量,所以任务4也会放入队列里
		MyTask mt5 = new MyTask(5, "任务5");//假如有5个任务,任务1和5同时执行,任务234放在队列里
		MyTask mt6 = new MyTask(6, "任务6");//队列满了,线程池的最大线程数也超过了,则会实行拒绝策略
		
		pool.execute(mt1);
		pool.execute(mt2);
		pool.execute(mt3);
		pool.execute(mt4);
		pool.execute(mt5);
		pool.execute(mt6);
		
		pool.shutdown();
	}
}
class MyRejected implements RejectedExecutionHandler{
	@Override
	//传入当前任务对象和当前线程池对象
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		//1.可以做一些处理,比如用http再创建请求给传数据的客户端,让它重新发送任务。高峰期的时候，系统已经超负荷了，不建议再发送请求
		//2.只是记录日志：id及相关重要的信息,暂缓到磁盘上，在不是高峰期的时候跑一些定时的job解析日志,把没处理的任务再处理一遍或者批处理下,一般用这个
		System.out.println("自定义处理..");
		System.out.println("当前被拒绝任务为：" + r.toString());
	}
}
class MyTask implements Runnable {
	private int taskId;
	private String taskName;
	
	public MyTask(int taskId, String taskName){this.taskId = taskId;this.taskName = taskName;}
	public int getTaskId() {return taskId;}
	public void setTaskId(int taskId) {this.taskId = taskId;}
	public String getTaskName() {return taskName;}
	public void setTaskName(String taskName) {this.taskName = taskName;}
	
	@Override
	public void run() {
		try {
			System.out.println("run taskId =" + this.taskId);
			Thread.sleep(3000);
			//System.out.println("end taskId =" + this.taskId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	public String toString(){
		return Integer.toString(this.taskId);
	}
}