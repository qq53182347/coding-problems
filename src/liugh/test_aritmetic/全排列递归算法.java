package liugh.test_aritmetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**


譬如1，2，3，4
第一步：1，2，3，4 因为第一个数只跟自己交换
第二步：1，2，4，3    1，2都提炼出来了，只对3，4排列
第三步：1，3，2，4    数组还原，第二个和下一个交换
第四步：1，3，4，2    思想同第二步
第五步：1，4，3，2    数组还原成1，2，3，4，第二个和第四个交换
第六步：1，4，2，3    思想同第二步
 
下面以2，3，4开头的也就同理了···


 */
public class 全排列递归算法 {
	
	   public static void main(String[] args) {
	        int start = 0;
	        String arrays[] ={"1","2","3","4"};
	       // permulation(arrays, start, arrays.length);
	       // System.out.println(permutation("abc"));;
	        //perm("","abcd");
	        //System.out.println("abcd".substring(1));
	         String s = "123456";
	         String result = "";
	         permutation1(s, result);
	         System.out.println(tList.toString());
	         for (int i = tList.size()-1; i >= 0; i--) {
	        	String string = tList.get(i).toString();
	        	for (int j = 0; j < string.length(); j++) {
					if(j==2 && "4".equals(String.valueOf(string.charAt(2)))){
						tList.remove(i);
					}
				}
	        	if(string.indexOf("35") >0 || string.indexOf("53") >0){
	        		tList.remove(i);
				}
			}
	         System.out.println(tList.toString());
	    }
	   static List<String> tList = new ArrayList<String>();
	   public static void permutation1(String src,String result){
	      if(result.length()==src.length()){            //表示遍历完了一个全排列结果
	         tList.add(result);
	      }else{
	          for(int i=0;i<src.length();i++){
	              if(result.indexOf(src.charAt(i))<0){    //如果result里没有添加过该字符
	                  permutation1(src, result+src.charAt(i));
	              }
	          } 
	      }
	    }
	
	
	//字符串的组合：
	
	
	/*
	 * 给一个字符串，比如ABC， 把所有的组合，即：A, B, C, AB, AC, BC, ABC, 都找出来。
		解题思路：
		假设我们想在长度为n的字符串中求m个字符的组合。我们先从头扫描字符串的第一个字符。
		针对第一个字符，我们有两种选择：一是把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选取m-1个字符；
		二是不把这个字符放到组合中去，接下来我们需要在剩下的n-1个字符中选择m个字符。这两种选择都很容易用递归实现。
	 */
	public static void combiantion(char chs[]){  
	    if(chs.length == 0) return ;  
	      
	    Stack<Character> stack = new Stack<Character>();  
	    for(int i = 1; i <= chs.length; i++){  
	        combine(chs, 0, i, stack);  
	    }  
	}  
	//从字符数组中第begin个字符开始挑选number个字符加入list中  
	public static void combine(char []chs, int begin, int number, Stack<Character> stack){  
	       if(number == 0){  
	        System.out.println(stack.toString());  
	        return ;  
	       }  
	       if(begin == chs.length){  
	        return;  
	       }  
	       stack.push(chs[begin]);  
	       combine(chs, begin + 1, number - 1, stack);  
	       stack.pop();  
	       combine(chs, begin + 1, number, stack);  
	}  
	
	
	
	/*
	 
		 对于一个n 位的字符串来讲，它是n-1位字符串的排列 加上 没有在 n -1 位字符串里 那个字符 的排列。 有点难理解，用例子说明：
		对于字符串ABC来讲，它所有的排列就是 A + BC 的排列 加上 B + AC 的排列，再加上 C + AB的排列。
		而BC的排列是 B + C 的排列 加上 C + B 的排列。
		所以，对一个字符串，我们从中去一个值，然后求剩余部分的排列，然后把它们再组合在一起。所有，代码如下：
	
	 */
	 public static LinkedList<String> permutation(String str) {  
	        LinkedList<String> linkedString = new LinkedList<String>();   
	        if (str.length() <= 1) {  
	            linkedString.add(str);  
	            return linkedString;  
	        }   
	        for (int i = 0; i < str.length() ; i++) {  
	            char ch = str.charAt(i);  
	            //consider the case in which the characters may be duplicated.  
	            if (i > 0 && ch == str.charAt(i - 1)) {  
	                continue;  
	            }  
	            String newStr = remove(str, i);  
	            LinkedList<String> newStrList= permutation(newStr);   
	            for (int j = 0; j < newStrList.size(); j++) {  
	                linkedString.add(ch + newStrList.get(j));  
	            }  
	        }  
	        return linkedString;  
	    }  
	    //remove the ith character from the string  
	    public static String remove(String str, int i) {  
	        if (i == 0) return str.substring(1, str.length());  
	        if (i == str.length() - 1) return str.substring(0, i );  
	        return str.substring(0, i) + str.substring(i + 1, str.length());  
	    }  
	
	
	//这种递归的思路是：分别求第i个数据排在第一位的时，其它n-1个数据的全排列。
	//求n-1个数据的全排列与求n个数据的全排列求法相同。当只有一个数据时，是递归的出口
	   public static void permulation(String[] arrays, int start, int end) {//start和end游标控制你要进行递归的位置
	        if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可 相当于start和end都指向最后一个位置了
	            for (int i = 0; i < end; i++)
	            	System.out.print(arrays[i] + " ");
	            System.out.println();
	        } else {// 多个字母全排列
	            for (int i = start; i < end; i++) {
	                swap(arrays, start, i);// 交换数组第一个元素与后续的元素 1 234
	                permulation(arrays, start + 1, end);// 后续元素递归全排列   234全排列
	                swap(arrays, start, i);// 将交换后的数组还原
	            }
	        }
	    }

	    public static void swap(String[] arrays, int start, int i) {
	        String temp = arrays[start];
	        arrays[start] = arrays[i];
	        arrays[i] = temp;
	    }

}
/**
 * 题目一：输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 解题思路：
	1.把字符串分成两部分，一部分是字符串的第一个字符，另一部分是第一个字符以后的所有字符。递归求另一部分字符的排列。 
	2.拿第一个字符和它后面的字符逐个交换。注：交换完还要换回去
 *
 */
class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str == null || str.length() <= 0)
            return res;
        HashSet<String> set = new HashSet<String>(); //结果去重
        dfs(set, str.toCharArray(), 0);
        res.addAll(set);
        Collections.sort(res);
        return res;
    }

    public void dfs(HashSet<String> set, char [] str, int k){
        if(k == str.length){  //得到结果
            set.add(new String(str));
            return ;
        }
        for(int i = 0; i < str.length; i ++){
            swap(i, k, str);
            dfs(set, str, k + 1);
            swap(i, k, str);  //回溯
        }
    }

    public void swap(int i, int j, char [] str){
        if(i != j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp; 
        }
    }
}