import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Learner(String name, int roll, double gpa) {
    // EXPLAIN: convert one CSV line into a Learner object.
    static Learner fromCsv(String line) {
        String[] parts = line.split(",");
        return new Learner(
            parts[0].trim(),
            Integer.parseInt(parts[1].trim()),
            Double.parseDouble(parts[2].trim())
        );
    }

    String toCsv() {
        return name + "," + roll + "," + gpa;
    }
}

public class LearnerReportDemo {

    // EXPLAIN: assign each learner to a grade band using GPA.
    static String gradeBand(Learner learner) {
        if (learner.gpa() >= 3.5) return "A";
        if (learner.gpa() >= 2.5) return "B";
        return "C";
    }

    public static void main(String[] args) {
        Path inputFile = Path.of("learners.csv");

        try {
            // EXPLAIN: read each CSV row and convert it to a Learner.
            List<Learner> learners = Files.readAllLines(inputFile)
                    .stream()
                    .filter(line -> !line.isBlank())
                    .map(Learner::fromCsv)
                    .toList();

            // EXPLAIN: group learners by the grade band returned for each one.
            Map<String, List<Learner>> groups = learners.stream()
                    .collect(Collectors.groupingBy(
                        LearnerReportDemo::gradeBand
                    ));

            // EXPLAIN: write a separate CSV report for each non-empty band.
            for (String band : List.of("A", "B", "C")) {
                List<Learner> group = groups.getOrDefault(band, List.of());

                List<String> reportLines = group.stream()
                        .map(Learner::toCsv)
                        .toList();

                Files.write(
                    Path.of("grade_" + band + "_report.csv"),
                    reportLines
                );

                System.out.println(
                    "Grade " + band + " report: " + group.size() + " learner(s)"
                );
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid CSV data: " + e.getMessage());
        }
    }
}


