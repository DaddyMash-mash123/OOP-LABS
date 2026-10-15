abstract class Account {
    protected double balance;
    Account(double balance) {
        // EXPLAIN: An abstract class can have a constructor to initialise shared state.
        this.balance = balance;
    }

    public void deposit(double amount) {
        // EXPLAIN: Only positive amounts are accepted as deposits.
        if (amount > 0) {
            balance += amount;
        }
    }

    // EXPLAIN: Each concrete account type must define its monthly fee.
    public abstract double monthlyFee();
    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    SavingsAccount(double balance) {
        // EXPLAIN: Initialise the inherited balance through the superclass constructor.
        super(balance);
    }
    @Override
    public double monthlyFee() {
        return 2.00;
    }
}

class CurrentAccount extends Account {
    CurrentAccount(double balance) {
        super(balance);
    }
    @Override
    public double monthlyFee() {
        return 5.00;
    }
}

public class AccountDemo {
    public static void main(String[] args) {
        // EXPLAIN: Account references can point to concrete subclass objects.
        Account savings = new SavingsAccount(100);
        Account current = new CurrentAccount(200);

        // EXPLAIN: Both account types reuse the inherited deposit() method.
        savings.deposit(50);
        current.deposit(30);

        // EXPLAIN: Each object uses its own monthlyFee() implementation.
        System.out.printf("Savings balance: %.2f, fee: %.2f%n",
            savings.getBalance(), savings.monthlyFee());
        System.out.printf("Current balance: %.2f, fee: %.2f%n",
            current.getBalance(), current.monthlyFee());
    }
}



