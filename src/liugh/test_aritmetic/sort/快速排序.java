package liugh.test_aritmetic.sort;

import java.util.Arrays;

public class 快速排序 {
	public static void main(String[] args) {
		int[] arr={1,3,2,45,65,33,12};
		sort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }
    
    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi); 
    }

}
