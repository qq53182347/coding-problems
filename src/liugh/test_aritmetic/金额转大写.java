package liugh.test_aritmetic;
import java.util.HashMap;

/*
 * 金额转换为大写
 */
public class 金额转大写 {
	static HashMap<String,String> tmap = new HashMap<String,String>();
	static String [] ss = {"","十","百","千","万","十","百","亿"};
	static{
			tmap.put("0", "零");
			tmap.put("1", "一");
			tmap.put("2", "二");
			tmap.put("3", "三");
			tmap.put("4", "四");
			tmap.put("5", "五");
			tmap.put("6", "六");
			tmap.put("7", "七");
			tmap.put("8", "八");
			tmap.put("9", "九");
	}
	public static void main(String[] args) {
		int t = 324324;
		String str = String.valueOf(t);
		StringBuffer  sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			char charAt = str.charAt(i);
			System.out.print(charAt);
			sb.append(tmap.get(String.valueOf(charAt)));
		}
		//System.out.println(sb.toString());//三二四三二四
		int tt =0;
		for(int j =sb.length();j>0;j--){
			sb.insert(j, ss[tt++]);
		}
		System.out.println("  "+sb.toString());
	}

}

