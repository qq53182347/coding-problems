package liugh.test_aritmetic;

import java.util.Arrays;

public class 删除数组中重复的元素 {
	public static void main(String[] args) {   
        int[] a = {1, 1, 2, 2, 3};   
        a = removeDuplicates(a);   
        System.out.println(Arrays.toString(a));   
   }

	private static int[] removeDuplicates(int[] a) {
		if(a.length<=1){
			return a;
		}
		int index=0;
		for (int i = 0; i < a.length; i++) {
			if(a[index]!=a[i]){
				a[++index]=a[i];
			}
		}
		System.out.println(Arrays.toString(a));   
		int[] b = new int[index+1];
		System.arraycopy(a, 0, b, 0, b.length);
		return b;
	}  
}
