abstract class Payment {
    // EXPLAIN: Every payment type must provide its own process() method.
    abstract void process();
}

class CardPayment extends Payment {
    @Override
    void process() {
        // EXPLAIN: CardPayment defines its own processing behaviour.
        System.out.println("Processing card payment");
    }
}

class MobileMoneyPayment extends Payment {
    @Override
    void process() {
        // EXPLAIN: MobileMoneyPayment defines its own processing behaviour.
        System.out.println("Processing mobile money payment");
    }
}

class PaymentProcessor {
    public void pay(Payment payment) {
        // EXPLAIN: Dynamic dispatch selects the correct implementation.
        payment.process();
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        // EXPLAIN: The processor works with the common Payment type.
        PaymentProcessor processor = new PaymentProcessor();

        processor.pay(new CardPayment());
        processor.pay(new MobileMoneyPayment());
    }
}


