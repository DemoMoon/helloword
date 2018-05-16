package day0514;

public class NvWa {
    public static void main(String[] args) {
        NvWa nvWa = new NvWa();
        nvWa.cmd(new FemaleFactory());
        nvWa.cmd(new MaleFactory());

    }
    private void cmd(HumanFacotry humanFacotry){
        Human blackHuman = humanFacotry.createBlackHuman();
        blackHuman.getColor();
        blackHuman.talk();
        blackHuman.getSex();
    }
}

interface Human{
    void getColor();
    void talk();
    void getSex();
}
abstract class AbstractBlackHuman implements Human{
    @Override
    public void getColor(){
        System.out.println("black...");
    }
    @Override
    public void talk(){
        System.out.println("black talk");
    }

}

class FemaleBlackHuman extends AbstractBlackHuman {

    @Override
    public void getSex() {
        System.out.println("black female human");
    }
}

class MaleBlackHuman extends AbstractBlackHuman {

    @Override
    public void getSex() {
        System.out.println("black male human");
    }
}

interface HumanFacotry{
    Human createBlackHuman();
}

class FemaleFactory implements HumanFacotry{
    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }
}

class MaleFactory implements HumanFacotry{
    @Override
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }
}
