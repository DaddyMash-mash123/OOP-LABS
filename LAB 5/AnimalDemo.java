class Animal {
    // EXPLAIN: Subclasses override this method with their own sounds.
    void sound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        // EXPLAIN: Cat provides its own implementation of sound().
        System.out.println("Meow");
    }
}

class Cow extends Animal {
    @Override
    void sound() {
        // EXPLAIN: Cow overrides the inherited sound() method.
        System.out.println("Moo");
    }
}

class Duck extends Animal {
    @Override
    void sound() {
        // EXPLAIN: Duck provides a different sound implementation.
        System.out.println("Quack");
    }
}

public class AnimalDemo {
    public static void main(String[] args) {
        // EXPLAIN: Each subclass object can be stored in an Animal reference.
        Animal[] animals = {
            new Cat(),
            new Cow(),
            new Duck()
        };

        // EXPLAIN: Java calls sound() according to each object's actual class.
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}


