package liugh.test_JavaDesignMode.创建型模式.建造者模式.builder;

/**
 * 具体建造者类
 * 
 * @author liu yuning
 *
 */
public class ConcreteBuilder1 extends Builder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
	product.add("部件A");
    }

    @Override
    public void buildPartB() {
	product.add("部件B");
    }

    @Override
    public Product getBuildResult() {
	return product;
    }

}
