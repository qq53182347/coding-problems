package liugh.test01;

public class 一百到两百间的质数 {
	public static void main(String[] args) {
		for (int i = 100; i <= 200; i++) {
			boolean b = true;
			for (int j = 2; j < i; j++) {
				if(i%j==0){
					b=false;
					break;
				}
			}
			if(b){
				System.out.print(i+"   ");
			}
		}
	}
}
