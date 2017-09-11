package liugh.test01;

public class 给一个数组其中有一个重复元素占半数以上找出这个元素 {
	//给一个数组，其中有一个重复元素占半数以上，找出这个元素。
	 public static <T> T find(T[] x){  
	      T temp = null; 
	      int  nTimes = 0;
	      for(int i = 0; i< x.length;i++) {  
	        if(nTimes == 0) {  
	           temp= x[i];  
	           nTimes= 1;  
	        }else {  
	           if(x[i].equals(temp)) {  
	              nTimes++;  
	           }else {  
	              nTimes--;  
	           }  
	        }  
	      }  
	      return temp;  
	   }  
	    
	   public static void main(String[] args) {  
	      String[]strs = {"hello","kiss","hello","maybe"};  
	      System.out.println(find(strs));  
	   }  

}
