package day0518;
/**
 * 命令模式：高层次不依赖接收者
 * @author chen ming hui
 * @date 2018/5/18 22:28
 * @version V1.0
 * @modificationHistory   Who           When                 What
 * ------------------   ------     ------------      ------------------
*/
public class Client02 {
    public static void main(String[] args) {
        //调用者
        Invoker02 invoker02 = new Invoker02();
        //定义接收者
        //BaseReceiver concreteReceiver1 = new ConcreteReceiver1();
        //定义一个发送给接收者的命令
        //BaseCommand2 concreteCommand = new ConcreteCommand(concreteReceiver1);
        //定义一个发送给接收者的命令
        BaseCommand2 concreteCommand = new ConcreteCommand();
        //把命令交给调用者去执行
        invoker02.setCommond(concreteCommand);
        invoker02.action();
    }
}

/**
 * 调用者
 */
class Invoker02 {
    private BaseCommand2 command;
    /**
     * 受气包
     * @param command 发什么命令
     */
    void setCommond(BaseCommand2 command) {
        this.command = command;
    }

    void  action(){
        this.command.execute();
    }
}

/**
 * 接收者
 */
abstract class BaseReceiver {
    abstract void action();
}

class ConcreteReceiver1 extends BaseReceiver {
    @Override
    void action() {
        System.out.println("ConcreteReceiver1........");
    }
}

abstract class BaseCommand2 {
    BaseReceiver baseReceiver;
    abstract void execute();

    BaseCommand2(BaseReceiver baseReceiver) {
        this.baseReceiver = baseReceiver;
    }
}

/**
 * 具体命令
 */
class ConcreteCommand extends BaseCommand2 {
    ConcreteCommand() {
        super(new ConcreteReceiver1());
    }

    @Override
    void execute() {
        this.baseReceiver.action();
    }
}
