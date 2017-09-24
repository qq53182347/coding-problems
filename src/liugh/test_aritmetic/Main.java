package liugh.test_aritmetic;

public class Main {
	public static void main(String[] args) {
		int n=6;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=n-i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(num(i,j)+" ");
			}
			System.out.println();
		}
	}

	private static int num(int x, int y) {
		if(x==y||y==1){
			return 1;
		}
		
		return num(x-1,y-1)+num(x-1,y);
	}
}




