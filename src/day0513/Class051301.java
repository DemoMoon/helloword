package day0513;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Class051301 {
    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy();
        //获得代理对象
        Foo proxy = myProxy.getProxy();
        //调用代理对象的dance方法
        proxy.dance();
    }
}

class MyProxy {
    private Foo foo = new FooImp();
    Foo getProxy() {
        //使用Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)返回某个对象的代理对象
        return (Foo) Proxy.newProxyInstance(MyProxy.class.getClassLoader(), foo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(foo, args);
            }
        });
    }
}

interface Foo {
    void dance();
}

class FooImp implements Foo {

    @Override
    public void dance() {
        System.out.println("start dance。。。。。。。。");
    }
}
