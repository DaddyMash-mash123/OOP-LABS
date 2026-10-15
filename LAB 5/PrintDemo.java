import java.util.Arrays;

public class PrintDemo {

    // EXPLAIN: This overload accepts an integer.
    static void print(int value) {
        System.out.println("Integer: " + value);
    }

    // EXPLAIN: This overload accepts a decimal number.
    static void print(double value) {
        System.out.println("Double: " + value);
    }

    // EXPLAIN: This overload accepts a String.
    static void print(String value) {
        System.out.println("String: " + value);
    }

    // EXPLAIN: This overload accepts an array of integers.
    static void print(int[] values) {
        System.out.println("Array: " + Arrays.toString(values));
    }

    public static void main(String[] args) {
        // EXPLAIN: The compiler selects an overload from the argument type.
        print(25);
        print(12.5);
        print("Java");
        print(new int[]{1, 2, 3});
    }
}

