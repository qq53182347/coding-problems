package 多线程_线程间的通信.生产者消费者模型.volatile关键字;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileTest {
    public volatile int inc = 0;
       //解决方法之一
    Lock lock = new ReentrantLock();
    public  void increase() {
        lock.lock();
        try {
            inc++;
        } finally{
            lock.unlock();
        }
    }
    //解决方法之二
//  public synchronized  void increase() {
//    public void increase() {
//        inc++;
//    }
    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }
       //保证前面的线程都执行完
        while(Thread.activeCount()>1){  
            Thread.yield();
        }
        //执行结果并不是10000
        System.out.println(test.inc);
    }
}
