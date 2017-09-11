package liugh.test01;

public class 两个数返回大数能否被小数整除 {

	public static void main(String[] args) {
		System.out.println(test(81,4));
	}
	public static boolean test(int x,int y){
		return (x<y?y%x:x%y)==0;
	}
}
