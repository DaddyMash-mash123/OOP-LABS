public class Employee {
    // EXPLAIN: static counter is shared by all Employee objects
    private static int nextId = 1;
    private final int employeeId;
    private String name;
    private double salary;
    // EXPLAIN: Constructor 1 with no arguments
    public Employee() {
        this("Unknown", 0.0);
    }
    // EXPLAIN: Constructor 2 with name only
    public Employee(String name) {
        this(name, 0.0);
    }
    // EXPLAIN: Constructor 3 with name and salary
    public Employee(String name, double salary) {
        // EXPLAIN: this(...) chains to another constructor and must come first
        this.employeeId = nextId++;
        this.name = name;       // EXPLAIN: this.name is the field; name is the parameter
        this.salary = salary;  
    }
    // EXPLAIN: Copy constructor
    public Employee(Employee other) {
        this(other.name, other.salary); // EXPLAIN: the copied Employee receives a new, unique ID        
    }
    // EXPLAIN: Displays the employee's ID, name and salary
    public void display() {
        System.out.println(employeeId + " " + name + " " + salary);
    }
    public static void main(String[] args) {       
        Employee e1 = new Employee();  //EXPLAIN: Creates an Employee using the no-argument constructor
        Employee e2 = new Employee("Tendai");  //EXPLAIN: Creates an Employee using the constructor that accepts a name
        Employee e3 = new Employee("Rudo", 2500.0);  //EXPLAIN: Creates an Employee using the constructor that accepts a name and salary
        Employee e4 = new Employee(e3);  //EXPLAIN: Creates a copy of e3 using the copy constructor        
        // EXPLAIN: Calls display() to print the details of each Employee object
        e1.display();
        e2.display();
        e3.display();
        e4.display();
    }
}