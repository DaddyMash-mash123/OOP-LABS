import java.util.Comparator;
import java.util.List;

record Student(String name, double marks) {}

public class StudentAverageDemo {
    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Kuda", 65),
            new Student("Ada", 85),
            new Student("Lynn", 75),
            new Student("Rudo", 55)
        );

        // EXPLAIN: calculate the average of all students' marks.
        double average = students.stream()
                .mapToDouble(Student::marks)
                .average()
                .orElse(0);

        System.out.printf("Class average: %.2f%n", average);

        // EXPLAIN: keep marks above average, sort names alphabetically, then print.
        students.stream()
                .filter(student -> student.marks() > average)
                .sorted(Comparator.comparing(Student::name))
                .map(Student::name)
                .forEach(System.out::println);
    }
}


