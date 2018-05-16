package day0427;

public class ThreadLocalTest {
   static ThreadLocal<String> threadLocal=new ThreadLocal<String>();

    public static void main(String[] args) {
        threadLocal.set("我的值");
        System.out.println(threadLocal.get());
        System.out.println(threadLocal.get());
    }
}
