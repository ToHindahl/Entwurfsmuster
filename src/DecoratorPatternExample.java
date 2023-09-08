// Component
interface Coffee {
    void brew();
}

// ConcreteComponent
class SimpleCoffee implements Coffee {
    @Override
    public void brew() {
        System.out.println("Brewing simple coffee");
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public void brew() {
        decoratedCoffee.brew();
    }
}

// ConcreteDecorator
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public void brew() {
        super.brew();
        addMilk();
    }

    private void addMilk() {
        System.out.println("Adding milk");
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);

        milkCoffee.brew();
    }
}
