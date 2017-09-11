package liugh.test02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock3 implements Runnable{
	    ReentrantLock lock = new ReentrantLock();

    public void run() {
	        try {
	        	if(lock.tryLock(2,TimeUnit.SECONDS)){
	        		Thread.sleep(3000);
	        	}else{
	        		System.out.println("申请锁失败");
	        	}
	        }catch(InterruptedException e){
	        	e.printStackTrace();
	        }finally {
	        	if(lock.isHeldByCurrentThread()){//如果线程持有这把锁
	        		 lock.unlock(); //释放锁
	        	}
	        }
	    }

	  public static void main(String[] args) throws InterruptedException {
		  ReentrantLock3 rt = new ReentrantLock3();
		  Thread  t1 = new Thread(rt);
		  Thread  t2 = new Thread(rt);
		  t1.start();t2.start();
	}
}
