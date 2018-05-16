package day0515;

public class Client02 {
    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer("zhangsan1");
        /*gamePlayer.login("zhangsan", "password");
        gamePlayer.killBoss();
        gamePlayer.upgrade();
        gamePlayer = new GamePlayerProxy(gamePlayer);
        gamePlayer.login("zhangsan", "password");
        gamePlayer.killBoss();
        gamePlayer.upgrade();
        System.out.println("---------------");
        gamePlayer = new GamePlayerProxy("zhangsan1");
        gamePlayer.login("zhangsan", "password");
        gamePlayer.killBoss();
        gamePlayer.upgrade();*/
        System.out.println("111111111111111111111");
        gamePlayer = new GamePlayer("zhangsan1");
        gamePlayer.login("zhangsan", "password");
        gamePlayer.killBoss();
        gamePlayer.upgrade();
        System.out.println("强制代理模式-------------");
        IGamePlayer proxy = gamePlayer.getProxy();
        proxy.login("zhangsan", "password");
        proxy.killBoss();
        proxy.upgrade();
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
        if(this.isProxy()) {
            System.out.println(this.name + ",升级了。。。");
        }else {
            System.out.println("请使用指定的代理访问。");
        }
    }

    @Override
    public IGamePlayer getProxy() {
        this.proxy=new GamePlayerProxy(this);
        return this.proxy;
    }

    private boolean isProxy(){
        if(this.proxy==null){
            return false;
        }
        return true;
    }
}
