public class Student {
    // EXPLAIN: private fields prevent direct access from outside this class
    private String name;
    private int marks;

    public Student(String name, int marks) {
        // EXPLAIN: the constructor initialises the object and validates its marks
        this.name = name;
        setMarks(marks);
    }

    public String getName() {
        // EXPLAIN: the getter provides controlled read access to the private name field
        return name;
    }

    public int getMarks() {
        // EXPLAIN: the getter provides read access to the private marks field
        return marks;
    }

    public void setMarks(int marks) {
        // EXPLAIN: validation prevents marks outside the permitted range of 0 to 100
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }
    public static void main(String[] args) {
        // EXPLAIN: creates a Student object with valid marks
        Student s = new Student("Tariro", 85);
        System.out.println("Name: " + s.getName());
        System.out.println("Marks: " + s.getMarks());
        // EXPLAIN: the setter accepts valid marks and updates the field
        s.setMarks(90);
        System.out.println("Updated marks: " + s.getMarks());
        System.out.println("Grade: " + s.getGrade());
    }
    
    public String getGrade() {
        // EXPLAIN: the grade is calculated from marks instead of stored in another field
        if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else {
            return "F";
        }        
    }    
}