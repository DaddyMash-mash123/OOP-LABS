
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueNamesDemo {
    public static void main(String[] args) {
        // EXPLAIN: The original list contains duplicate names.
        var names = Arrays.asList(
            "Tariro", "Kuda", "Tariro", "Rudo", "Kuda", "Nyasha"
        );

        // EXPLAIN: LinkedHashSet removes duplicates and preserves insertion order.
        Set<String> uniqueNames = new LinkedHashSet<>(names);

        System.out.println("Original names: " + names);
        System.out.println("Unique names: " + uniqueNames);
    }
}
