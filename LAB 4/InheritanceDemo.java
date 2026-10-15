class Person {
    protected String name;
    protected int age;
    public Person(String name, int age) {
        // EXPLAIN: Initialize the common Person fields.
        this.name = name;
        this.age = age;
    }
    public void display() {
        // EXPLAIN: This shared method is inherited by both subclasses.
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    private String course;
    public Student(String name, int age, String course) {
        // EXPLAIN: Pass common details to the superclass constructor.
        super(name, age);
        this.course = course;
    }
    public void displayStudent() {
        // EXPLAIN: Reuse the inherited method instead of rewriting it.
        display();
        System.out.println("Course: " + course);
    }
}

class Teacher extends Person {
    private String subject;
    public Teacher(String name, int age, String subject) {
        // EXPLAIN: Teacher also uses the Person constructor.
        super(name, age);
        this.subject = subject;
    }
    public void displayTeacher() {
        // EXPLAIN: Teacher reuses the same inherited display() method.
        display();
        System.out.println("Subject: " + subject);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        // EXPLAIN: Create one Student and one Teacher.
        Student student = new Student("Tariro", 20, "Computing");
        Teacher teacher = new Teacher("Mr Moyo", 40, "Java");
        System.out.println("Student:");
        student.displayStudent();
        System.out.println("\nTeacher:");
        teacher.displayTeacher();
    }
}

