package 多线程_线程间的通信.生产者消费者模型;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedInputStreamHosee {
	final PipedInputStream pis = new PipedInputStream();
	final PipedOutputStream pos = new PipedOutputStream();
	{
		try {
			pis.connect(pos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class Producer implements Runnable {
		@Override
		public void run() {
			try{
                while(true){
                    int b = (int) (Math.random() * 255);
                    System.out.println("Producer: a byte, the value is " + b);
                    pos.write(b);
                    pos.flush();
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    pos.close();
                    pis.close();
                }catch(IOException e){
                    System.out.println(e);
                }
            }
		}
	}

	class Consumer implements Runnable {

		@Override
		public void run() {
			try{
                while(true){
                    int b = pis.read();
                    System.out.println("Consumer: a byte, the value is " + String.valueOf(b));
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    pos.close();
                    pis.close();
                }catch(IOException e){
                    System.out.println(e);
                }
            }
		}

	}

	public static void main(String[] args) throws Exception {
		PipedInputStreamHosee hosee = new PipedInputStreamHosee();
		new Thread(hosee.new Producer()).start();
		new Thread(hosee.new Consumer()).start();
	}
}
