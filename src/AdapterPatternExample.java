// Adaptee
class OldSystem {
    void legacyMethod() {
        System.out.println("Legacy method in OldSystem");
    }
}

// Target
interface NewSystem {
    void newMethod();
}

// Adapter
class Adapter implements NewSystem {
    private OldSystem oldSystem;

    public Adapter(OldSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public void newMethod() {
        oldSystem.legacyMethod();
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        OldSystem oldSystem = new OldSystem();
        NewSystem adapter = new Adapter(oldSystem);

        adapter.newMethod();
    }
}
