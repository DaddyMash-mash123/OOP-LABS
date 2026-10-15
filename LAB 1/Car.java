public class Car {

    // EXPLAIN: These fields store the details of each Car object.
    String brand;
    int year;
    double mileage;

    /*EXPLAIN: This is the constructor for the Car class. 
    It initializes the brand, year, and mileage fields with the provided values*/
    public Car(String brand, int year, double mileage) {

        /* EXPLAIN: The 'this' keyword is used to refer to the current object's fields
        so that we can distinguish between the constructor parameters and the object's fields.*/
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
    }

    // EXPLAIN: This method displays the details of the Car object//
    public void displayDetails() {
        System.out.println("Brand: " + brand +
                ", Year: " + year +
                " and Mileage: " + mileage);
    }

    //Explain: this method determines if the car is more than 25 years old
    public boolean isAntique(){
        return 2026 - year > 25;
    }

    //Explain: This method creates a new Car object with the specified brand, year, and mileage
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", 1995, 150000.0);
        Car c2 = new Car("Honda", 2010, 80000.0);
        Car c3 = new Car("Ford", 2018, 200000.0);
        // EXPLAIN: Displaying the details of each car using the displayDetails method
        c1.displayDetails();
        System.out.println("Therefore Toyota Antique: " + c1.isAntique());

        c2.displayDetails();
        System.out.println("Therefore Honda Antique: " + c2.isAntique());

        c3.displayDetails();
        System.out.println("Therefore Ford Antique: " + c3.isAntique());
    
    }
}

