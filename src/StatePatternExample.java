// Context
class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handleRequest(this);
    }
}

// State
interface State {
    void handleRequest(Context context);
}

// Concrete States
class ConcreteStateA implements State {
    @Override
    public void handleRequest(Context context) {
        System.out.println("Handling request in State A");
        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB implements State {
    @Override
    public void handleRequest(Context context) {
        System.out.println("Handling request in State B");
        context.setState(new ConcreteStateA());
    }
}

public class StatePatternExample {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteStateA());

        context.request();
        context.request();
    }
}
