import java.util.List;
import java.util.Scanner;
import java.io.IOException;

// EXPLAIN: This class contains the main method and the interactive menu.
public class LibraryManagementSystem {

    private static final Scanner scanner = new Scanner(System.in);

    // EXPLAIN: Load the library from CSV when the application starts.
private static Library library;

    public static void main(String[] args) {
        try {
            library = LibraryStorage.load();
            System.out.println("Library data loaded successfully.");
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Could not load library data: " + e.getMessage());
            return;
        }
        boolean running = true;

        // EXPLAIN: Keep displaying the menu until the user chooses to exit.
        while (running) {
            displayMenu();
            int choice = readInt("Choose an option: ");

            try {
                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> addDvd();
                    case 3 -> registerMember();
                    case 4 -> borrowItem();
                    case 5 -> returnItem();
                    case 6 -> listOverdueItems();
                    case 7 -> searchByTitle();
                    case 8 -> listItems();
                    case 9 -> listMembers();
                    case 10 -> listLoans();
                    case 0 -> {
                        running = false;
                        System.out.println("Exiting Library Management System.");
                    }
                    default -> System.out.println("Invalid menu option.");
                }
            } catch (ItemNotAvailableException
                     | MemberLimitExceededException e) {
                // EXPLAIN: Show meaningful messages for expected borrowing errors.
                System.out.println("Operation failed: " + e.getMessage());
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        // EXPLAIN: Save the latest records before closing the application.
        try {
            LibraryStorage.save(library);
            System.out.println("Library data saved successfully.");
        } catch (IOException e) {
            System.out.println("Could not save library data: " + e.getMessage());
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
        System.out.println("1. Add book");
        System.out.println("2. Add DVD");
        System.out.println("3. Register member");
        System.out.println("4. Borrow item");
        System.out.println("5. Return item");
        System.out.println("6. List overdue items");
        System.out.println("7. Search by title");
        System.out.println("8. List all items");
        System.out.println("9. List all members");
        System.out.println("10. List all loans");
        System.out.println("0. Exit");
    }

    private static void addBook() {
        String id = readText("Enter book ID: ");
        String title = readText("Enter book title: ");
        String author = readText("Enter author: ");

        // EXPLAIN: Book validates its details through its constructor.
        library.addItem(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    private static void addDvd() {
        String id = readText("Enter DVD ID: ");
        String title = readText("Enter DVD title: ");

        library.addItem(new Dvd(id, title));
        System.out.println("DVD added successfully.");
    }

    private static void registerMember() {
        String id = readText("Enter member ID: ");
        String name = readText("Enter member name: ");

        library.registerMember(new Member(id, name));
        System.out.println("Member registered successfully.");
    }

    private static void borrowItem()
            throws ItemNotAvailableException,
                   MemberLimitExceededException {

        String memberId = readText("Enter member ID: ");
        String itemId = readText("Enter item ID: ");

        // EXPLAIN: Library checks availability and the member's loan limit.
        library.borrow(memberId, itemId);
        System.out.println("Item borrowed successfully.");
    }

    private static void returnItem() {
        String itemId = readText("Enter item ID to return: ");

        library.giveBack(itemId);
        System.out.println("Item returned successfully.");
    }

    private static void listOverdueItems() {
        List<Loan> overdue = library.getOverdueLoans();

        if (overdue.isEmpty()) {
            System.out.println("There are no overdue items.");
            return;
        }

        // EXPLAIN: Display only loans whose due dates have passed.
        overdue.forEach(System.out::println);
    }

    private static void searchByTitle() {
        String query = readText("Enter title or part of title: ");
        List<LibraryItem> results = library.searchByTitle(query);

        if (results.isEmpty()) {
            System.out.println("No matching items found.");
            return;
        }

        results.forEach(System.out::println);
    }

    private static void listItems() {
        List<LibraryItem> items = library.getAllItems();

        if (items.isEmpty()) {
            System.out.println("No items registered.");
            return;
        }

        items.forEach(System.out::println);
    }

    private static void listMembers() {
        List<Member> members = library.getAllMembers();

        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }

        members.forEach(System.out::println);
    }

    private static void listLoans() {
        List<Loan> loans = library.getAllLoans();

        if (loans.isEmpty()) {
            System.out.println("No loans recorded.");
            return;
        }

        loans.forEach(System.out::println);
    }

    // EXPLAIN: Read text with surrounding spaces removed.
    private static String readText(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    // EXPLAIN: Validate numeric menu input instead of crashing on letters.
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }
}