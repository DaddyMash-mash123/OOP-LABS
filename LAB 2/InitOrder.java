public class InitOrder {

    // EXPLAIN: A static field is initialised once when the class is initialised
    static int a = show("static field");

    // EXPLAIN: An instance field is initialised each time a new object is created
    int b = show("instance field");

    // EXPLAIN: A static initialiser block runs once when the class is first initialised
    static {
        show("static block");
    }

    // EXPLAIN: An instance initialiser block runs every time an object is created,
    // before the constructor body executes
    {
        show("instance block");
    }

    // EXPLAIN: The constructor runs after the instance field and instance block
    // have been executed for the new object
    InitOrder() {
        show("constructor");
    }

    // EXPLAIN: This static method prints the supplied message and returns 1
    static int show(String msg) {
        System.out.println(msg);
        return 1;
    }

    /*EXPLAIN: The main method is the entry point where program execution begins
    It will prints a heading before the first object is created*/
    public static void main(String[] args) {
        System.out.println("--- first object ---");

        // EXPLAIN: Creates the first object, triggering instance initialisation and the constructor
        new InitOrder();

        // EXPLAIN: Prints a heading before the second object is created
        System.out.println("--- second object ---");

        // EXPLAIN: Creates the second object; instance initialisation and the constructor run again
        new InitOrder();
    }
}
