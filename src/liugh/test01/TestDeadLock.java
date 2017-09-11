package liugh.test01;

public class TestDeadLock {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt, "张三").start();
        new Thread(mt, "李四").start();
    }
}
class MyThread extends Thread {
	private Object o1 = new Object();
	private Object o2 = new Object();
	private boolean flag = true;
	@Override
	public void run() {
		try {
			if (flag) {
				flag = false;
				synchronized (o1) {
					System.out.println(Thread.currentThread().getName() + " have o1");
					Thread.sleep(100);
					synchronized (o2) {
						System.out.println(Thread.currentThread().getName() + " have o2");
					}
				}
			} else {
				flag = true;
				synchronized (o2) {
					System.out.println(Thread.currentThread().getName() + " have o2");
					Thread.sleep(100);
					synchronized (o1) {
						System.out.println(Thread.currentThread().getName() + " have o1");
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
