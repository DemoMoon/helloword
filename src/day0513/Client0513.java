package day0513;

public class Client0513 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Creator creator = new ConcreteCreator();
        Product product = creator.createProduct(ConcreateProduct1.class);
        product.method1();
        product = creator.createProduct(ConcreateProduct2.class);
        product.method1();

        /**
         * 简单工厂模式
         */
        Product product1 = ConcreteCreatorFactory.createProduct(ConcreateProduct1.class);
        product1.method1();
        product1 = creator.createProduct(ConcreateProduct2.class);
        product1.method1();
    }
}

abstract class Product {
    abstract void method1();
}

class ConcreateProduct1 extends Product {

    @Override
    void method1() {
        System.out.println("method1......");
    }
}

class ConcreateProduct2 extends Product {

    @Override
    void method1() {
        System.out.println("method2......");
    }
}

abstract class Creator {
    abstract <T extends Product> T createProduct(Class<T> c) throws ClassNotFoundException, IllegalAccessException, InstantiationException;
}

class ConcreteCreator extends Creator {
    @Override
    <T extends Product> T createProduct(Class<T> c) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Product product = (Product) Class.forName(c.getName()).newInstance();
        return (T) product;
    }
}

class ConcreteCreatorFactory {
    public static <T extends Product> T createProduct(Class<T> c) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Product product = (Product) Class.forName(c.getName()).newInstance();
        return (T) product;
    }
}

