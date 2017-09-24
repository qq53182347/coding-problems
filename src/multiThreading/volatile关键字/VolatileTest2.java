package multiThreading.volatile关键字;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest2 {
    public  AtomicInteger count = new AtomicInteger();
    public  void increase() {
    	count.getAndIncrement();
    }
    public static void main(String[] args) {
        final VolatileTest2 test = new VolatileTest2();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }
        while(Thread.activeCount()>1){  
            Thread.yield();
        }
        System.out.println(test.count.get());
    }
}
