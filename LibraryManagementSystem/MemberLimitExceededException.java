// EXPLAIN: This checked exception prevents a member from borrowing
// more items than the library's allowed limit.
public class MemberLimitExceededException extends Exception {

    public MemberLimitExceededException(String message) {
        super(message);
    }
}
