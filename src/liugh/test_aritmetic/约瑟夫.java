package liugh.test_aritmetic;

import java.util.ArrayList;
import java.util.List;

public class 约瑟夫 {

	public static void main(String[] args) {
		List alist = new ArrayList();  
        int N = 41;  
        System.out.println("按出圈的次序输出序号：");  
        for(int i=1 ;i<=N;i++){  
            alist.add(i);  
        } 
        yuesf2(alist,3);
	}
	
	public static void  yuesf2(List alist,int m){
		int i =0;
		while(alist.size()>0){
			i++;
			if(i%m!=0){
				alist.add(alist.remove(0));
			}else{
				System.out.println("自杀的人是:" +alist.get(0));
				alist.remove(0);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void yuesf(List list,int m){
	    int i = 0;
	    while (list.size()>0){
	        i++;
	        if(i%m!=0){
	            list.add(list.remove(0));
	        }else{
	            System.out.println("自杀的人是" + list.get(0));
	            list.remove(0);
	        }

	    }
	}
}
