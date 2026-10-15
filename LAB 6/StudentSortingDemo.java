import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    private final String name;
    private final double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public int compareTo(Student other) {
        // EXPLAIN: Comparable defines the natural ordering, here alphabetical by name.
        return name.compareTo(other.name);
    }

    @Override
    public String toString() {
        // EXPLAIN: Display each student clearly when printing the list.
        return name + "(" + marks + ")";
    }
}

public class StudentSortingDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
            new Student("Kuda", 72),
            new Student("Ada", 91),
            new Student("Lynn", 84)
        ));

        // EXPLAIN: Natural sorting uses the compareTo() method.
        students.sort(null);
        System.out.println("By name: " + students);

        // EXPLAIN: Comparator supplies an alternative ordering by marks, highest first.
        students.sort(
            Comparator.comparingDouble(Student::getMarks).reversed()
        );
        System.out.println("By marks: " + students);
    }
}



