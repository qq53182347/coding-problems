package liugh.test01;

import java.util.HashMap;

public class 统计字符串里字符出现的个数 {

	public static void main(String[] args) {
		System.out.println(test("asdfaa"));
	}
	public static HashMap<Character,Integer>  test(String str){
		char[] charArray = str.toCharArray();
		HashMap<Character,Integer> retMap  = new HashMap<Character,Integer>();
		for (int i = 0; i < charArray.length; i++) {
			if(retMap.containsKey(charArray[i])){
				int count =retMap.get(charArray[i])+1;
				retMap.put(charArray[i], count);
			}else{
				retMap.put(charArray[i],1);
			}
		}
		return retMap;
	}
}
