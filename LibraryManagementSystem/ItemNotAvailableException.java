// EXPLAIN: This checked exception is used when someone tries to borrow
// an item that is already on loan.
public class ItemNotAvailableException extends Exception {

    public ItemNotAvailableException(String message) {
        super(message);
    }
}
