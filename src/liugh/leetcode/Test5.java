package liugh.leetcode;


/**
 给定一个字符串小号，发现最长的回文子小号。你可以假定s的最大长度是1000。
例：
输入： “babad”
输出： “bab”
注意： “aba”也是一个有效的答案。
例：
输入： “cbbd”
输出： “bb”
 *
 */
public class Test5 {

	public static void  main(String [] args){
		
	    
	    String str = "yangcq";  
//		System.out.println(new Test5().longestPalindrome("ab"));
		StringBuilder a  =new StringBuilder("yangcq");    
		String s = "yangcq";
		int hashcode = 31 * (31 * (31 * (31 * ((31 * (int)'y') + (int)'a') + (int)'n') + (int)'g') + (int)'c') + (int)'q';   
		System.out.println(s.hashCode());
		System.out.println(hashcode);
		System.out.println(a.hashCode());
		a.append("b");
		System.out.println(a.hashCode());
		a.append("AasdfAaAasdfAaAasdfAa");
		System.out.println(a.hashCode());
		//StringBuilder b = new StringBuilder("B");
		//System.out.println(a+","+b);
 		//test(a,b);
 		//System.out.println(a+","+b);
	}
	
	public static  void  test(StringBuilder a , StringBuilder b){
		a.append(b);
		b=a;
		System.out.println(a+","+b);
	}
	
	

	public String longestPalindrome(String s) {
		boolean flag = false;
		if(s.length()<2){
			return s;
		}
		StringBuffer sbf = new StringBuffer(s);
		String reverseStr = new String(sbf.reverse().toString());
		if (s.equals(reverseStr)) {
			return reverseStr;
		}
		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j < i + 1; j++) {
				if (reverseStr.contains(s.substring(j, j + s.length() - i))) {
					reverseStr = new String(s.substring(j, j + s.length() - i));
					flag = true;
					break;

				}
			}
			if (flag) {
				break;
			}
		}
		return longestPalindrome(reverseStr);

	}
	
	private int lo, maxLen;

	public String longestPalindrome2(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
	     	extendPalindrome(s, i, i+1); //assume even length.
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	
}
