package liugh.test04.创建型模式.工厂方法模式.factory.abstraction;

import java.util.HashMap;
import java.util.Map;

import liugh.test04.创建型模式.工厂方法模式.factory.simple.Operation;
import liugh.test04.创建型模式.工厂方法模式.factory.simple.OperationAdd;
import liugh.test04.创建型模式.工厂方法模式.factory.simple.OperationDiv;
import liugh.test04.创建型模式.工厂方法模式.factory.simple.OperationMul;
import liugh.test04.创建型模式.工厂方法模式.factory.simple.OperationSub;

/**
 * 利用反射改造简单工厂模式，去掉分支判断的逻辑
 * 
 * @author liu yuning
 *
 */
public class OperationFactory {
    private static Map<String, Class<?>> allOperationMaps = new HashMap<String, Class<?>>();

    public static void fillMap() {
	allOperationMaps.put("+", OperationAdd.class);
	allOperationMaps.put("-", OperationSub.class);
	allOperationMaps.put("*", OperationMul.class);
	allOperationMaps.put("/", OperationDiv.class);
    }

    public static Operation createOperation(String operator)
	    throws InstantiationException, IllegalAccessException {
	Operation operation;

	fillMap();
	Class<?> operationClass = allOperationMaps.get(operator);

	if (operationClass == null) {
	    throw new RuntimeException("unsupported operation");
	}

	operation = (Operation) operationClass.newInstance();

	return operation;
    }

}
