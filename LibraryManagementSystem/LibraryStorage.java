import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// EXPLAIN: This class handles saving and loading library data using CSV files.
public class LibraryStorage {

    private static final Path ITEMS_FILE = Path.of("items.csv");
    private static final Path MEMBERS_FILE = Path.of("members.csv");
    private static final Path LOANS_FILE = Path.of("loans.csv");

    // EXPLAIN: Save items, members, and loans separately for easier management.
    public static void save(Library library) throws IOException {
        List<String> itemLines = new ArrayList<>();
        itemLines.add("type,id,title,author");

        for (LibraryItem item : library.getAllItems()) {
            String type;
            String author = "";

            if (item instanceof Book book) {
                type = "BOOK";
                author = book.getAuthor();
            } else if (item instanceof Dvd) {
                type = "DVD";
            } else {
                continue;
            }

            itemLines.add(csv(type, item.getId(), item.getTitle(), author));
        }

        List<String> memberLines = new ArrayList<>();
        memberLines.add("id,name");

        for (Member member : library.getAllMembers()) {
            memberLines.add(csv(member.getId(), member.getName()));
        }

        List<String> loanLines = new ArrayList<>();
        loanLines.add("itemId,memberId,borrowDate,dueDate,returnDate");

        for (Loan loan : library.getAllLoans()) {
            String returnDate = loan.getReturnDate() == null
                    ? ""
                    : loan.getReturnDate().toString();

            loanLines.add(csv(
                    loan.getItem().getId(),
                    loan.getMember().getId(),
                    loan.getBorrowDate().toString(),
                    loan.getDueDate().toString(),
                    returnDate
            ));
        }

        // EXPLAIN: UTF-8 preserves names and titles containing non-ASCII characters.
        Files.write(ITEMS_FILE, itemLines, StandardCharsets.UTF_8);
        Files.write(MEMBERS_FILE, memberLines, StandardCharsets.UTF_8);
        Files.write(LOANS_FILE, loanLines, StandardCharsets.UTF_8);
    }

    // EXPLAIN: Load items and members first, then loans that refer to them.
    public static Library load() throws IOException {
        Library library = new Library();

        if (Files.exists(ITEMS_FILE)) {
            List<String> lines = Files.readAllLines(
                    ITEMS_FILE, StandardCharsets.UTF_8);

            for (int i = 1; i < lines.size(); i++) {
                if (lines.get(i).isBlank()) {
                    continue;
                }

                List<String> fields = parseCsv(lines.get(i));

                String type = fields.get(0);
                String id = fields.get(1);
                String title = fields.get(2);

                if (type.equals("BOOK")) {
                    library.addItem(new Book(id, title, fields.get(3)));
                } else if (type.equals("DVD")) {
                    library.addItem(new Dvd(id, title));
                }
            }
        }

        if (Files.exists(MEMBERS_FILE)) {
            List<String> lines = Files.readAllLines(
                    MEMBERS_FILE, StandardCharsets.UTF_8);

            for (int i = 1; i < lines.size(); i++) {
                if (lines.get(i).isBlank()) {
                    continue;
                }

                List<String> fields = parseCsv(lines.get(i));
                library.registerMember(
                        new Member(fields.get(0), fields.get(1)));
            }
        }

        if (Files.exists(LOANS_FILE)) {
            List<String> lines = Files.readAllLines(
                    LOANS_FILE, StandardCharsets.UTF_8);

            for (int i = 1; i < lines.size(); i++) {
                if (lines.get(i).isBlank()) {
                    continue;
                }

                List<String> fields = parseCsv(lines.get(i));

                LibraryItem item = library.getAllItems().stream()
                        .filter(x -> x.getId().equals(fields.get(0)))
                        .findFirst()
                        .orElseThrow(() -> new IOException(
                                "Loan refers to missing item: " + fields.get(0)));

                Member member = library.getAllMembers().stream()
                        .filter(x -> x.getId().equals(fields.get(1)))
                        .findFirst()
                        .orElseThrow(() -> new IOException(
                                "Loan refers to missing member: " + fields.get(1)));

                LocalDate borrowDate = LocalDate.parse(fields.get(2));
                LocalDate dueDate = LocalDate.parse(fields.get(3));

                LocalDate returnDate = fields.get(4).isBlank()
                        ? null
                        : LocalDate.parse(fields.get(4));

                // EXPLAIN: Restore the loan dates and reconnect the loan to its records.
                Loan loan = new Loan(
                        item, member, borrowDate, dueDate, returnDate);

                library.restoreLoan(loan);
            }
        }

        return library;
    }

    // EXPLAIN: Quote fields containing commas, quotation marks, or line breaks.
    private static String csv(String... fields) {
        List<String> escaped = new ArrayList<>();

        for (String field : fields) {
            String safe = field == null ? "" : field;
            safe = "\"" + safe.replace("\"", "\"\"") + "\"";
            escaped.add(safe);
        }

        return String.join(",", escaped);
    }

    // EXPLAIN: Parse CSV fields while respecting quoted commas and escaped quotes.
    private static List<String> parseCsv(String line) throws IOException {
        List<String> fields = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                if (inQuotes && i + 1 < line.length()
                        && line.charAt(i + 1) == '"') {
                    field.append('"');
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (c == ',' && !inQuotes) {
                fields.add(field.toString());
                field.setLength(0);
            } else {
                field.append(c);
            }
        }

        if (inQuotes) {
            throw new IOException("Invalid CSV row: unmatched quotation mark");
        }

        fields.add(field.toString());
        return fields;
    }
}
