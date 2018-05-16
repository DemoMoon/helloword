package day0513;

public class NvWa {
    public static void main(String[] args) {
        NvWa nvWa = new NvWa();
        AbstractHumanFactory abstractHumanFactory = new WhiteHumFactory();
        nvWa.cmd(abstractHumanFactory);
        abstractHumanFactory = new BlackHumFactory();
        nvWa.cmd(abstractHumanFactory);
        abstractHumanFactory = new YellowHumFactory();
        nvWa.cmd(abstractHumanFactory);

    }

    private  void cmd(AbstractHumanFactory factory) {
        Human human = factory.createHuman();
        human.getColor();
        human.talk();
    }
}

interface Human {
    void getColor();

    void talk();
}

class BlackHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("black......");
    }

    @Override
    public void talk() {
        System.out.println("black talk......");
    }
}

class YellowHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("yellow......");
    }

    @Override
    public void talk() {
        System.out.println("yellow talk......");
    }
}

class WhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("white......");
    }

    @Override
    public void talk() {
        System.out.println("white talk......");
    }
}

abstract class AbstractHumanFactory {
    abstract Human createHuman();
}

class BlackHumFactory extends AbstractHumanFactory {
    @Override
    Human createHuman() {
        return new BlackHuman();
    }
}

class WhiteHumFactory extends AbstractHumanFactory {
    @Override
    Human createHuman() {
        return new WhiteHuman();
    }
}

class YellowHumFactory extends AbstractHumanFactory {
    @Override
    Human createHuman() {
        return new YellowHuman();
    }
}