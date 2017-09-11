package liugh.test01;

import java.util.LinkedList;

public class 不用统计变量求出字符串长度 {
	public static void main(String[] args) {
		String str = "hello";
		System.out.println(test(str));
		StringBuilder sb = new StringBuilder();
		LinkedList list = new LinkedList();
		Integer i= 0;
	}
	
	public  static int test(String str){
		if(str.length()==0){
			return 0;
		}
		String temp = str.substring(1,str.length());
		return  test(temp)+1;
	}
	
	static int test1(String str){
		if(null==str||str.equals("")){
			return 0;
		}
		String[] strs = str.split("");
		StringBuffer sb = new StringBuffer();//每次截取最后一个字母
		for(int i = 0; i <= strs.length-2; i++)
		{ 
		    sb. append(strs[i]);
		}
		return test1(sb.toString())+1;
	}
}
