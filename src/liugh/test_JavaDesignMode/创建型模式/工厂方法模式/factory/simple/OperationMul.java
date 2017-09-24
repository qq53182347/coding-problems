package liugh.test_JavaDesignMode.创建型模式.工厂方法模式.factory.simple;

/**
 * 乘法类
 * 
 * @author liu yuning
 *
 */
public class OperationMul extends Operation {

    @Override
    public double result() {
	return numberA * numberB;
    }

}