import java.util.Arrays;

public class BubbleSortDemo {

    // EXPLAIN: Comparable lets the generic method compare elements of type T.
    static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                // EXPLAIN: Swap adjacent elements when they are out of order.
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // EXPLAIN: Stop early when a pass makes no swaps.
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        // EXPLAIN: Demonstrate bubble sort with both integers and strings.
        Integer[] numbers = {5, 2, 9, 1, 6};
        String[] names = {"Zara", "Alice", "Kuda", "Ben"};

        bubbleSort(numbers);
        bubbleSort(names);

        System.out.println("Sorted integers: " + Arrays.toString(numbers));
        System.out.println("Sorted strings: " + Arrays.toString(names));
    }
}

