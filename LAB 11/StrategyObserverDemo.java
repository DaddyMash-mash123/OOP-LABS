import java.util.ArrayList;
import java.util.List;

// STRATEGY PATTERN
interface DiscountStrategy {
    double apply(double price);
}

class Checkout {
    private DiscountStrategy strategy;

    Checkout(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    // EXPLAIN: Allows the discount strategy to change at runtime.
    void setStrategy(DiscountStrategy s) {
        this.strategy = s;
    }

    double total(double price) {
        return strategy.apply(price);
    }
}

// OBSERVER PATTERN
interface GradeListener {
    void onGradePublished(String course, int mark);
}

class GradeBook {
    private final List<GradeListener> listeners = new ArrayList<>();

    void subscribe(GradeListener listener) {
        listeners.add(listener);
    }

    void publish(String course, int mark) {
        // EXPLAIN: Every subscribed listener receives the published grade.
        for (GradeListener listener : listeners) {
            listener.onGradePublished(course, mark);
        }
    }
}

public class StrategyObserverDemo {
    public static void main(String[] args) {

        // Strategy: regular checkout, with no discount.
        Checkout checkout = new Checkout(price -> price);
        System.out.println("Regular: " + checkout.total(200));

        // EXPLAIN: Replace the strategy with a 10% student discount.
        checkout.setStrategy(price -> price * 0.90);
        System.out.println("Student: " + checkout.total(200));

        // Observer: register listeners for published grades.
        GradeBook book = new GradeBook();

        book.subscribe((course, mark) ->
            System.out.println("Student portal: " + course + " = " + mark)
        );

        book.subscribe((course, mark) -> {
            if (mark < 50) {
                System.out.println("Advisor alert: " + course + " failed");
            }
        });

        book.publish("OOP", 72);
        book.publish("Databases", 45);
    }
}
