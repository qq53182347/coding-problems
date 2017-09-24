package liugh.test_aritmetic;

public class 用递归实现字符串倒转 {
	
	 public static void main(String[] args) {  
		 
		 System.out.println("hello".substring(1));
	      System.out.println(reverse("hello world"));  
	   }

	private static String reverse(String str) {
		if( str == null ||str.length()== 1) {  
	        return str;  
	      } 
		return reverse(str.substring(1))+str.charAt(0);  
	}

}
