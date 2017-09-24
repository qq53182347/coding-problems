package liugh.test_aritmetic;

import java.util.ArrayList;

public class 找出1_100没有放入数组的两个数 {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		ArrayList<Integer> tempArray = new ArrayList<Integer>();
		Integer[] num = new Integer[98];
		for(int i = 1; i <= 100; i++){
			array.add(new Integer(i));
		}
		int i = 0;
		while(true){
			int position = (int)(100*Math.random());
			if(!tempArray.contains(position)){
				tempArray.add(position);
				num[i] = array.get(position);
				i++;
				if(i == 98){
					break;
				}
			}
		}
		for(int j = 0; j < 98; j++){
			System.out.print(num[j]+" ");
			array.remove(new Integer(num[j]));
		}
		System.out.println();
		System.out.println(array.toString());
	}
}
