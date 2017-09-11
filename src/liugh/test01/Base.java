package liugh.test01;

/*我们通过 Debug 能很好的了解程序的运行顺序，因为 new 了一个 Sub 对象，
且 Sub 类中没有重写构造函数，因此会调用父类的构造函数，父类 Base 的构造函数中调用了 callName 方法，
因此就在父类的 callName 方法中的输出语句打一个断点，
最后因为子类的 Sub 重写了 callName 方法， 因此也在子类中重写的 callName 方法中打一个断点。*/
public class Base {
	private String baseName = "base";

	public Base() {
		callName();
	}

	public void callName() {
		System.out.println(baseName);
	}

	static class Sub extends Base {
		private String baseName;
        public Sub(){
        	baseName = "sub";
        	this.callName();
        }
		
		public void callName() {
			System.out.println(baseName);
		}
	}

	public static void main(String[] args) {
		Base b = new Sub();
	}
}

