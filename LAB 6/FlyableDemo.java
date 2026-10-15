interface Flyable {
    // EXPLAIN: This interface defines a capability that implementing classes must provide.
    void fly();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        // EXPLAIN: Bird provides its own implementation of flying.
        System.out.println("Bird flies by flapping its wings.");
    }
}

class Aeroplane implements Flyable {
    @Override
    public void fly() {
        // EXPLAIN: Aeroplane implements the same capability differently.
        System.out.println("Aeroplane flies using its engines.");
    }
}

public class FlyableDemo {
    public static void main(String[] args) {
        // EXPLAIN: Unrelated classes can share the Flyable interface.
        Flyable[] flyingObjects = { new Bird(), new Aeroplane() };

        for (Flyable object : flyingObjects) {
            // EXPLAIN: The actual object's fly() method is called.
            object.fly();
        }
    }
}


