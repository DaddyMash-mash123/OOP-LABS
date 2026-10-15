// EXPLAIN: This interface defines the actions that any borrowable
// library item must support.
public interface Borrowable {

    // EXPLAIN: Called when a member borrows an item.
    void borrow(Member member);

    // EXPLAIN: Called when an item is returned to the library.
    void giveBack();
}
