package liugh.test_JavaDesignMode.结构型模式.适配器模式.adapter;

/**
 * 客户所期待的接口
 * 
 * @author liu yuning
 *
 */
public abstract class Target {
    public void request() {
	System.out.println("普通请求！");
    }
}
