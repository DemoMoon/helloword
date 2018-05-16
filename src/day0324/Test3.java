package day0324;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("start the example------");
        final Object obj_1 = new Object();
        final Object obj_2 = new Object();
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                synchronized (obj_2) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread t1 done");
                }
                synchronized (obj_1) {
                    System.out.println("thread t1111 done.");
                }
            }
        };
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                synchronized (obj_2) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread t2 done.");
                }
                synchronized (obj_1) {
                    System.out.println("thread t222 done.");
                }
            }
        };
        Thread[] t=new Thread[5];
        Thread[] t22=new Thread[5];
        for (int i=0;i<5;i++) {
            t[i]=t1;
            t22[i]=t2;
        }
        for(Thread thread:t){
            thread.start();
        }
        for(Thread thread:t22){
            thread.start();
        }
    }
}
