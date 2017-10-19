package liugh.test_aritmetic;
import java.util.HashMap;

/*
 * 金额转换为大写
 */
public class 金额转大写 {
	static String [] ss = {"","十","百","千","万","十","百","千","亿"};
	static String [] num ={"零","一","二","三","四","五","六","七","八","九"};
	/*
	 * 金额转换为大写
	 */
	public static void main(String[] args) {
		int t = 32430044;
		String str = String.valueOf(t);
		StringBuffer  sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			String charAt = String.valueOf(str.charAt(i));
			sb.append(num[Integer.parseInt(charAt)]);
		}
		
		//设置一个计数,如果存在一个
		int tt =0;
		for(int j =sb.length();j>0;j--){
			sb.insert(j, ss[tt++]);
		}
		System.out.println("  "+sb.toString());
	}

}

