package liugh.test04.结构型模式.适配器模式.adapter;

/**
 * 适配器客户端
 * 
 * @author liu yuning
 *
 */
public class AdapterClient {

    public static void main(String[] args) {
	Target target;

	target = new Adapter();
	target.request();
    }
}
