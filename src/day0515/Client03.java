package day0515;

public class Client03 {
    public static void main(String[] args) {
      Subject subject=new RealSubject();
      //subject.request();
      subject=new SubjectProxy(subject);
      subject.request();
    }
}

class SubjectProxy implements Subject{

    private Subject subject;

    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("handle begin!");
        this.subject.request();
        System.out.println("handle end!");
    }
}

interface Subject{
    void request();
}

class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("req ......");
    }
}