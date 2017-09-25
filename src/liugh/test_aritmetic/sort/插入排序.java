package liugh.test_aritmetic.sort;

import java.util.Arrays;

public class 插入排序 {
	public static void insertionSort(int[] a) {
        int tmp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }else{
                	break;//如果不加break的话，就会存在1角标和0角标比较，
                	      //而这个比较是毫无意义的，因为2角标已经比1角标大了
                }
            }
        }
    }
 
    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
