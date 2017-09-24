package liugh.test_JavaDesignMode.结构型模式.代理设计模式.proxy;

/**
 * 代理客户端
 * 
 * @author liu yuning
 *
 */
public class ProxyClient {
    public static void main(String[] args) {
	Proxy proxy = new Proxy();
	proxy.request();
    }
}
