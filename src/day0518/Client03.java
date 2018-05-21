package day0518;

import java.util.ArrayList;
import java.util.Random;

/**
 * 责任链模式
 * @author chen ming hui
 * @date 2018/5/19 0:01
 * @version V1.0
 * @modificationHistory   Who           When                 What
 * ------------------   ------     ------------      ------------------
*/
public class Client03 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<IWomen> iWomen = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            iWomen.add(new Women(random.nextInt(4), "我要出去逛街"));
        }
        BaseHandler fatherHandler = new FatherHandler();
        BaseHandler houseBandHandler = new HouseBandHandler();
        BaseHandler sonBandHandler = new SonBandHandler();
        fatherHandler.setNextHandler(houseBandHandler);
        houseBandHandler.setNextHandler(sonBandHandler);
        for (IWomen women : iWomen) {
            fatherHandler.handleMessage(women);
        }
    }
}

abstract class BaseHandler {
    final static int FATHER_LEVEL_REQUEST = 1;
    final static int HUSBAND_LEVEL_REQUEST = 2;
    final static int SON_LEVEL_REQUEST = 3;
    //能处理的级别
    /**
     * 1 未出嫁
     * 2 已出嫁
     * 3 夫去天堂了
     */
    private int level = 0;
    private BaseHandler nextHandler;

    BaseHandler(int level) {
        this.level = level;
    }

    void setNextHandler(BaseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    final void handleMessage(IWomen women) {
        if (women.getType() == this.level) {
            this.response(women);
            return;
        }
        if (this.nextHandler == null) {
            System.out.println("没地方请示了，按不同意处理------\n");
            return;
        }
        this.nextHandler.handleMessage(women);
    }

    /**
     * 应答
     * @param men men
     */
    abstract void response(IWomen men);
}

class FatherHandler extends BaseHandler {
    FatherHandler() {
        super(FATHER_LEVEL_REQUEST);
    }

    @Override
    void response(IWomen men) {
        System.out.println(men.getRequest());
        System.out.println("父亲的答复是：同意\n");
    }
}

class HouseBandHandler extends BaseHandler {
    HouseBandHandler() {
        super(HUSBAND_LEVEL_REQUEST);
    }

    @Override
    void response(IWomen men) {
        System.out.println(men.getRequest());
        System.out.println("丈夫的答复是：同意\n");
    }
}

class SonBandHandler extends BaseHandler {
    SonBandHandler() {
        super(SON_LEVEL_REQUEST);
    }

    @Override
    void response(IWomen men) {
        System.out.println(men.getRequest());
        System.out.println("儿子的答复是：同意\n");
    }
}

interface IWomen {
    int getType();

    String getRequest();
}

class Women implements IWomen {
    private int type = 0;
    private String request;

    public Women(int type, String request) {
        this.type = type;
        switch (this.type) {
            case 1:
                this.request = "女儿的请求是:" + request;
                break;
            case 2:
                this.request = "妻子的请求是:" + request;
                break;
            case 3:
                this.request = "母亲的请求是:" + request;
                break;
            default:
                break;
        }
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
}