package liugh.test_aritmetic;

public class 递归逆序排列字符单词{

	 public static void main(String[] args) {
		 String str = "I love java";
		 int i = str.indexOf(" ");//5
		 System.out.println(str.substring(i+1));//world my friend and now
		 System.out.println(reverse1(str));
	}
	 
	 
	 static String reverse1(String str){
		 int i = str.indexOf(" ");
		 if(str == null||i==-1){
			 return str;
		 }
		return reverse1(str.substring(i+1))+ " " + str.substring(0, i); 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 static String reverse(String s) {
		int i = s.indexOf(" ");//搜索第一次出现" "的位置
	    if (s == null||i == -1) {
	      return s;
	    }
	    return reverse(s.substring(i + 1)) + " " + s.substring(0, i);
	}
}
