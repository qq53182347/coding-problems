package 多线程_线程间的通信.生产者消费者模型.volatile关键字;

public class Visibility implements Runnable{
	 private  boolean isStoped = false;
	 
	    public void run() {
	        int i = 0;
	        while(!isStoped) {
	            i++;
	        }
	        System.out.println("finish loop,i=" + i);
	    }
	 
	    public void stopIt() {
	    	isStoped = true;
	    }
	 
	    public boolean getStop(){
	        return isStoped;
	    }
	    public static void main(String[] args) throws Exception {
	    	Visibility visibility = new Visibility();
	    	new Thread(visibility,"visibility").start();
	        Thread.sleep(1000);
	        visibility.stopIt();
	        Thread.sleep(1000);
	        System.out.println("finish main");
	        System.out.println(visibility.getStop());
	    }
}
