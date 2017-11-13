package liugh.test_JavaDesignMode.创建型模式.工厂方法模式.factory.abstraction;

import liugh.test_JavaDesignMode.创建型模式.工厂方法模式.factory.simple.Operation;

/**
 * 客户端
 *
 */
public class Client {
    public static void main(String[] args) throws InstantiationException,
	    IllegalAccessException {
	Operation operation = OperationFactory.createOperation("+");

	operation.numberA = 7;
	operation.numberB = 8;

	System.out.println(operation.result());
    }
}
