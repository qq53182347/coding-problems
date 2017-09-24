package liugh.test_aritmetic;

public class 杨辉三角 {
	public static void main(String[] args) {
		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n-i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(num(i,j));
			}
			System.out.println();
		}
		//System.out.println(5%20);
		
	}
	public static int num(int x,int y){
		if(y==1||y==x){
			return 1;
		}
			return num(x-1,y-1)+num(x-1,y);//每一个数等于肩上两个数之和
	}
	
}
