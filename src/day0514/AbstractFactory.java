package day0514;

public class AbstractFactory {
    public static void main(String[] args) {
             AbstractFactory abstractFactory=new AbstractFactory();
             abstractFactory.cmd(new Creator1());
             abstractFactory.cmd(new Creator2());
    }

    private void cmd(CreatorFactory creatorFactory){
        AbstractProductA abstractProductA = creatorFactory.creator1();
        abstractProductA.productA();
        AbstractProductB abstractProductB = creatorFactory.creator2();
        abstractProductB.productB();
    }
}

abstract class AbstractProductA{
    abstract void  productA();
}

class ProductA1 extends AbstractProductA{

    @Override
    void productA() {
        System.out.println("productA.....");
    }

}
class ProductA2 extends AbstractProductA{

    @Override
    void productA() {
        System.out.println("productA2.....");
    }
}

abstract class AbstractProductB{
    abstract void  productB();
}

class ProductB1 extends AbstractProductB{

    @Override
    void productB() {
        System.out.println("productB.....");
    }

}
class ProductB2 extends AbstractProductB{

    @Override
    void productB() {
        System.out.println("productB2.....");
    }
}

abstract class CreatorFactory{
   abstract AbstractProductA creator1();
   abstract AbstractProductB creator2();
}

class  Creator1 extends CreatorFactory{
    @Override
    AbstractProductA creator1() {
        return new ProductA1();
    }

    @Override
    AbstractProductB creator2() {
        return new ProductB1();
    }
}

class  Creator2 extends CreatorFactory{
    @Override
    AbstractProductA creator1() {
        return new ProductA2();
    }

    @Override
    AbstractProductB creator2() {
        return new ProductB2();
    }
}



