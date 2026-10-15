class Person {
    // EXPLAIN: These fields store the common details of every person.
    protected String name;
    protected int age;
    // EXPLAIN: The constructor initializes the inherited fields.
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // EXPLAIN: Subclasses inherit this method and can reuse it.
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Student extends Person {
    // EXPLAIN: Student inherits name, age and display() from Person.
    private String course;
    public Student(String name, int age, String course) {
        // EXPLAIN: super() calls the Person constructor first.
        super(name, age);
        this.course = course;
    }
    public void displayStudent() {
        // EXPLAIN: Call the inherited display() method.
        display();
        System.out.println("Course: " + course);
    }
}
public class PersonDemo {
    public static void main(String[] args) {
        // EXPLAIN: Create a Student object with inherited and new data.
        Student student = new Student("Tariro", 20, "Computer Science");

        // EXPLAIN: Display the student's details.
        student.displayStudent();
    }
}

