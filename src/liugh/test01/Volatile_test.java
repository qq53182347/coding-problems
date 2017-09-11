package liugh.test01;

public class Volatile_test {
	    public static volatile int race = 0;  

	    public static void main(String[] args) {  
	        Thread[] threads = new Thread[10];  
	        for (int i = 0; i < threads.length; i ++) {  
	            threads[i] = new Thread(new Runnable() {  
	                @Override  
	                public void run() {  
	                    for (int i = 0; i < 1000; i++) {  
	                    	race++;  
	                    }  
	                }  
	            });  
	            threads[i].start();  
	        }  

	        // 等待所有累加线程都结束  
	        while (Thread.activeCount() > 1) {  
	            Thread.yield();  
	        }
	        System.out.println(race);  
	    } 
}
