import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveEvenDemo {
    public static void main(String[] args) {
        List<Integer> numbers =
                new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // EXPLAIN: this predicate is true for even numbers.
        Predicate<Integer> isEven = number -> number % 2 == 0;

        // EXPLAIN: removeIf deletes each element that matches the predicate.
        numbers.removeIf(isEven);

        System.out.println("After removing even numbers: " + numbers);
    }
}

