class Vehicle {
    public Vehicle() {
        // EXPLAIN: The superclass constructor runs first.
        System.out.println("Vehicle constructor");
    }
}

class Car extends Vehicle {
    public Car() {
        // EXPLAIN: Java calls super() to run Vehicle() before this body.
        System.out.println("Car constructor");
    }
}

class ElectricCar extends Car {
    public ElectricCar() {
        // EXPLAIN: Car() runs after Vehicle() and before this body.
        System.out.println("ElectricCar constructor");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        // EXPLAIN: Creating ElectricCar triggers all three constructors.
        new ElectricCar();
    }
}

