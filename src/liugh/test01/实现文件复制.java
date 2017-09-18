package liugh.test01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 实现文件复制 {
	public static void main(String[] args)throws IOException{
		 copy(System.getProperties()+"/src/liugh/test01/Main.java","D:/test.java");
	}
	
	public static void copy(String src,String desk)throws IOException{
		FileReader ips = new FileReader(new File(src));
		FileWriter ops = new FileWriter(new File(desk));
		char[] ch =new char[1024];
		int len = 0;
		while((len = ips.read(ch))!=-1){
		   ops.write(ch, 0, len);
		}
		ips.close();
		ops.close();
	}

}
