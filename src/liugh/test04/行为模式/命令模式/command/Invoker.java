package liugh.test04.行为模式.命令模式.command;

/**
 * 要求该命令执行这个请求
 * 
 * @author liu yuning
 *
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
	this.command = command;
    }

    public void executeCommand() {
	command.execute();
    }

}
