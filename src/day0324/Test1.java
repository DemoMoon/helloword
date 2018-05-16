package day0324;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.util.*;

/**
 *
 * @author chen ming hui
 * @date 2018/3/24 11:22
 * @version V1.0
 * @modificationHistory   Who           When                 What
 * ------------------   ------     ------------      ------------------
*/
public class Test1 {
    /**成员变量不需要初始化，因为会给默认设置初始值*/
   static int i;
    public static void main(String[] args) {
        //System.out.println(i);
        //Integer s = new Integer(9);
        //Integer t = new Integer(9);
        //Long l = new Long(9);
        //System.out.println(s==t);包装类型之间的相等应该用equals
        //这里可是赋值
        //System.out.println(s=t);
        //System.out.println(s.equals(t));
        //System.out.println(s.equals(9));
        //System.out.println(s.equals(new Integer(9)));
        //不知hashMap初始化多大，建议写16
        //new HashMap<String,String>(16);
        //new Hashtable<String,String>();
        //new HashSet<String>();
        //System.out.println(1<<30);
        //System.out.println(1<<5);
        //Test  test=null;静态类不需要实例，<堆栈>
        //test.hello();
        //Integer i=42;
        //Long L=42L;
        //Double d=42.0;
        //System.out.println(i.equals(L));本身就不是同一个类型的，直接就返回false了；
        //System.out.println(L.equals(d));本身就不是同一个类型的，直接就返回false了；
        //System.out.println(D.equals(L));本身就不是同一个类型的，直接就返回false了；
        //String str1="hello";
        //String str2="he"+new String("llo");
        //String str3="hello";
        //System.out.println(str1==str2);
        //System.out.println(str1==str3);
        //byte b=127;
        //float f=-412;
        //Float f2=-412f;
        //float f1=412;
        //long test=012;
        ////int other=(int)true;
        //double ds=0x12345678;
        //int sum=0,i=0;
        //for( i=0;i<10;i++,sum+=i){
        //    System.out.println(i);
        //}
        //System.out.println(i);

        //String ss="fsdf";
        //ss.toUpperCase();
        //System.out.println(ss);
        //List<String> s1 = Arrays.asList("yellow", "red", "green", "blue");
        //List<String> s2 = Arrays.asList("yellow", "red", "green", "blue");
        //Collections.shuffle(s1);
        //Collections.shuffle(s2);
        //System.out.println(s1);
        //System.out.println(s2);
        //Collections.shuffle(s1,new Random(10));
        //Collections.shuffle(s2,new Random(10));
        //System.out.println(s1);
        //System.out.println(s2);
        //List<String> strings = Collections.nCopies(5, "123");
        //Collections.fill(strings,"456");
        //System.out.println(strings.size());
        //System.out.println(strings);
        ////System.out.println(strings);
        //List<GregorianCalendar> gregorianCalendars = Collections.nCopies(5, new GregorianCalendar(2005, 0, 1));
        //for(GregorianCalendar gregorianCalendar:gregorianCalendars){
        //    System.out.println(gregorianCalendar.getGregorianChange());
        //}
       Test.hello("");
    }

    private static void test1(){
            throw new NullPointerException();
        //throw new NumberFormatException();
        //throw new ClassNotFoundException();
        //throw new FileNotFoundException();
        //throw new Exception();
    }
    class Ex implements Externalizable{

        /**
         * The object implements the writeExternal method to save its contents
         * by calling the methods of DataOutput for its primitive values or
         * calling the writeObject method of ObjectOutput for objects, strings,
         * and arrays.
         *
         * @param out the stream to write the object to
         * @throws IOException Includes any I/O exceptions that may occur
         * @serialData Overriding methods should use this tag to describe
         * the data layout of this Externalizable object.
         * List the sequence of element types and, if possible,
         * relate the element to a public/protected field and/or
         * method of this Externalizable class.
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {

        }

        /**
         * The object implements the readExternal method to restore its
         * contents by calling the methods of DataInput for primitive
         * types and readObject for objects, strings and arrays.  The
         * readExternal method must read the values in the same sequence
         * and with the same types as were written by writeExternal.
         *
         * @param in the stream to read data from in order to restore the object
         * @throws IOException            if I/O errors occur
         * @throws ClassNotFoundException If the class for an object being
         *                                restored cannot be found.
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        }
    }
}
class Test {
    public  static void hello(String str){
        try {
            System.out.println("123123");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
