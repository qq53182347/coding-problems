package liugh.test02;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock2 implements Runnable{
	    int  lock ;
	    private static  ReentrantLock lock2 = new ReentrantLock();
	    private static  ReentrantLock lock1 = new ReentrantLock();

	    public ReentrantLock2(int lock){
	    	this.lock=lock;
	    }
	    //两个线程控制加锁顺序,构造死锁现象,lock1去申请lock2,lock2会申请lock1,如果使用lock方法,不太有办法把它解开.使用lockInterruptibly加锁,可以使用中断导致线程正常结束
	    public void run() {
	    	try {
				if(lock==1){
					lock1.lockInterruptibly();//可中断的加锁.如果不加这个,只是简单的lock,是不会响应中断的
						Thread.sleep(500);
					lock2.lockInterruptibly();
				}else{
					lock2.lockInterruptibly();
						Thread.sleep(500);
					lock1.lockInterruptibly();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				//实际业务中可以在中断后做一些补救措施....
			}finally{
				if(lock1.isHeldByCurrentThread()){//如果拿了这把锁
					lock1.unlock();//解锁
				}
				if(lock2.isHeldByCurrentThread()){
					lock2.unlock();
				}
				System.out.println(Thread.currentThread().getId()+":线程退出");
			}
	    	
	    }

	  public static void main(String[] args) throws InterruptedException {
		  ReentrantLock2 rt1 = new ReentrantLock2(1);
		  ReentrantLock2 rt2 = new ReentrantLock2(2);
		  Thread  t1 = new Thread(rt1);
		  Thread  t2 = new Thread(rt2);
		  t1.start();t2.start();
		  Thread.sleep(1000);
		  //中断其中一个线程
		  DeadLockCheckChecker.check();
	}
}
class DeadLockCheckChecker {
	  private  final static ThreadMXBean mbean=ManagementFactory.getThreadMXBean();
	    final static Runnable deadLockCheck=new Runnable() {
	        @Override
	        public void run() {
	            while (true){
	                long[] deadLockedThreadIds=mbean.findDeadlockedThreads();
	                if(deadLockedThreadIds!=null){
	                    ThreadInfo[] threadInfos=mbean.getThreadInfo(deadLockedThreadIds);
	                    for(Thread t: Thread.getAllStackTraces().keySet()){
	                        for(int i=0;i<threadInfos.length;i++){
	                            if(t.getId()==threadInfos[i].getThreadId()){//如果检查到了死锁
	                                t.interrupt();//中断当前线程
	                            }
	                        }
	                    }
	                }
	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException e) {
	                }
	            }

	        }
	    };


	    public static void check(){
	        Thread thread=new Thread(deadLockCheck);
	        thread.setDaemon(true);//如果说整个程序都退出了,我就没有必要做死锁检查,所以要设置为守护线程
	        thread.start();
	    }
}
