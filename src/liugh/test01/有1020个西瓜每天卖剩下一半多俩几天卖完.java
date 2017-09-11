package liugh.test01;

public class 有1020个西瓜每天卖剩下一半多俩几天卖完 {
	 public static void main(String[] args) {
		int i =0;
		int num =1020;
		int sales;	//每天售卖西瓜数量
		while(true){
			i++;
			sales = num / 2 + 2;	//每天售出一半多两个
			num -=sales;
			System.out.println("第"+i+"天后,剩下"+num+"个");
			if(num==0){
				break;
			}
		}
		System.out.println(i);
		 
	 }
}
