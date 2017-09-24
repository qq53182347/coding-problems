package liugh.test_aritmetic;

import java.math.BigDecimal;

/*
 * 1！+2！+3！+……+10！的和
 */
public class 阶乘 {
	public static void main(String[] args) {
		int sum = 0; 
		for(int i=1;i<=10;i++){ 
			int temp = 1; 
			for(int j=1;j<=i;j++){ 
				temp*=j; 
			} 
			sum+=temp; 
		} 
		//System.out.println("1-10阶乘和为："+sum); 
		
		int start =1;
		int end = 10;
		int tt =(start+end)*end/2;
//		System.out.println(tt);
//		
//		System.out.println(test(10));
		
		System.out.println(test2(100));
	}
	
	public static  String test2(int n){
		BigDecimal bd = new BigDecimal(1);
		for (int i = 1; i <= n; i++) {
			 bd = bd.multiply(new BigDecimal(i));
		}
		return bd.toString();
	}
	
	static int test(int n){
		if(n==1){
			return 1;
		}else{
			return n+test(n-1);
		}
	}
	
	
	
	
}
