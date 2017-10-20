package liugh.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test4 {
	
	 public static void main(String[] args) {
	        int[] a = { 1, 2, 8, 19 };
	        int[] b = { 2, 3, 9, 12, 25 };
//	        double c = merge(a, b);
//	        System.out.println(c);
//	        int[] mergeArray = mergeArray1(a,b);
//	        for (int i = 0; i < mergeArray.length; i++) {
//				System.out.print(mergeArray[i]+" ");
//			}
	        long startTime=System.nanoTime();   //获取开始时间  
	         mergeArray1(a,b);
	        long endTime=System.nanoTime(); //获取结束时间  
	        System.out.println("程序运行时间： "+(endTime-startTime)+"ns"); 
	    }
	 
	 public  static double  merge( int[] nums1,int[] nums2){
		 int length =nums1.length + nums2.length;
//		 int[] c = new int[length];
//	     System.arraycopy(nums1, 0, c, 0, nums1.length);  
//	     System.arraycopy(nums2, 0, c, nums1.length, nums2.length);
//		 Arrays.sort(c);
		 int[] c = mergeArray1(nums1,nums2);
		 double m =c[length/2];
		 if(length%2==0){
			double n =c[length/2-1];
			return (m+n)/2;
		 }else{
			 return m;
		 }
	 }
	 public static int[] mergeArray1(int[] a, int[] b) {
	        int[] result = new int[a.length + b.length];
	        int i=0, j=0, k=0;
	        while (i < a.length && j < b.length) {
	            if (a[i] < b[j]) {
	                result[k++] = a[i];
	                i++;
	            } else {
	                result[k++] = b[j];
	                j++;
	            }
	        }
	        while (i < a.length) { // a有剩余
	            result[k++] = a[i];
	            i++;
	        }
	        while (j < b.length) { // b有剩余
	            result[k++] = b[j];
	            j++;
	        }
	        return result;
	    }
	 
	 
	 public static int[] mergeArray2(int[] nums1, int[] nums2) {
		 int length =nums1.length + nums2.length;
		 int[] c = new int[length];
	     System.arraycopy(nums1, 0, c, 0, nums1.length);  
	     System.arraycopy(nums2, 0, c, nums1.length, nums2.length);
		 Arrays.sort(c);
		 return c;
	    }

}
