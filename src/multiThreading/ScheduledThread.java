package multiThreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThread {
	public static void main(String args[]) throws Exception {
    	Temp command = new Temp();
    	//创建一个实现定时器的线程池
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        //command表示具体的任务对象,第一个数字表示初始化的时间,第二个数字表示轮询的时间
        ScheduledFuture<?> scheduleTask = scheduler.scheduleWithFixedDelay(command, 3, 1, TimeUnit.SECONDS);
    }
}
class Temp extends Thread {
    public void run() {
        System.out.println("run");
    }
}