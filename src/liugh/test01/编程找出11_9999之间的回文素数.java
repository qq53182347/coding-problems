package liugh.test01;

public class 编程找出11_9999之间的回文素数 {
	public static void main(String[] args) {  
	      for(int i = 11; i <= 9999;i++) {  
	        if(isPrime(i) && isPalindromic(i)) {  
	           System.out.println(i);  
	        }  
	      }
	   }  
	  //判斷是否是素數	
	   public static boolean isPrime(int n) {  
	      for(int i = 2; i <= Math.sqrt(n);i++) {  
	         if(n % i == 0) {  
	           return false;  
	        }  
	      }  
	      return true;  
	   }  
//	   hundred = i / 100; //百位   
//     ten = i % 100 / 10;//十位
//     bits = i % 10;    //个位
	   public static boolean isPalindromic(int n) { 
		  StringBuilder sb = new StringBuilder(String.valueOf(n));
		  sb.reverse();
//	      int temp = n;  
//	      int sum = 0;  
//	      while(temp > 0) {  
//	        sum= sum * 10 + temp % 10;  
//	        temp/= 10;  
//	      }  
	      return Integer.parseInt(sb.toString()) == n; 
	   }  
}
