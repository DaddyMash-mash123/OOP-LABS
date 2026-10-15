import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextFileStats {
    public static void main(String[] args) {
        Path file = Path.of("sample.txt");

        try {
            // EXPLAIN: read the file as a list of lines.
            List<String> lines = Files.readAllLines(file);

            long words = 0;
            long characters = 0;

            for (String line : lines) {
                // EXPLAIN: count characters in each line, excluding line breaks.
                characters += line.length();

                // EXPLAIN: split on whitespace and ignore empty lines.
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    words += trimmed.split("\\s+").length;
                }
            }

            System.out.println("Lines: " + lines.size());
            System.out.println("Words: " + words);
            System.out.println("Characters: " + characters);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}

