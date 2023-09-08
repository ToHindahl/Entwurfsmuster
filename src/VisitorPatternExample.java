interface Visitor {
    void visit(Element element);
}

class ConcreteVisitor implements Visitor {
    @Override
    public void visit(Element element) {
        System.out.println("Visited " + element.getName());
    }
}

interface Element {
    String getName();

    void accept(Visitor visitor);
}

class ConcreteElement implements Element {
    private String name;

    public ConcreteElement(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

public class VisitorPatternExample {
    public static void main(String[] args) {
        Element element = new ConcreteElement("Element");
        Visitor visitor = new ConcreteVisitor();

        element.accept(visitor);
    }
}
