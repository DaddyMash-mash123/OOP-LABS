import java.time.LocalDate;

// EXPLAIN: Loan stores the item, member, borrowing date, due date,
// and return date for a borrowing transaction.
public class Loan {

    private final LibraryItem item;
    private final Member member;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;

    // EXPLAIN: Create a new loan using today's date and the item's loan period.
    public Loan(LibraryItem item, Member member) {
        this(item, member, LocalDate.now(),
                LocalDate.now().plusDays(item.loanPeriodDays()), null);
    }

    // EXPLAIN: This constructor restores the original dates from saved CSV data.
    public Loan(LibraryItem item, Member member,
                LocalDate borrowDate, LocalDate dueDate,
                LocalDate returnDate) {

        if (item == null || member == null
                || borrowDate == null || dueDate == null) {
            throw new IllegalArgumentException("Loan details cannot be null");
        }

        this.item = item;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public LibraryItem getItem() {
        return item;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    // EXPLAIN: A loan is overdue when it has not been returned
    // and its due date is earlier than today's date.
    public boolean isOverdue() {
        return !isReturned() && LocalDate.now().isAfter(dueDate);
    }

    public void markReturned() {
        // EXPLAIN: Do not overwrite the original return date.
        if (!isReturned()) {
            returnDate = LocalDate.now();
        }
    }

    @Override
    public String toString() {
        return item.getTitle()
                + " | Member: " + member.getName()
                + " | Borrowed: " + borrowDate
                + " | Due: " + dueDate
                + " | Status: " + (isReturned() ? "Returned" : "On loan");
    }
}
