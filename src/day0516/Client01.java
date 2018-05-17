package day0516;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client01 {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer("zhangsan1");

        /*
         * 动态代理
         */
        InvocationHandler handler = new GamePlayIH(gamePlayer);
        IGamePlayer proxy2 = (IGamePlayer) Proxy.newProxyInstance(gamePlayer.getClass().getClassLoader(), new Class[]{IGamePlayer.class}, handler);
        proxy2.login("zhangsan", "password");
        proxy2.killBoss();
        proxy2.upgrade();
    }
}

/**
 * InvocationHandler 实现动态代理
 *
 * @author chen ming hui
 * @version V1.0
 * @date 2018/5/16 21:55
 * @modificationHistory Who           When                 What
 * ------------------   ------     ------------      ------------------
 */
class GamePlayIH implements InvocationHandler {

    //被代理的实例
    private Object obj = null;

    /**
     * 我要代理谁
     *
     * @param obj
     */
    public GamePlayIH(Object obj) {
        this.obj = obj;
    }

    /**
     * 调用被代理的方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        switch (method.getName()) {
            case "login":
                System.out.println("我的账号被登录了。。。。");
                break;
            default:
                break;
        }
        return method.invoke(this.obj, args);
    }
}


class GamePlayerProxy implements IGamePlayer {
    private IGamePlayer gamePlayer;

    public GamePlayerProxy(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public GamePlayerProxy(String name) {
        this.gamePlayer = new GamePlayer(name);
    }

    @Override
    public void login(String username, String password) {
        this.gamePlayer.login(username, password);
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }

    @Override
    public IGamePlayer getProxy() {
        return this;
    }
}


interface IGamePlayer {
    void login(String username, String password);

    void killBoss();

    void upgrade();

    IGamePlayer getProxy();
}

class GamePlayer implements IGamePlayer {
    private IGamePlayer proxy;
    private String name;

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String username, String password) {
        System.out.println("login:" + this.name + ",success!");
    }

    @Override
    public void killBoss() {
        System.out.println(this.name + "，打怪。。");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name + ",升级了。。。");
       /* if (this.isProxy()) {
            System.out.println(this.name + ",升级了。。。");
        } else {
            System.out.println("请使用指定的代理访问。");
        }*/
    }

    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    private boolean isProxy() {
        if (this.proxy == null) {
            return false;
        }
        return true;
    }
}
