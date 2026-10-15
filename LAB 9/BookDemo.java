import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    private final String isbn;
    private final String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    // EXPLAIN: Two books are equal when their ISBN values are equal.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book other)) {
            return false;
        }
        return Objects.equals(isbn, other.isbn);
    }

    // EXPLAIN: Equal books must return the same hash code for HashSet to work correctly.
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Book[ISBN=" + isbn + ", title=" + title + "]";
    }
}

public class BookDemo {
    public static void main(String[] args) {
        Book first = new Book("978-111", "Java Basics");
        Book second = new Book("978-111", "Java Programming");
        Book third = new Book("978-222", "OOP in Java");

        Set<Book> books = new HashSet<>();

        // EXPLAIN: HashSet uses equals() and hashCode() to identify duplicates.
        books.add(first);
        books.add(second);
        books.add(third);

        System.out.println("Set size: " + books.size());
        System.out.println(books.contains(second));
    }
}


