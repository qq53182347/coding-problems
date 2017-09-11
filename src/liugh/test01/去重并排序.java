package liugh.test01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 声明一个数组
 * 数组中有重复的元素
 * 而且元素是杂乱无章的
 * 要求把重复的元素排除掉并将新得到的数组进行递增排序
 * @author 冯剑
 *
 */
public class 去重并排序 {

		/*
		 * ifRepeat方法是排除数组内重复的元素
		 */
	public static int[] ifRepeat(int[] arr){
	  //用来记录去除重复之后的数组长度和给临时数组作为下标索引
	  int t = 0;
	  //临时数组
	  int[] tempArr = new int[arr.length];
	  //遍历原数组
	  for(int i = 0; i < arr.length; i++){
	      //声明一个标记，并每次重置
	      boolean isTrue = true;
	      //内层循环将原数组的元素逐个对比
	      for(int j=i+1;j<arr.length;j++){
	          //如果发现有重复元素，改变标记状态并结束当次内层循环
	          if(arr[i]==arr[j]){
	              isTrue = false;
	              break;
	          }
	      }
	      //判断标记是否被改变，如果没被改变就是没有重复元素
	      if(isTrue){
	          //没有元素就将原数组的元素赋给临时数组
	          tempArr[t] = arr[i];
	          //走到这里证明当前元素没有重复，那么记录自增
	          t++;
	      }
	  }
	  //声明需要返回的数组，这个才是去重后的数组
	  int[]  newArr = new int[t];
	  //用arraycopy方法将刚才去重的数组拷贝到新数组并返回
	  System.arraycopy(tempArr,0,newArr,0,t);
	  return newArr;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,1112,1,1,2,3,4,6,4,5};
		Set t = new HashSet(Arrays.asList(arr));
		Object[] array = t.toArray();
		for (int i = 0; i <array.length; i++) {
			System.out.print(array[i].toString()+" ");
		}
		
		System.out.println("-----------");
		//声明一个新数组用来存储无重复的原数组
		int[] newArr = ifRepeat(arr);
			//把新数组进行排序
		  for (int i = 0; i < newArr.length; i++) {
			for (int j = i + 1; j < newArr.length; j++) {
				if (newArr[j] < newArr[i]) {
					int n = newArr[i];
					newArr[i] = newArr[j];
					newArr[j] = n;
				} 
			}
		}
		  
		  for (int i = 0; i < newArr.length; i++) {
			  System.out.print(newArr[i]+",");
		  }
	}
	
}
