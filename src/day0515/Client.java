package day0515;

import java.util.ArrayList;

/**
 * 建造者模式
 *
 * @author Administrator
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        director.getABenzModel().run();
        director.getBBwmModel().run();
    }
}

class Director {
    private ArrayList<String> sequence = new ArrayList<>();
    private AbstractCarBuilder benzBuilder = new BenzBuilder();
    private AbstractCarBuilder bmwBuilder = new BmwBuilder();

    /**
     * start ,stop
     */
    AbstractCarModel getABenzModel() {
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return this.benzBuilder.getCarMode();
    }

    /**
     * stop ,start ,alarm
     */
    AbstractCarModel getBBwmModel() {
        this.sequence.clear();
        this.sequence.add("stop");
        this.sequence.add("start");
        this.sequence.add("alarm");
        this.bmwBuilder.setSequence(this.sequence);
        return this.bmwBuilder.getCarMode();
    }
}

abstract class AbstractCarBuilder {
    abstract void setSequence(ArrayList<String> sequence);
    abstract AbstractCarModel getCarMode();
}

class BenzBuilder extends AbstractCarBuilder {
    private AbstractCarModel benzModel = new BenzCarModel();

    @Override
    void setSequence(ArrayList<String> sequence) {
        this.benzModel.setSequence(sequence);
    }

    @Override
    AbstractCarModel getCarMode() {
        return this.benzModel;
    }
}

class BmwBuilder extends AbstractCarBuilder {
    private AbstractCarModel bmwModel = new BmwCarModel();

    @Override
    void setSequence(ArrayList<String> sequence) {
        this.bmwModel.setSequence(sequence);
    }

    @Override
    AbstractCarModel getCarMode() {
        return this.bmwModel;
    }
}

abstract class AbstractCarModel {
    private ArrayList<String> sequence = new ArrayList<>();

    abstract void alarm();

    abstract void engineBoom();

    abstract void start();

    abstract void stop();

    final void run() {
        for (String actionName : sequence) {
            switch (actionName) {
                case "start":
                    this.start();
                    break;
                case "stop":
                    this.stop();
                    break;
                case "alarm":
                    this.alarm();
                    break;
                case "engine boom":
                    this.engineBoom();
                    break;
                default:
                    System.out.println("do nothing!");
                    break;
            }
        }
    }

    final public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}

class BmwCarModel extends AbstractCarModel {

    @Override
    void alarm() {
        System.out.println("bmw alarm");
    }

    @Override
    void engineBoom() {
        System.out.println("bmw engin boom");
    }

    @Override
    void start() {
        System.out.println("bmw start");
    }

    @Override
    void stop() {
        System.out.println("bmw stop");
    }
}


class BenzCarModel extends AbstractCarModel {

    @Override
    void alarm() {
        System.out.println("benz alarm");
    }

    @Override
    void engineBoom() {
        System.out.println("benz engin boom");
    }

    @Override
    void start() {
        System.out.println("benz start");
    }

    @Override
    void stop() {
        System.out.println("benz stop");
    }
}
