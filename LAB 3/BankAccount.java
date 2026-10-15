import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    // EXPLAIN: Keep account data private to protect it from direct modification.
    private final String accountNumber;
    private String ownerName;
    private double balance;

    // EXPLAIN: Store transaction descriptions in a private list.
    private final List<String> transactions = new ArrayList<>();

    // EXPLAIN: Validate the opening balance and initialize the account.
    public BankAccount(String accountNumber, String ownerName,
                       double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException(
                "Opening balance cannot be negative"
            );
        }
        this.accountNumber = accountNumber;
        setOwnerName(ownerName);
        this.balance = openingBalance;

        // EXPLAIN: Record the initial account balance.
        transactions.add("Account opened with " + openingBalance);
    }
    // EXPLAIN: Return account information without exposing private fields.
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }
    public double getBalance() {
        return balance;
    }

    // EXPLAIN: Validate the owner's name before updating it.
    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.ownerName = ownerName.trim();
    }

    // EXPLAIN: Accept only positive deposit amounts and record each deposit.
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit must be positive"
            );
        }

        balance += amount;
        transactions.add("Deposited " + amount);
    }

    // EXPLAIN: Reject invalid withdrawals and withdrawals exceeding balance.
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal must be positive"
            );
        }

        if (amount > balance) {
            transactions.add("Failed withdrawal of " + amount);
            return false;
        }

        balance -= amount;
        transactions.add("Withdrew " + amount);
        return true;
    }

    // EXPLAIN: Return an independent, unmodifiable copy of the history.
    // Changes to the returned list cannot change the account's history.
    public List<String> getTransactions() {
        return Collections.unmodifiableList(
            new ArrayList<>(transactions)
        );
    }
    public static void main(String[] args) {
        // EXPLAIN: Create an account and perform transactions.
        BankAccount account =
            new BankAccount("ACC001", "Tariro", 500);

        account.deposit(200);
        account.withdraw(100);

        // EXPLAIN: Display the transaction history using the safe getter.
        for (String transaction : account.getTransactions()) {
            System.out.println(transaction);
        }

        // EXPLAIN: The returned list cannot be modified by the caller.
        try {
            account.getTransactions().clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("Transaction history is protected");
        }
    }
}
