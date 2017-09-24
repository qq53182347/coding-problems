package liugh.test_aritmetic;

//经典嵌套错误:非静态代码块在每次实例化时都会执行,然后非静态化中有实例化的操作

public class Tt {
	private static Tt tt;
	static{
		System.out.println(1);
		tt=new Tt();
	}
	{
		tt=new Tt();
		System.out.println(3);
	}
	public Tt(){
		System.out.println(2);
	}
	public static void main(String[] args) {
		System.out.println(Tt.tt);
	}
}
