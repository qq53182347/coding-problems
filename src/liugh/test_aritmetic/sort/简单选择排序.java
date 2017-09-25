package liugh.test_aritmetic.sort;

public class 简单选择排序 {
	/*采用最简单的选择方式：从头到尾扫描序列找出最小的记录和第一个记录交换，接着在剩下的记录中继续这种选择和交换，最终使序列有序
	   * 时间复杂度：O（n^2）
	   * 此算法的额外空间只有一个temp，因此空间复杂度为O（1）*/
	public static void main(String[] args) {
        int[] arr={1,3,2,45,65,33,12};
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }        
        //选择排序的优化
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;//k表示最小的元素的坐标；
            for(int j = k + 1; j < arr.length; j++){// 选最小的记录
                if(arr[j] < arr[k]){ 
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            //最小元素和无序序列的第一个元素交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }    
        }
        System.out.println();
        System.out.println("交换后：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}
