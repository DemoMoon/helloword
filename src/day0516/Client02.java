package day0516;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author chen ming hui
 * @version V1.0
 * @date 2018/5/16 22:38
 * @modificationHistory Who           When                 What
 * ------------------   ------     ------------      ------------------
 */
public class Client02 {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        //动态代理类
        InvocationHandler handler = new MyInvocationHandler(subject);
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
        proxy.request();
        //具体业务代理类
        proxy = SubjectDynamicProxy.newProxyInstance(subject);
        proxy.request();
    }
}

class SubjectDynamicProxy extends DynamicProxy {
    static <T> T newProxyInstance(Subject subject) {
        ClassLoader classLoader = subject.getClass().getClassLoader();
        Class<?>[] interfaces = subject.getClass().getInterfaces();
        InvocationHandler handler = new MyInvocationHandler(subject);
        return newProxyInstance(classLoader, interfaces, handler);
    }
}

class DynamicProxy<T> {
    static <T> T newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler handler) {
        if (true) {
            new BeforeAdvice().execute();
        }
        return (T) Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.object, args);
    }
}

interface IAdvice {
    void execute();
}

class BeforeAdvice implements IAdvice {

    @Override
    public void execute() {
        System.out.println("我被通知了。");
    }
}

interface Subject {
    void request();
}

class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("req ......");
    }
}


