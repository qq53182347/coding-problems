package liugh.test01;

import java.util.Arrays;
import java.util.Comparator;

public class 传入数组找出组成最大的数 {
	public static String getLargestNumByArranged(Integer[] array) {
	    Arrays.sort(array, new Comparator<Object>() {
	        /***
	         * 默认是从小到大排序 if the result > 0 then swap
	         */
	        public int compare(Object o1, Object o2) {
	            String left = o1.toString();
	            String right = o2.toString();
	            // 按字典顺序比较 if the result > 0 then * -1
	            return (left + right).compareTo(right + left) * -1;
	            // return (right + left).compareTo(left + right);
	        }

	    });

	    StringBuffer sb = new StringBuffer();
	    for (Integer integer : array) {
	        sb.append(integer.toString());
	    }

	    return sb.toString();
	}

	public static void main(String[] args) {
	    Integer[] VALUES = { 50, 2, 100, 99, 5, 7, 51, 50, 11 };
	    System.out.println(getLargestNumByArranged(VALUES));
	}

}
