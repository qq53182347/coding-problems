
package liugh.test01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 验证邮箱合法性
 */
public class 邮箱合法性 {
	public static void main(String[] args) {
		String str = "53182347@qq.com";
		String pat="[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9]+(\\.(com))";
		Pattern p = Pattern.compile(pat);
		Matcher m =p.matcher(str);
		if(m.matches()){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}
}