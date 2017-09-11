package liugh.test02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockOfCondition implements Runnable{
	   public static ReentrantLock lock = new ReentrantLock();
	   public static Condition condition = lock.newCondition();
	   public void run() {
	        try {
	        	lock.lock();
	        	condition.await();
	        	System.out.println("线程继续执行...");
	        }catch(InterruptedException e){
	        	e.printStackTrace();
	        }finally {
	        	if(lock.isHeldByCurrentThread()){//如果线程持有这把锁
	        		 lock.unlock(); //释放锁
	        	}
	        }
	    }

	  public static void main(String[] args) throws InterruptedException {
		  ReentrantLockOfCondition rt = new ReentrantLockOfCondition();
		  Thread  t1 = new Thread(rt);
		  t1.start();
		  Thread.sleep(2000);
	}
}
