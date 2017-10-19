package liugh.leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/*给定一个n整数的数组，你的任务是检查它是否可以通过修改最多的 1元素而变得不减少。

我们定义一个数组是非递减的，如果array[i] <= array[i + 1]保持为每个i（1 <= i <n）。

	示例1：
	输入： [4,2,3]
	 输出：true
	 解释：你可以修改第一个
	4
	以
	1
	得到一个非递减排列。
	示例2：
	输入： [4,2,1]
	 输出： False
	 说明：最多只能修改一个元素，不能得到非递减数组。
	注： 该n属于[1 10000]。
*/
public class Test665 {
	
	
	public static void main(String[] args) {
		int [] test = {4,3,5,1};
		System.out.println(checkPossibility(test));
	}

	public  static boolean checkPossibility(int[] nums) {
        int length = nums.length;
        int tag = 0;
        int before = 0;
        int after = 0;
        boolean flag = true;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                tag += 1;
                before = nums[i];
                after = nums[i + 1];
                nums[i] = after;
                boolean be = check(nums);
                nums[i] = before;
                nums[i + 1] = before;
                boolean af = check(nums);
                if (!be && !af) {
                    flag = false;
                }
                nums[i] = before;
                nums[i+1] =after;
                if (tag > 1)
                    return false;
            }
        }
        return flag;
    }

    public static  boolean check(int arr[]){
        for (int i = 0;i <arr.length-1 ;i++){
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
    
    public static  boolean checkPossibility2(int[] nums) {
 	   for (int i = 0; i < nums.length -2; i++) {
 		 if (nums[i] > nums[i+1]) {
              if (nums[i] <= nums[i+2]) {
                 nums[i+1] = nums[i];
              }else {
                 nums[i] = nums[i+1];
              }
 			 for (int j = 0; j < nums.length -1; j++) {
 				 if (nums[j] > nums[j+1]) {
 					 return false;
 				 }
 			 }
 		 }
 	   }
       return true;
    }
}
