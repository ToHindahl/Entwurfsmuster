// Abstract Component
abstract class AbstractTaco {
    protected int size;

    public AbstractTaco(int size) {
        this.size = size;
    }

    public abstract int calcPrice();
}

// Concrete Component
class Taco extends AbstractTaco {
    public Taco(int size) {
        super(size);
    }

    @Override
    public int calcPrice() {
        // Basierend auf der Größe des Taco den Preis berechnen
        int price = 0;
        switch (size) {
            case 1:
                price = 5;
                break;
            case 2:
                price = 7;
                break;
            case 3:
                price = 9;
                break;
            default:
                break;
        }
        return price;
    }
}

// Decorator
abstract class TacoDecorator extends AbstractTaco {
    protected AbstractTaco taco;

    public TacoDecorator(AbstractTaco taco) {
        super(taco.size);
        this.taco = taco;
    }

    @Override
    public abstract int calcPrice();
}

// Concrete Decorators
class MeatDecorator extends TacoDecorator {
    private int gramsMeat;

    public MeatDecorator(AbstractTaco taco, int gramsMeat) {
        super(taco);
        this.gramsMeat = gramsMeat;
    }

    @Override
    public int calcPrice() {
        // Preis des Basistacos plus den Preis für das Fleisch basierend auf der Grammzahl
        int basePrice = taco.calcPrice();
        int meatPrice = gramsMeat * 2; // Annahme: 2 Euro pro 100 Gramm Fleisch
        return basePrice + meatPrice;
    }
}

class GuacamoleDecorator extends TacoDecorator {
    private int gramsGuacamole;

    public GuacamoleDecorator(AbstractTaco taco, int gramsGuacamole) {
        super(taco);
        this.gramsGuacamole = gramsGuacamole;
    }

    @Override
    public int calcPrice() {
        // Preis des Basistacos plus den Preis für das Guacamole basierend auf der Grammzahl
        int basePrice = taco.calcPrice();
        int guacamolePrice = gramsGuacamole * 3; // Annahme: 3 Euro pro 100 Gramm Guacamole
        return basePrice + guacamolePrice;
    }
}

class CheeseDecorator extends TacoDecorator {
    private int gramsCheese;

    public CheeseDecorator(AbstractTaco taco, int gramsCheese) {
        super(taco);
        this.gramsCheese = gramsCheese;
    }

    @Override
    public int calcPrice() {
        // Preis des Basistacos plus den Preis für den Käse basierend auf der Grammzahl
        int basePrice = taco.calcPrice();
        int cheesePrice = gramsCheese * 1; // Annahme: 1 Euro pro 100 Gramm Käse
        return basePrice + cheesePrice;
    }
}

public class TacoDecoratorExample {
    public static void main(String[] args) {
        // Erstellen Sie einen Grundtaco
        AbstractTaco basicTaco = new Taco(2);

        // Fügen Sie nach und nach Zutaten hinzu und berechnen Sie den Preis
        TacoDecorator meatTaco = new MeatDecorator(basicTaco, 150);
        TacoDecorator guacamoleCheeseTaco = new GuacamoleDecorator(new CheeseDecorator(meatTaco, 50), 80);

        int totalPrice = guacamoleCheeseTaco.calcPrice();
        System.out.println("Total Price: " + totalPrice + " Euro");
    }
}
