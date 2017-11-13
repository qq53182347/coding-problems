package liugh.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
	 给定一个整数数组，返回两个数字的索引，使它们加起来成为一个特定的目标。
	
	您可能会认为每个输入都只有一个解决方案，而且您可能不会使用相同的元素两次。
	
	例：
	给定nums = [2,7,11,15]，目标= 9，
	
	由于nums [ 0 ] + nums [ 1 ] = 2 + 7 = 9，
	返回[ 0，1 ]。
*/
public class Test1 {
	
	public static void main(String [] args){
		int[] nums = {2,7,11,15};
		int[] twoSum = twoSum1(nums,18);
		for (int i = 0; i < twoSum.length; i++) {
			System.out.println(twoSum[i]);
		}
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	public static  int[] twoSum2(int[] nums, int target) {
		int[] indices = new int[2];
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if( nums[i]+nums[j]==target ) {
					indices[0] = i;
					indices[1] = j;
					return indices;
				}
			}
		}
        return indices;
	}
	
	
	
	public static  int[] twoSum1(int[] nums, int target) {
		 int[] result = new int[2];
		    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		    for (int i = 0; i < nums.length; i++) {
		        if (map.containsKey(target - nums[i])) {
		            result[1] = i ;
		            result[0] = map.get(target - nums[i])-1;
		            return result;
		        }
		        map.put(nums[i], i + 1);
		    }
		    return result;
	}
	
}
