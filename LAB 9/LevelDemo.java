enum Level {
    LOW, MEDIUM, HIGH
}

public class LevelDemo {
    public static void main(String[] args) {
        // EXPLAIN: values() returns every constant declared in the enum.
        for (Level level : Level.values()) {
            switch (level) {
                case LOW:
                    System.out.println("LOW: Take your time.");
                    break;
                case MEDIUM:
                    System.out.println("MEDIUM: Stay alert.");
                    break;
                case HIGH:
                    System.out.println("HIGH: Act immediately.");
                    break;
            }
        }
    }
}

