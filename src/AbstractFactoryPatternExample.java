interface AbstractProductA {
    void createProductA();
}

interface AbstractProductB {
    void createProductB();
}

class ConcreteProductA1 implements AbstractProductA {
    @Override
    public void createProductA() {
        System.out.println("Product A1 created");
    }
}

class ConcreteProductB1 implements AbstractProductB {
    @Override
    public void createProductB() {
        System.out.println("Product B1 created");
    }
}

class ConcreteProductA2 implements AbstractProductA {
    @Override
    public void createProductA() {
        System.out.println("Product A2 created");
    }
}

class ConcreteProductB2 implements AbstractProductB {
    @Override
    public void createProductB() {
        System.out.println("Product B2 created");
    }
}

interface AbstractFactory {
    AbstractProductA createProductA();

    AbstractProductB createProductB();
}

class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}

class ConcreteFactory2 implements AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreteProductB2();
    }
}

public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        AbstractProductA productA1 = factory1.createProductA();
        AbstractProductB productB1 = factory1.createProductB();

        AbstractFactory factory2 = new ConcreteFactory2();
        AbstractProductA productA2 = factory2.createProductA();
        AbstractProductB productB2 = factory2.createProductB();
    }
}
