// SINGLETON
class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();
    private final String institution = "Example University";

    // EXPLAIN: A private constructor prevents other classes from creating instances directly.
    private AppConfig() {
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public String getInstitution() {
        return institution;
    }
}

// FACTORY 
interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}
/* EXPLAIN: The factory pattern allows for the creation of different 
notification types without exposing the instantiation logic to the client*/
class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

class NotificationFactory {
    // EXPLAIN: The factory returns the interface type, hiding the concrete class from callers.
    static Notification create(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SmsNotification();
            default -> throw new IllegalArgumentException(
                "Unknown type: " + type
            );
        };
    }
}

public class SingletonFactoryDemo {
    public static void main(String[] args) {
        // EXPLAIN: The singleton ensures that only one instance of AppConfig exists.
        AppConfig a = AppConfig.getInstance(); 
        AppConfig b = AppConfig.getInstance();

        System.out.println(
            "Same instance? " + (a == b) + " -> " + a.getInstitution()
        );
        // EXPLAIN: The factory creates different types of notifications based on the input type.
        NotificationFactory.create("email").send("Lab 11 is open");
        NotificationFactory.create("SMS").send("Lab 11 is open");
    }
}


