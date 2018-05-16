package day1;

public class Day1Test {
    public static void main(String[] args) {
        test1();
    }
    private static void test2(){
        // FIXME 2018/3/23 12:01 必须初始化，编译不通过。
        //String ss;
        //String ss="hello";
        //System.out.println("s="+ss);
    }
   private static void test1(){
        String b1="hello";
        String hello = new String("hello");
        System.out.println(hello==b1);
        System.out.println(hello.equals(b1));
    }
}
