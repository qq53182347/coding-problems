package liugh.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Test3 {
	
	public static void main(String[] args) {
//		System.out.println(lengthOfLongestSubstring("pwwkew"));
		String s = "pwwkew";
		int n = s.length();
        Set<Character> tempSet = new HashSet<>();
        int count = 0, i = 0, j = 0;
        while (i < n && j < n) {//在i和j范围内
            if (!tempSet.contains(s.charAt(j))){
                tempSet.add(s.charAt(j++));
                count =count>j-i?count:j-i;
            }
            else {
                tempSet.remove(s.charAt(i++));
            }
        }
        System.out.println(count);
//        return count;
	}
	
//	public static int lengthOfLongestSubstring(String s) {
//		 	
//    }

}
