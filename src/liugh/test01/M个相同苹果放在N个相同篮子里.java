package liugh.test01;

import java.util.Scanner;

public class M个相同苹果放在N个相同篮子里 {
	public static void main(String[] args) {  
		//m个相同的苹果，放在n个相同的盘子中，求有多少种结果,5，1，1和1，5，1 是同一种分法。

		/*
		7 3
		输出例子
		8
		解题思路：
		将这8组数分成2组
		第一组，可以发现最后一个数总是为0，其实可以理解成这一组数与m = 7,n = 2也是相等的
		7   0   0
		6   1   0
		5   2   0
		4   3   0

		第二组，如果将每一个数都减1,可以发现，这组数的个数与m = 4,n = 3相等
		5   1   1
		4   2   1
		3   3   1
		3   2   1*/
		
		
		/*
		①最少的盘子放了一个，这样每个盘子至少一个，n个盘子先放上n个，剩下的m-n个可以随便放  
		②最少的盘子没有放，这样剩下的n-1个盘子还是随便放m个
         */
		  
        Scanner in = new Scanner(System.in);  
        int N, M; // M Apple, N Disk  
        M = in.nextInt();  
        N = in.nextInt();  
        System.out.print("共有"+cal(M, N)+"种结果");  
    }  
  
    private static int cal(int m, int n) {  
        if (m < 0)  
            return 0;  
        if (m == 0 || n == 1)  
            return 1;  
        return cal(m - n, n) + cal(m, n - 1);  
  
    }  
    //decompose1(m,n-1)代表至少有一个盘子空着          decompose1(m-n,n)代表所有盘子都有苹果，相当于可以从每个盘子中拿掉一个苹果
}
