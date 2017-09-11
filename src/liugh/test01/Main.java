package liugh.test01;

public class Main {
	static char  label ;
	public static void main(String[] args) {
		System.out.println(test());
		System.out.println(label);
	}
    public static int test(){
    	try {
			System.out.println('A');
			return label='A';
		} finally {
			System.out.println('B');
			label='B';
		}
    }
}
