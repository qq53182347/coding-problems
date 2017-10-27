package liugh.leetcode;

import java.math.BigDecimal;

/**
 * 两个整数相除，而不使用乘法，除法和mod运算符。 如果是溢出，返回MAX_INT。
 * 
 * @author liuguanghui
 *
 */
public class Test29 {
	
	public static void main(String[] args) {
		System.out.println(divide(28,4));
	}

	//“14➗2”读作“十四除以二”，除号前面的是“被除数”，除号后面的是“除数”
	public static int divide(int dividend, int divisor) { // dividend:被除数 /divisor:除数
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}
		long result = 0;
		long d1 = Math.abs((long) dividend);//14
		long d2 = Math.abs((long) divisor);//2
		while (d1 >= d2) {
			long temp = d2; // 每次被除数减去temp之后，cnt<<1,同时temp<<1。
			long cnt = 1; // 增量
			while (d1 >= temp) {
				// 如果被除数大于等于temp(变换的除数)，result += cnt
				result += cnt;
				d1 -= temp; // 被除数减去除数
				cnt = cnt << 1;
				temp = temp << 1;
			}
		}
		if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
			result = -result;
		}
		if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
			result = 2147483647;
		}
		return (int) result;
	}

}
