package day0421;

/**
 *工厂方法模式
 * @author chen ming hui
 * @date 2018/4/21 13:32
 * @version V1.0
 * @modificationHistory   Who           When                 What
 * ------------------   ------     ------------      ------------------
*/
public class Factory {
    public static void main(String[] args) {
        ICarFactory iCarFactory=new BikeFactory();
        iCarFactory.getCar().gotoWork();
        iCarFactory=new BusFacttory();
        iCarFactory.getCar().gotoWork();
    }
}

interface ICar {
    /**
     * 去工作
     */
    void gotoWork();
}

class Bike implements ICar{

    @Override
    public void gotoWork() {
        System.out.println("goto work by bike...");
    }
}

class Bus implements ICar{

    @Override
    public void gotoWork() {
        System.out.println("goto work bus...");
    }
}

interface ICarFactory{
    /**
     * 工厂制造什么交通工具去上班。
     * @return ICar  具体的产品，自行车，公交
     */
    ICar getCar();
}

class BikeFactory implements ICarFactory{

    @Override
    public ICar getCar() {
        return new Bike();
    }
}

class BusFacttory implements ICarFactory{

    @Override
    public ICar getCar() {
        return new Bus();
    }
}