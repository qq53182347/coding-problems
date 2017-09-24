package liugh.test_aritmetic;

import java.io.UnsupportedEncodingException;

public class 按字节截取字符串_汉字跳过 {
	
//	public static void main(String[] args) {
//		String srcStr1 = "我ABC";
//		String srcStr2 = "我ABC汉DEF";
//
//		splitString(srcStr1, 4);
//		splitString(srcStr2, 6);
//	}

	public static String split(String str,int len) {
		String result="";
		char temp;
		//取得的字节数
		int  count = 0;
		int i =0;
		//汉字的个数
		int  han=0;
		while(count <len){
			temp=str.charAt(i);
			if(Character.getNumericValue(temp)==-1){//Character.getNumericValue(temp)，作为unicode字符，返回值遇到汉字则是-1
				result+=temp;
				count+=2;
				i++;
				han++;
			}else{
				//遇到字母
				result+=temp;
				count ++;
				i++;
			}
		}
		if(count>len){
			if(len==1){
				result="";
			}else{
				result=result.substring(0,count-han-1);
			}
		}
		return result;
		
	}
	
	
	//注意：获取字符串的bytes，bytes数组中汉字的byte值为负数，这是判断汉字的一个依据 
	public static  String subString(String str,int len){   
        if(str == null && "".equals(str)){   
            return null;   
        }   
        //将字符串中的char数组转换成指定编码方式的byte数组的函数   
        byte[] strBytes = null;   
        try {   
            strBytes = str.getBytes("UTF-8"); 
        } catch (UnsupportedEncodingException e) {   
            e.printStackTrace();   
        }   
        //得到字符串的长度，判断截取字符串的长度是否在判断的范围内，否则返回原串   
        int strLen = strBytes.length;   
        if(len >= strLen || len < 1){   
            return str;   
        }   
        int count = 0; //统计汉字的个数  
        for(int i=0; i<len; i++){   
            //将每个字节数组转换为整型数，因为后面根据值的正负来判断是否为汉字   
            int value = strBytes[i];   
            //如果是汉字(负)，则统计截取字符串中的汉字所占字节数   
            if(value < 0){      
                count++;   
            }   
        }   
        //依据判断给定的字符串是否含有汉字，利用String类的substring()方法来截取不同的长度   
           
       //根据所统计的字节数，判断截取到字符是否为半个汉字，奇数为半个汉字   
        if(count % 2 !=0){   
            //如果在截取长度为1时，则将该汉字取出，   
            //其他情况则不截取这里的截取长度则按字符长度截取（截取字节长度数-截取汉字字节数/2-截取到的半个汉字的字节数）   
            len = (len == 1)?len:len-count/2-1;   
        }else{   
            //截取字符长度为字节长度-汉字所占字节长度/2（汉字占两个字节）   
            len = len-(count/2);   
        }   
            return str.substring(0,len);   
    }   
	 public static void main(String[] args) {
	  String str = split("我ABC", 4);
	  System.out.println(str);
	  String str2 = subString("我ABC走DEF", 7);
	  System.out.println(str2);
	}
}
