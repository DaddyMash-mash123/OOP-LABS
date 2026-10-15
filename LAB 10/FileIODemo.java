import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIODemo {
    public static void main(String[] args) {
        Path file = Path.of("lines.txt");
        List<String> lines = new ArrayList<>();

        try (Scanner input = new Scanner(System.in)) {
            for (int i = 1; i <= 5; i++) {
                System.out.print("Enter line " + i + ": ");
                lines.add(input.nextLine());
            }

            // EXPLAIN: write all five lines to the file.
            Files.write(file, lines);

            // EXPLAIN: read the saved lines back from the same file.
            List<String> savedLines = Files.readAllLines(file);
            System.out.println("\nLines read from file:");

            for (String line : savedLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
