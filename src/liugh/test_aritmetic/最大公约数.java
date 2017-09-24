package liugh.test_aritmetic;

public class 最大公约数 {
	//辗转相除法
	public static int  gcd(int  x,  int y) {
	    if (y == 0)
	        return x;
	    else
	        return gcd(y, x % y);
	}
  //最小公倍数(Least Common Multiple)　  
    public static int lcm(int p,int q){  
          int pq = p * q;  
          return pq / gcd(p,q);  
     } 
    public static void main(String[] args) {
		int a = 100;
		int b =  18;
//		System.out.println("最大公约数:"+gcd(a,b));
//		System.out.println("最小公倍数:"+lcm(a,b));
	    int m,n;
	    commonDivisor use=new commonDivisor();
        m=use.commonDivisor(a,b);
        n=a*b/m;
        System.out.println("最大公约数："+m);
        System.out.println("最小公倍数："+n); 
	}
}
class commonDivisor{
    public int commonDivisor(int x,int y){
        if(x<y){
            int t=x;
            x=y;
            y=t;
        }
        while(y!=0){
            if(x==y)return x;
            else{
                int k=x%y;
                x=y;
                y=k;
            }
        }
        return x;
    }
}