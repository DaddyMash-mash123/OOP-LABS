public class BankDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("A101", "Tariro", 500.0);

        try {
            account.withdraw(100.0);
            System.out.println("Balance now: " + account.getBalance());

            account.withdraw(5000.0);
        } catch (InsufficientFundsException e) {
            // EXPLAIN: catch handles the failed withdrawal and displays the shortfall.
            System.out.println(e.getMessage());
            System.out.println("Short by: " + e.getShortfall());
        }
    }
}

