package liugh.test01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 给定四个线程id分别是aa_bb_cc_dd请用Java实现循环输出10次aabbccdd {
	private static int state = 0;  
	public static void main(String[] args) {
		//给定四个线程，id分别是aa，bb，cc，dd，请用Java实现循环输出10次aabbccdd
		final Lock l = new ReentrantLock();  
		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (state <= 40) {
					l.lock();
					if (state % 4 == 0) {
						System.out.print(++i + "AA");
						state++;
					}
					l.unlock();
				}
			}
		});  
		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (state <= 40) {
					l.lock();
					if (state % 4 == 1) {
						System.out.print(++i + "BB");
						state++;
					}
					l.unlock();
				}
			}
		});
		Thread C = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (state <= 40) {
					l.lock();
					if (state % 4 == 2) {
						System.out.print(++i + "CC");
						state++;
					}
					l.unlock();
				}
			}
		});
		Thread D = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				while (state <= 40) {
					l.lock();
					if (state % 4 == 3) {
						System.out.print(++i + "DD");
						state++;
					}
					l.unlock();
				}
			}
		});
		A.start();
		B.start();
		C.start();
		D.start();
	}

}
