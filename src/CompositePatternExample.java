import java.util.ArrayList;
import java.util.List;

// Component
interface Component {
    void operation();
}

// Leaf
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + " operation");
    }
}

// Composite
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite operation");
        for (Component component : children) {
            component.operation();
        }
    }
}

public class CompositePatternExample {
    public static void main(String[] args) {
        Leaf leaf1 = new Leaf("A");
        Leaf leaf2 = new Leaf("B");
        Leaf leaf3 = new Leaf("C");

        Composite composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);

        Composite composite2 = new Composite();
        composite2.add(leaf3);
        composite2.add(composite);

        composite2.operation();
    }
}
