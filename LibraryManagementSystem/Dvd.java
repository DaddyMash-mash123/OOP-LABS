// EXPLAIN: DVD is another type of LibraryItem, but has its own loan period.
public class Dvd extends LibraryItem {

    public Dvd(String id, String title) {
        // EXPLAIN: Reuse the validation and initialisation in LibraryItem.
        super(id, title);
    }

    @Override
    public int loanPeriodDays() {
        // EXPLAIN: DVDs have a shorter borrowing period of 7 days.
        return 7;
    }

    @Override
    public void borrow(Member member) {
        // EXPLAIN: Mark the DVD as unavailable when borrowed.
        setAvailable(false);
    }

    @Override
    public void giveBack() {
        // EXPLAIN: Make the DVD available again when returned.
        setAvailable(true);
    }
}
