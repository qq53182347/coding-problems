package liugh.test_aritmetic;

public class 异常的执行顺序 {
	public static void main(String[] args) {
		System.out.println(test());
	}
	public static int test(){
		int i =10;
		try {
			System.out.println(i/0);
			i=20;
		} catch (Exception e) {
			i=30;
			return i;
		}finally{
			i=40;
		}
		return i;
	}
}
