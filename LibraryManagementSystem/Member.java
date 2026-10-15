import java.util.ArrayList;
import java.util.List;

// EXPLAIN: Member represents a person registered to borrow library items.
public class Member {

    private final String id;
    private final String name;

    // EXPLAIN: Keep track of the loans belonging to this member.
    private final List<Loan> loans = new ArrayList<>();

    public Member(String id, String name) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Member ID cannot be empty");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Member name cannot be empty");
        }
        
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // EXPLAIN: Return the member's loans so the library can check borrowing limits.
    public List<Loan> getLoans() {
        return List.copyOf(loans);
    }

    // EXPLAIN: Only active loans count toward the maximum of three items.
    public long getActiveLoanCount() {
        return loans.stream()
                .filter(loan -> !loan.isReturned())
                .count();
    }

    // EXPLAIN: Record a new loan when this member borrows an item.
    void addLoan(Loan loan) {
        loans.add(loan);
    }

    @Override
    public String toString() {
        return id + " - " + name
                + " (Active loans: " + getActiveLoanCount() + ")";
    }
}
