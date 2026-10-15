interface First {
    // EXPLAIN: A default method provides an implementation inside an interface.
    default void hello() {
        System.out.println("Hello from First");
    }
}

interface Second {
    // EXPLAIN: This interface declares a default method with the same signature.
    default void hello() {
        System.out.println("Hello from Second");
    }
}

class Greeting implements First, Second {
    // EXPLAIN: The class must resolve the conflict between the two default methods.
    @Override
    public void hello() {
        // EXPLAIN: InterfaceName.super.hello() explicitly calls that interface's default.
        First.super.hello();
        Second.super.hello();

        System.out.println("Hello from Greeting");
    }
}

public class DefaultMethodDemo {
    public static void main(String[] args) {
        Greeting greeting = new Greeting();

        // EXPLAIN: Calls the overridden method that resolves the conflict.
        greeting.hello();
    }
}

