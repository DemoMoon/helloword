package day0518;

/**
 * 命令模式
 * @author chen ming hui
 * @date 2018/5/18 22:12
 * @version V1.0
 * @modificationHistory   Who           When                 What
 * ------------------   ------     ------------      ------------------
*/
public class Client01 {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setCommand(new FindPageGroup());
        invoker.action();
        invoker.setCommand(new FindCodeGroup());
        invoker.action();
    }
}

class Invoker{
    private BaseCommand command;

    void setCommand(BaseCommand command) {
        this.command = command;
    }
    void action(){
        this.command.execute();
    }
}

abstract class BaseCommand {
    Group codeGroup=new CodeGroup();
    Group pageGroup=new PageGroup();
    abstract void execute();
}

class FindPageGroup extends BaseCommand {

    @Override
    void execute() {
        super.pageGroup.find();
    }
}

class FindCodeGroup extends BaseCommand {

    @Override
    void execute() {
        super.codeGroup.find();
    }
}

interface Group{
    void find();
}

class CodeGroup implements Group{

    @Override
    public void find() {
        System.out.println("研发");
    }
}

class PageGroup implements Group{
    @Override
    public void find() {
        System.out.println("美工");
    }
}

