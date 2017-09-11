package liugh.test04.创建型模式.工厂方法模式.factory.method;

import liugh.test04.创建型模式.工厂方法模式.factory.simple.Operation;
import liugh.test04.创建型模式.工厂方法模式.factory.simple.OperationAdd;
import liugh.test04.创建型模式.工厂方法模式.factory.simple.OperationDiv;
import liugh.test04.创建型模式.工厂方法模式.factory.simple.OperationMul;
import liugh.test04.创建型模式.工厂方法模式.factory.simple.OperationSub;

/**
 * 工厂接口
 * 
 * @author liu yuning
 *
 */
public interface IFactory {
    public Operation createOperation();
}

class AddFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationAdd();
    }

}

class SubFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationSub();
    }

}

class MulFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationMul();
    }

}

class DivFactory implements IFactory {

    @Override
    public Operation createOperation() {
	return new OperationDiv();
    }

}