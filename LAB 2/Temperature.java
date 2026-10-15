public class Temperature {
    private final double celsius;

    // EXPLAIN: private prevents objects from being constructed directly outside this class
    private Temperature(double celsius) {
        this.celsius = celsius;
    }

    public static Temperature fromCelsius(double celsius) {
        // EXPLAIN: the factory method creates and returns a Temperature object
        return new Temperature(celsius);
    }

    public static Temperature fromFahrenheit(double fahrenheit) {
        // EXPLAIN: convert Fahrenheit to Celsius before constructing the object
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        return new Temperature(celsius);
    }

    // EXPLAIN: return the temperature in Celsius
    public double getCelsius() {
        return celsius;
    }

    // EXPLAIN: convert Celsius to Fahrenheit when requested
    public double getFahrenheit() {
        return celsius * 9.0 / 5.0 + 32;
    }
    public static void main(String[] args) {
        // EXPLAIN: Create Temperature objects using the factory methods
        Temperature t1 = Temperature.fromCelsius(25.0);
        Temperature t2 = Temperature.fromFahrenheit(68.0);
        // EXPLAIN: Display the temperatures in both Celsius and Fahrenheit
        System.out.println(t1.getCelsius());
        System.out.println(t1.getFahrenheit());
        System.out.println(t2.getCelsius());
    }
}
