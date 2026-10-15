class Animal {
    String name;

    public Animal(String name) {
        // EXPLAIN: Store the name supplied to the superclass.
        this.name = name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        // EXPLAIN: Explicitly call the available superclass constructor.
        super(name);
    }

    public void display() {
        // EXPLAIN: Dog can access the name initialized by Animal.
        System.out.println("Dog name: " + name);
    }
}

public class InheritanceConstructorDemo {
    public static void main(String[] args) {
        // EXPLAIN: Pass a name so the Animal constructor can run.
        Dog dog = new Dog("Buddy");
        dog.display();
    }
}




