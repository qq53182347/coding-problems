package customAnnotation.策略模式;


//抽象策略类
public interface Strategy {
	
	/**
     * 策略方法
     */
	public void  algorithmInterface();

}


class ConcreteStrategyA implements Strategy {

    @Override
    public void algorithmInterface() {
	System.out.println("策略A的具体算法实现");
    }

}

class ConcreteStrategyB implements Strategy {

    @Override
    public void algorithmInterface() {
	System.out.println("策略B的具体算法实现");
    }

}

class ConcreteStrategyC implements Strategy {

    @Override
    public void algorithmInterface() {
	System.out.println("策略C的具体算法实现");
    }

}