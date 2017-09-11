package liugh.test01;

public class n级的台阶一次可以走1级_2级或3级问走完n级台阶有多少种走法 {
	
	/*
	 题目:一个有n级的台阶，一次可以走1级、2级或3级，问走完n级台阶有多少种走法。
		这个问题本质上是斐波那契数列
		1,1,2,3,5,8,13,21....
		Sn = Sn-1+Sn-2
	*/
	public static int countWays(int n) {   
        if(n < 0)  return 0;   
        else if(n == 0) return 1;   
        else   
            return countWays(n - 1) + countWays(n - 2) + countWays(n -3);   
   }   
   public static void main(String[] args) {   
        System.out.println(countWays(5));   // 13
        System.out.println(fun(5));
	    int month =5; 
        int sum[]= new int[month] ; 
        sum[0] = 1;sum[1] = 1; 
        for(int i=2;i<=month-1;i++){ 
            sum[i] = sum[i-1]+sum[i-2]; 
        } 
        System.out.println("第"+month+"个月的兔子总数是："+sum[month-1]); 
   }   
  public static int fun(int i){
       if( i == 1  || i == 2 ){
           return 1;
       }else{
           return fun(i-1) + fun(i-2);
       }
   }

}
