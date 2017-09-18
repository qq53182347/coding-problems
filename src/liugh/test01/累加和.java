package liugh.test01;

public class 累加和 {
	public static void main(String[] args) {
		//System.out.println(test(6));
		int i = 1 - 2 + 3 - 4 + 5 - 6;
		System.out.println(getResult(6));
	}
	public static int getResult(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if(i%2==0){
				result -= i;
			}else{
				result += i;
			}
		}
		return result;
	}
	public static int test(int n) {
		int k = 1, sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i * k;
			k = k * (-1);
		}
		return sum;
	}

	
}
