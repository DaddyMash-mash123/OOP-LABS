import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// EXPLAIN: Library manages all items, registered members, and borrowing records.
public class Library {

    // EXPLAIN: Maps allow quick lookup of items and members using their IDs.
    private final Map<String, LibraryItem> items = new HashMap<>();
    private final Map<String, Member> members = new HashMap<>();

    // EXPLAIN: Store every loan so the library can track returns and overdue items.
    private final List<Loan> loans = new ArrayList<>();

    // EXPLAIN: Register an item only if its ID has not already been used.
    public void addItem(LibraryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException("Item ID already exists");
        }

        items.put(item.getId(), item);
    }

    // EXPLAIN: Register a member while preventing duplicate member IDs.
    public void registerMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }

        if (members.containsKey(member.getId())) {
            throw new IllegalArgumentException("Member ID already exists");
        }

        members.put(member.getId(), member);
    }

    // EXPLAIN: Borrowing checks that the member and item exist,
    // the item is available, and the member has fewer than three active loans.
    public void borrow(String memberId, String itemId)
            throws ItemNotAvailableException,
                   MemberLimitExceededException {

        Member member = members.get(memberId);
        LibraryItem item = items.get(itemId);

        if (member == null) {
            throw new IllegalArgumentException("Member not found: " + memberId);
        }

        if (item == null) {
            throw new IllegalArgumentException("Item not found: " + itemId);
        }

        if (!item.isAvailable()) {
            throw new ItemNotAvailableException(
                    "This item is already borrowed.");
        }

        if (member.getActiveLoanCount() >= 3) {
            throw new MemberLimitExceededException(
                    "A member cannot borrow more than three items.");
        }

        // EXPLAIN: Create the loan, update availability, and record the loan
        // with both the member and the library.
        Loan loan = new Loan(item, member);
        item.borrow(member);
        member.addLoan(loan);
        loans.add(loan);
    }

    // EXPLAIN: Return an item by finding its active loan record.
    public void giveBack(String itemId) {
        LibraryItem item = items.get(itemId);

        if (item == null) {
            throw new IllegalArgumentException("Item not found: " + itemId);
        }

        if (item.isAvailable()) {
            throw new IllegalArgumentException("This item is not currently borrowed");
        }

        // EXPLAIN: Mark the matching loan as returned and make the item available.
        for (Loan loan : loans) {
            if (loan.getItem().getId().equals(itemId) && !loan.isReturned()) {
                loan.markReturned();
                item.giveBack();
                return;
            }
        }

        throw new IllegalStateException("No active loan record was found");
    }

    // EXPLAIN: Return a copy of the items so callers cannot change the map directly.
    public List<LibraryItem> getAllItems() {
        return new ArrayList<>(items.values());
    }

    public List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    public List<Loan> getAllLoans() {
        return new ArrayList<>(loans);
    }

    // EXPLAIN: Use a stream to find titles containing the search text,
    // ignoring uppercase/lowercase differences and sorting by title.
    public List<LibraryItem> searchByTitle(String searchText) {
        if (searchText == null) {
            searchText = "";
        }

        String query = searchText.toLowerCase();

        return items.values().stream()
                .filter(item -> item.getTitle()
                        .toLowerCase().contains(query))
                .sorted(Comparator.comparing(LibraryItem::getTitle))
                .toList();
    }

    // EXPLAIN: Find loans that are currently overdue.
    public List<Loan> getOverdueLoans() {
        return loans.stream()
                .filter(Loan::isOverdue)
                .toList();
    }

    // EXPLAIN: Restore a saved loan and reconnect it to its item and member.
    public void restoreLoan(Loan loan) {
        if (loan == null) {
            throw new IllegalArgumentException("Loan cannot be null");
        }

        loans.add(loan);
        loan.getMember().addLoan(loan);

        // EXPLAIN: Only active loans should leave their items unavailable.
        if (!loan.isReturned()) {
            loan.getItem().setAvailable(false);
        }
    }

}
