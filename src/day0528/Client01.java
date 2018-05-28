package day0528;

/**
 * 状态模式
 * @author chen ming hui
 * @date 2018/5/28 22:59
 * @version V1.0
 * @modificationHistory   Who           When                 What
 * ------------------   ------     ------------      ------------------
*/
public class Client01 {
    public static void main(String[] args) {
        //定义一个普通的人
        Human human=new Human();
        //设置一个人的初始状态
        human.setHumanState(Human.childState);
        human.worker();
        human.worker();
        human.worker();
    }
}
abstract class HumanState{
    Human human;
    void setHuman(Human human) {
        this.human = human;
    }

    /**
     * 适当的年纪干该干的活
     */
    abstract void worker();
}

class Human{
    /**
     *
     */
    static HumanState childState=new ChildState();
    static HumanState adultState=new AdultState();
    static HumanState oldState=new OldState();
    private HumanState humanState;

    void setHumanState(HumanState humanState) {
        this.humanState = humanState;
        this.humanState.setHuman(this);
    }

    void worker(){
        this.humanState.worker();
    }
}

class ChildState extends HumanState{
    @Override
    void worker() {
        System.out.println("小孩玩耍。。。");
        super.human.setHumanState(Human.adultState);
    }
}

class AdultState extends HumanState{
    @Override
    void worker() {
        System.out.println("成年人养活自己。。。");
        super.human.setHumanState(Human.oldState);
    }
}

class OldState extends HumanState{
    @Override
    void worker() {
        System.out.println("成年人养活自己。。。");
    }
}
