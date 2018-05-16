package day0514;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        G<String, String> stringStringG = new G<>();
        stringStringG.setT1("t1");
        stringStringG.setT2("t2");
        System.out.println(stringStringG);
    }
}
class G<T1,T2> {
    private T1 t1 ;
    private T2 t2 ;

    public T1 getT1() {
        return t1;
    }

    public void setT1(T1 t1) {
        this.t1 = t1;
    }

    public T2 getT2() {
        return t2;
    }

    public void setT2(T2 t2) {
        this.t2 = t2;
    }
}
