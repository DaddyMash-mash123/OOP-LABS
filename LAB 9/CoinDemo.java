enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    private final int value;

    Coin(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    // EXPLAIN: Greedy selection uses the largest available coin first.
    public static int fewestCoins(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                "Amount cannot be negative");
        }

        int count = 0;

        for (Coin coin : values()) {
            count += amount / coin.value; // Count of coins of this denomination

            amount %= coin.value;
        }

        return count;
    }
}
// EXPLAIN: The CoinDemo class demonstrates the fewestCoins() method.
public class CoinDemo {
    public static void main(String[] args) {
        int amount = 41;
        // EXPLAIN: The method returns the minimum number of coins for this amount.
        System.out.println(
            "Fewest coins for " + amount + " cents: "
            + Coin.fewestCoins(amount)
        );
    }
}


