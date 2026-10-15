public class Circle {
    // EXPLAIN: static means there is one shared counter for the class, not one per Circle
    private static int count = 0;

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        count++; // EXPLAIN: each constructed Circle increases the shared counter
    }

    public Circle() {
        this(1.0);
    }

    // EXPLAIN: a static method can access static members directly without an object
    public static int getCount() {
        return count;
    }

    public double getRadius() {
        return radius;
    }

    public static void main(String[] args) {
        new Circle();
        new Circle(5.0);
        new Circle(2.5);

        System.out.println("Total circles: " + Circle.getCount());
    }
}

