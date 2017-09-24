package liugh.test_relizeDataStructure.栈;

public class Main {

	public static void main(String[] args) {
		Mystack<String> t = new Mystack<String>();
		t.add("a");
		t.add("b");
		t.add("c");
		t.add("d");
		t.add("e");
		System.out.println(t);
		t.add("f");
		System.out.println(t);
		System.out.println(t.peek());
		System.out.println(t.pop());
		System.out.println(t);
		System.out.println(t.isEmtype());
		System.out.println(t.size());
	}
}
