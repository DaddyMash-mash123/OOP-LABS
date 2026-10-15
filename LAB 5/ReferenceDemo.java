class Animal {
    String type = "Animal";

    void sound() {
        // EXPLAIN: This is the superclass implementation.
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    String type = "Dog";

    @Override
    void sound() {
        // EXPLAIN: This overrides the superclass method.
        System.out.println("Woof");
    }
}

public class ReferenceDemo {
    public static void main(String[] args) {
        // EXPLAIN: The reference type is Animal, but the object is a Dog.
        Animal animal = new Dog();

        // EXPLAIN: Overridden methods are selected by the actual object type.
        animal.sound();

        // EXPLAIN: Fields are selected by the declared reference type.
        System.out.println(animal.type);
    }
}


