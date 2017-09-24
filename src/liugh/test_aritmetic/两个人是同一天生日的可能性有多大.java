package liugh.test_aritmetic;

public class 两个人是同一天生日的可能性有多大 {
	//50个人在一个房间，那么有两个人是同一天生日的可能性有多大？
		public static void main(String[] args) {
			double x=1;
			for (int i = 1; i <= 50; i++) {
				x*=(365.0-i)/365.0;
			}
			double round = Math.round((1-x)*100);
			System.out.println(round/100);
		}
}
