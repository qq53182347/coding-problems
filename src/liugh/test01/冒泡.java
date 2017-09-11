package liugh.test01;

public class 冒泡 {
	public static void main(String[] args) {
		int[] tmp = {10,50,4,6,5,35};
		int t = 0;
		int sum = 0;
		for (int i = 1; i <= tmp.length; i++) {
			for (int j = 1; j <= tmp.length-i; j++) {
				sum++;
				if(tmp[j-1]>tmp[j]){
					t++;
					int temp = tmp[j-1];
					tmp[j-1]=tmp[j];
					tmp[j]=temp;
				}
			}
		}
		for (int i = 0; i < tmp.length; i++) {
			System.out.print(tmp[i]+" ");
		}
		System.out.println();
		System.out.println(t);
		System.out.println(sum);
	}
}
