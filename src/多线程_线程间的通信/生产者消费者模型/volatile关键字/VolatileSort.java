package 多线程_线程间的通信.生产者消费者模型.volatile关键字;

public class VolatileSort {
	int a =0;
	boolean flag = false;
	public void write(){
		a=1;
		flag =true;
	}
	public void read(){
		if(flag){
			int i=a+1;
			//...
		}
	}
}
