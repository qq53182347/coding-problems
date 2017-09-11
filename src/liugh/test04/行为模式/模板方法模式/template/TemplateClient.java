package liugh.test04.行为模式.模板方法模式.template;

/**
 * 模板方法客户端
 * 
 * @author liu yuning
 *
 */
public class TemplateClient {
    public static void main(String[] args) {
	AbstractTemplate abstractTemplate;

	abstractTemplate = new ConcreteClassA();
	abstractTemplate.templateMethod();

	abstractTemplate = new ConcreteClassB();
	abstractTemplate.templateMethod();

    }
}
