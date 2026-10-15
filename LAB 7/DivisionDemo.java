import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first integer: ");
            int first = scanner.nextInt();

            System.out.print("Enter second integer: ");
            int second = scanner.nextInt();

            // EXPLAIN: Division by zero is handled separately from invalid input.
            System.out.println(first + " / " + second + " = " + (first / second));

        } catch (InputMismatchException e) {
            // EXPLAIN: nextInt() throws this exception if the input is not an integer.
            System.out.println("Invalid input. Please enter integers only.");
        } catch (ArithmeticException e) {
            // EXPLAIN: Integer division by zero throws ArithmeticException.
            System.out.println("Math problem: " + e.getMessage());
        } finally {
            // EXPLAIN: finally executes whether an exception occurs or not.
            scanner.close();
            System.out.println("finally always runs");
        }
    }
}


