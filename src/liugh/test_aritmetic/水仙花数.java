package liugh.test_aritmetic;
/*
 * 打印1000以内水仙花数
 * 因为153=1的三次方＋5的三次方＋3的三次方。
 */
public class 水仙花数 {
	public static void main(String[] args) {
//		int hundred,ten,bits;
//		for (int i = 0; i < 1000; i++) {
//			  hundred = i / 100; //百位   
//            ten = i % 100 / 10;//十位
//            bits = i % 10;    //个位
//            if (i == hundred * hundred * hundred + ten * ten * ten + bits * bits * bits)    
//            {    
//                System.out.print(i + "    ");    
//            }  
//		}
		String str = "hello85";
		System.out.println(test1(str));
	}
	public static int test1(String str){
		if(null==str||str.equals("")){
			return 0;
		}
		String[] split = str.split("");
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i <= split.length-2; i++)
		{ 
		    sb. append(split[i]);
		}
		return test1(sb.toString())+1;
		
	}
}
