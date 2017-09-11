package liugh.test04.结构型模式.装饰模式.decorator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class DecorateDemo {

	/**
	 * 需求：使用BufferedReader读取一个文件内容,并给每行加上序号
	 */
	public static void main(String[] args) throws Exception {
		//oldMethod();
		
		BufferedReader b = new BufferedReader(new FileReader("/news.txt"));
		//对BufferedReader进行装饰
		BufferedReader br = new MyBufferedReader(b);
		String str = null;
		
		while( (str = br.readLine())!=null){
			System.out.println(str);
		}
	}

	private static void oldMethod() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("/news.txt"));
		String str = null;
		while( (str = br.readLine())!=null){
			System.out.println(str);
		}
	}
	
	
	/**
	 * 改造： 在每行名字前面加上一个序号。
	 * 解决方案： 希望readLine方法返回给我们的就是一个带序号的内容。对BufferedReader的readLine方法进行增强。这是就可以用到装饰者模式。
	 * 	  装饰者模式的开发步骤：
	 * 		  概念： 装饰者  和 被装饰者  .   BufferedReader就是被装饰者
	 * 			1)编写一个BufferedReader装饰者类，继承被装饰者类。(不能是final的)
	 *          2）在装饰类中定义一个成员变量，用于接收被装饰者类的对象。
	 *          3）在装饰者类的构造方法中传入被装饰者类，使用第二步定义的变量接收被转入的 被装饰者类。	
	 * 			4）在装饰类类中重写被装饰者类方法，对其方法进行增强。
	 */
}

//1)编写一个BufferedReader装饰者类，继承被装饰者类。(不能是final的)  BufferedReader(是非final的)
class MyBufferedReader extends BufferedReader{
	/**
	 * 因为父类没有无参的构造方法,子类有默认无参构造,会在默认的无参构造里的第一行隐士调用super(),会报错
	 * public MyBufferedReader(){
		super();
	}*/
	//2）在装饰类中定义一个成员变量，用于接收被装饰者类的对象。
	private BufferedReader br;
	//3）在装饰者类的构造方法中传入被装饰者类，使用第二步定义的变量接收被转入的 被装饰者类。
	public MyBufferedReader(Reader in) {
		//super();报错
		super(in);
		this.br = (BufferedReader) in;
	}
	int count = 1;
	//4）在装饰类类中重写被装饰者类方法，对其方法进行增强。
	@Override
	public String readLine() throws IOException {
		//得到原来的真实的内容
		String content = br.readLine();
		//加强: 加上序号
		if(content!=null){
			content = count+":"+content;
			count++;
		}
		return content;
	}
}
