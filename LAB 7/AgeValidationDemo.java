
public class AgeValidationDemo {

    // EXPLAIN: throws declares that this method may pass a checked exception to its caller.
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            // EXPLAIN: throw creates an exception when the age is outside the valid range.
            throw new InvalidAgeException("Age must be between 0 and 120.");
        }

        System.out.println("Valid age: " + age);
    }

    public static void main(String[] args) {
        int[] ages = {25, -4, 130};

        for (int age : ages) {
            try {
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Invalid age: " + e.getMessage());
            }
        }
    }
}
