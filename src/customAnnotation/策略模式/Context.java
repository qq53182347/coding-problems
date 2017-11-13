package customAnnotation.策略模式;


/**
 * 环境,持有Strategy(策略)的引用
 * @author liuguanghui
 *
 */
public class Context {
	
	Strategy strategy;
	
	public Context (Strategy strategy){
		this.strategy = strategy;
	}
	
	public void contextInterface(){
		strategy.algorithmInterface();
	}

}
