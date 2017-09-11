

package liugh.test01;

/*
 * 有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第四 个月后每个月又生一对兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少?
 */
public class 兔子生兔子 {
	   static int fun(int i){
	        if( i == 1  || i == 2 ){
	            return 1;
	        }
	        else{
	            return fun(i-1) + fun(i-2);
	        }
	    }
	 //这是斐波那契数列,规律是:从第三个数开始,每个数都是前两个数的合.
	 //1,1,2,3,5,8,13,21....
	 //Sn = Sn-1+Sn-2
	public static void main(String[] args) {
		   System.out.println(兔子生兔子.fun(10));
		 
		    int month =10; 
	        int sum[]= new int[month] ; 
	        sum[0] = 1; 
	        sum[1] = 1; 
	             
	        for(int i=2;i<=month-1;i++){ 
	            sum[i] = sum[i-1]+sum[i-2]; 
	        } 
	                 
	        System.out.println("第"+month+"个月的兔子总数是："+sum[month-1]); 
	}

}