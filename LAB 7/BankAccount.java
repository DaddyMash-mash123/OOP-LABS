public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName,
                       double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException(
                "Opening balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        setOwnerName(ownerName);
        this.balance = openingBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.ownerName = ownerName.trim();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    // EXPLAIN: throws declares that withdrawal may produce a checked exception.
    public void withdraw(double amount)
            throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal must be positive");
        }

        if (amount > balance) {
            // EXPLAIN: throw reports insufficient funds without changing the balance.
            throw new InsufficientFundsException(
                "Insufficient funds for withdrawal",
                amount - balance);
        }

        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber
            + ", Owner: " + ownerName
            + ", Balance: " + balance;
    }
}


