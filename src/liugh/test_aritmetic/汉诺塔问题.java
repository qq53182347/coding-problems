package liugh.test_aritmetic;

public class 汉诺塔问题 {
	static int t=0;
	public static void main(String[] args) {
		hanio(3,"x","y","z");
		System.out.println(t);
	}
	 static void  hanio(int n ,String src,String mid,String dest){
		if(n==1){
			System.out.println(src+"-->"+dest);
			t++;
		}else{
			hanio(n-1,src,dest,mid);
			hanio(1,src,"",dest);//因为中间柱子没用到,所以可以填""或者填mid
			hanio(n-1,mid,src,dest);
		}
	}
}
