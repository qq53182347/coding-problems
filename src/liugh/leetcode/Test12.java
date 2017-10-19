package liugh.leetcode;

import java.util.HashMap;

/**
 * 给定一个整数，将其转换为罗马数字。
	输入保证在1到3999之间。
 * @author liuguanghui
 *
 */
public class Test12 {
	
/*	罗马数字转换成整数：

	首先要来了解一下罗马数字表示法，基本字符有7个：I，V，X，L，C，D，M，分别表示1，5，10，50，100，500，1000。

	在构成数字的时候，有下列规则：

	1、相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；

	2、小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；

	3、小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；

	4、正常使用时，连写的数字重复不得超过三次。
*/
	public static void main(String[] args) {
		  int num = 51;
		  //除10求余,规律是从各位开始
		  int thousand = num / 1000;
		  int hundred =num % 1000 / 100;
		  int ten =num % 100 / 10;
		  int digit = num % 10;
//		  System.out.println(digit);
		System.out.println(intToRoman(663));
	}
	
	  public static String intToRoman(int num) {
		    String digit[] = {"", "I", "II", "III", "IV", "V", "VI", "VII",  
	                "VIII", "IX"};  
	        String ten[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX",  
	                "XC"};  
	        String hundred[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC",  
	                "DCCC", "CM"};  
	        String thousand[] = {"", "M", "MM", "MMM"}; 
	        StringBuilder roman = new StringBuilder();
	        roman.append(thousand[num / 1000]).append(hundred[num % 1000 / 100])
	        		.append(ten[num % 100 / 10]).append(digit[num % 10]);
	        return roman.toString() ; 
	  }
	  
}
