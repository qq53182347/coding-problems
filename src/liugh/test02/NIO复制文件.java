package liugh.test02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO复制文件 {
	public static void main(String[] args) throws IOException {
		nioCopyFile("D:\\dubbo.xsd","C:\\dubbo.txt");
	}
	public static void nioCopyFile(String resource, String destination)
			throws IOException {
		FileInputStream fis = new FileInputStream(resource);
		FileOutputStream fos = new FileOutputStream(resource);
		FileChannel channelfis = fis.getChannel();
		FileChannel channelfos = fos.getChannel();
		ByteBuffer bb =ByteBuffer.allocate(1024);
		while(true){
			bb.clear();
			int read = channelfis.read(bb);
			if(read==-1){
				break;
			}
			bb.flip();
			channelfos.write(bb);
		}
		channelfis.close();
		channelfos.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void nioCopyFile1(String resource, String destination)
			throws IOException {
		FileInputStream fis = new FileInputStream(resource);
		FileOutputStream fos = new FileOutputStream(destination);
		FileChannel readChannel = fis.getChannel(); // 读文件通道
		FileChannel writeChannel = fos.getChannel(); // 写文件通道
		ByteBuffer buffer = ByteBuffer.allocate(1024); // 读入数据缓存
		while (true) {
			buffer.clear();
			int len = readChannel.read(buffer); // 读入数据
			if (len == -1) {
				break; // 读取完毕
			}
			buffer.flip();
			writeChannel.write(buffer); // 写入文件
		}
		readChannel.close();
		writeChannel.close();
	}
}
