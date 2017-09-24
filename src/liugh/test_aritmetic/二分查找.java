package liugh.test_aritmetic;

public class 二分查找 {
	public static void main(String[] args) {
		int [] arr={1,2,5,6,8,9,12,64,78,90};
		System.out.println(test(arr,0,arr.length-1,8));
	}
	//递归方式实现
	public static int recursion(int [] arr,int low,int high,int value){
		if(low>high){
			return -1;
		}
		int mid=(low+high)/2;
		if(value==arr[mid]){
			return mid;
		}else if(value<arr[mid]){
			return recursion(arr,low,mid-1,value);
		}else{
			return recursion(arr,mid+1,high,value);
		}
	}
	//迭代方式实现
	public static int test(int [] arr,int low,int high,int value){
		int mid;
		while(high>=low){
			mid=(low+high)/2;
			if(value<arr[mid]){
				high=mid-1;
			}else if(value>arr[mid]){
				low=mid+1;
			}else{
				return mid;
			}
		}
		return -1;
	}
}
