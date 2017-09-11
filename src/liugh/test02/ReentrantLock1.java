package liugh.test02;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1 implements Runnable{
	    private static int  a    = 0;
	    ReentrantLock lock = new ReentrantLock();

	    public void run() {
	    	for (int i = 0; i < 10000000; i++) {
	    		//一个线程拿到几个许可 就得释放几次,不然就造成等待 可在命令行查看jps -->jstack 10840
		        lock.lock(); //获取锁
		        lock.lock(); //获取锁
		        try {
		            a++;
		        } finally {
		            lock.unlock(); //释放锁
		            //lock.unlock(); //释放锁
		        }
	    	}
	    }

	  public static void main(String[] args) throws InterruptedException {
		  ReentrantLock1 rt = new ReentrantLock1();
		  Thread  t1 = new Thread(rt);
		  Thread  t2 = new Thread(rt);
		  t1.start();t2.start();
		  t1.join();t2.join();
		  System.out.println(a);
	}
}
