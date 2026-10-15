// EXPLAIN: Book inherits the shared fields and behaviour from LibraryItem.
public class Book extends LibraryItem {

    private final String author;

    public Book(String id, String title, String author) {
        // EXPLAIN: Initialise the common item details using the parent constructor.
        super(id, title);

        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }

        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int loanPeriodDays() {
        // EXPLAIN: Books may be borrowed for 14 days.
        return 14;
    }

    @Override
    public void borrow(Member member) {
        // EXPLAIN: Mark the book as unavailable after it is borrowed.
        setAvailable(false);
    }

    @Override
    public void giveBack() {
        // EXPLAIN: Make the book available again after its return.
        setAvailable(true);
    }

    @Override
    public String toString() {
        // EXPLAIN: Extend the parent's description with the author's name.
        return super.toString() + " - Author: " + author;
    }
}
