package liugh.test02;

public class 背包问题 {
	
	public static void main(String[] args) {
		int [] tt = {2,3,5,7};
		System.out.println(backPack(12,tt));
	}
	
	public static int backPack(int m, int[] A) {
      boolean f[][] = new boolean[A.length + 1][m + 1];
      for (int i = 0; i <= A.length; i++) {
          for (int j = 0; j <= m; j++) {
              f[i][j] = false;
          }
      }
      f[0][0] = true;
      for (int i = 1; i <= A.length; i++) {
          for (int j = 0; j <= m; j++) {
              f[i][j] = f[i - 1][j];
              if (j >= A[i-1] && f[i-1][j - A[i-1]]) {
                  f[i][j] = true;
              }
          } // for j
      } // for i
      
      for (int i = m; i >= 0; i--) {
          if (f[A.length][i]) {
              return i;
          }
      }
      
      return 0;

  }

}
