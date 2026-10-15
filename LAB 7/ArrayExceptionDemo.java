public class ArrayExceptionDemo {

    // EXPLAIN: The method catches an exception when the requested index is invalid.
    static void displayElement(int[] numbers, int index) {
        try {
            System.out.println("Element: " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index: " + index);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        displayElement(numbers, 1);
        displayElement(numbers, 5);
    }
}

