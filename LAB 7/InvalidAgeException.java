
public class InvalidAgeException extends Exception {

    // EXPLAIN: Extending Exception makes this a checked exception.
    public InvalidAgeException(String message) {
        super(message);
    }
}
