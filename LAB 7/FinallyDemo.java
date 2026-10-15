public class FinallyDemo {
    
    static int calculate() {
        try {
            // EXPLAIN: The method prepares to return the value 10.
            return 10;
        } finally {
            // EXPLAIN: finally executes before the method completes its return.
            System.out.println("Finally block executed");
        }
    }

    public static void main(String[] args) {
        int result = calculate();
        System.out.println("Returned value: " + result);
    }
}

