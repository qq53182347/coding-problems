package liugh.test_aritmetic;

public class 一百以内的素数 {
	//100以内的素数(质数)
		public static void main(String[] args) {
			for(int x=2;x<=100;x++)  
	        {  
	            boolean flag =true;  
	            for(int y=2;y<=(int)Math.sqrt(x);y++)  
	            {  
	                if(x%y==0)  
	                {  
	                    //当能整除时，即不满足是素数情况，改变标识符，  
	                    //并退出当前for循环，x++,判断下一个x是否为素数  
	                    flag=false;  
	                    break;  
	                }  
	            }  
	            //if语句与内for为并列代码块，当内for语句不满足条件，  
	            //即没有可以整除的数，则是素数，标识符未被改变，还为true,打印这个数。  
	            if(flag)  
	            {  
	                System.out.println(x);  
	            }  
	        }  
	          
		}
}
