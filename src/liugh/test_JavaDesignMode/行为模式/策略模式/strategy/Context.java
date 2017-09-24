package liugh.test_JavaDesignMode.行为模式.策略模式.strategy;

/**
 * 上下文
 * 
 * @author liu yuning
 *
 */
public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
	this.strategy = strategy;
    }

    /**
     * 上下文接口
     */
    public void contextInterface() {
	strategy.algorithmInterface();
    }

}