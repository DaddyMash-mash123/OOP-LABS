import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a paragraph:");
        String paragraph = scanner.nextLine().toLowerCase();

        // EXPLAIN: Split the paragraph into words and remove basic punctuation.
        String[] words = paragraph.split("[^a-z0-9']+");

        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                // EXPLAIN: Merge increments the count for each repeated word.
                frequency.merge(word, 1, Integer::sum);
            }
        }

        // EXPLAIN: Sort entries by frequency from highest to lowest.
        List<Map.Entry<String, Integer>> entries =
            new ArrayList<>(frequency.entrySet());

        entries.sort(
            Map.Entry.<String, Integer>comparingByValue(
                Comparator.reverseOrder()
            ).thenComparing(Map.Entry.comparingByKey())
        );

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}


