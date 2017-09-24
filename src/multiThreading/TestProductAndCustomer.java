package multiThreading;

class Message {
    private String title;
    private String content;
    private boolean isProductNoGet = true;//true表示可以生产,但是不能取,反之亦然
	
	public synchronized void set(String title,String content) throws InterruptedException{
		if(this.isProductNoGet==false){
			super.wait();
		}
		Thread.sleep(100);
		title.hashCode();
		this.title=title;
		this.content=content;
		//如果正常生产了
		isProductNoGet=false;
		super.notify();
	}
	public synchronized void get() throws InterruptedException{
		if(this.isProductNoGet==true){
			super.wait();
		}
		Thread.sleep(10);
		System.out.println(this.content +":" +this.title);
		//表示继续生产
		isProductNoGet=true;
		super.notify();
	}
}
class Product implements Runnable{
	private Message msg;
	public Product(Message msg){
		this.msg=msg;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if(i%2==0){
				try {
					this.msg.set("高富帅", "刘广辉");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				try {
					this.msg.set("白富美", "小坛坛");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
class Customer implements Runnable{
	private Message msg;
	public Customer(Message msg){
		this.msg=msg;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				this.msg.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class TestProductAndCustomer {
	public static void main(String[] args) {
		Message msg = new Message();
		new Thread(new Product(msg)).start();
		new Thread(new Customer(msg)).start();
	}
}
