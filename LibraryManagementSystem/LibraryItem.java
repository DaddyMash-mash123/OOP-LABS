// EXPLAIN: This abstract class contains the common features of
// library items, such as books and DVDs.
public abstract class LibraryItem implements Borrowable {

    private final String id;
    private final String title;
    private boolean available = true;

    // EXPLAIN: Every item must have a valid ID and title.
    protected LibraryItem(String id, String title) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        this.id = id;
        this.title = title;
    }

    // EXPLAIN: Getters allow other classes to access private fields safely.
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    // EXPLAIN: Package-private method lets library classes update availability.
    void setAvailable(boolean available) {
        this.available = available;
    }

    // EXPLAIN: Each subclass supplies its own borrowing period.
    public abstract int loanPeriodDays();

    @Override
    public String toString() {
        // EXPLAIN: Show the item's ID, title, and current availability.
        return id + " - " + title + " - "
                + (available ? "Available" : "Borrowed");
    }
}
