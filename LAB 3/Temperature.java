public class Temperature {
    // EXPLAIN: Store temperature internally in Kelvin.
    private final double kelvin;
    // EXPLAIN: The constructor rejects temperatures below absolute zero.
    public Temperature(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException(
                "Temperature cannot be below absolute zero"
            );
        }
        this.kelvin = kelvin;
    }
    // EXPLAIN: Convert Kelvin to Celsius when requested.
    public double getCelsius() {
        return kelvin - 273.15;
    }
    // EXPLAIN: Convert Kelvin to Fahrenheit when requested.
    public double getFahrenheit() {
        return (kelvin - 273.15) * 9.0 / 5.0 + 32;
    }
    public static void main(String[] args) {
        // EXPLAIN: Create a temperature of 300 Kelvin.
        Temperature temperature = new Temperature(300);

        // EXPLAIN: Callers use the public methods instead of accessing
        // the private Kelvin field directly.
        System.out.printf("Celsius: %.2f%n", temperature.getCelsius());
        System.out.printf("Fahrenheit: %.2f%n",
                          temperature.getFahrenheit());

        // EXPLAIN: Attempting to create a negative Kelvin value is rejected.
        try {
            Temperature invalid = new Temperature(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

