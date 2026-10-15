
public class Person {

    // EXPLAIN: Declare a variable to store the person's name
    String name;

    // EXPLAIN: Declare a reference variable to store the person's Address object
    Address address;

    // EXPLAIN: Create a constructor that receives the person's name and address
    public Person(String name, Address address) {

        // EXPLAIN: Assign the received name to the object's name variable
        this.name = name;

        // EXPLAIN: Assign the received address object to the object's address variable
        this.address = address;
    }

    public static void main(String[] args) {

        // EXPLAIN: Create an Address object and store Harare as the city
        Address myAddress = new Address("Harare");

        // EXPLAIN: Create a Person object with a name and the address object
        Person person = new Person("Elson", myAddress);

        // EXPLAIN: Display the person's name
        System.out.println("Name: " + person.name);

        // EXPLAIN: Access the address object and display its city
        System.out.println("City: " + person.address.city);

        
        // EXPLAIN: Create a Person object with no Address object
        Person person2 = new Person("John", null);

        // EXPLAIN: Attempt to access the city through a null address
        System.out.println(person2.address.city);

    }
}
