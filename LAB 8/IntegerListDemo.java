import java.util.ArrayList;
import java.util.Collections;

public class IntegerListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        // EXPLAIN: Add ten integers to the ArrayList.
        Collections.addAll(numbers, 12, 5, 8, 21, 3, 17, 9, 14, 6, 10);

        int sum = 0;
        int maximum = numbers.get(0);

        for (int number : numbers) {
            sum += number;

            // EXPLAIN: Track the largest number while visiting each element.
            if (number > maximum) {
                maximum = number;
            }
        }

        System.out.println("Numbers: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Maximum: " + maximum);

        // EXPLAIN: Reverse changes the order of the existing list.
        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);
    }
}


