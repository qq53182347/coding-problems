package liugh.test02;

import java.lang.ref.SoftReference;

public class SoftReferenceTest {
	
	public static void main(String[] args) {
		Object obj = new Object();
		SoftReference<Object> sf = new SoftReference<Object>(obj);
		obj = null;
		sf.get();//有时候会返回null
	}

}
