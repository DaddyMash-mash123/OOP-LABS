abstract class Shape {
    // EXPLAIN: An abstract class cannot be instantiated directly.
    // Its subclasses must implement these abstract methods.
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shape {
    private final double radius;
    Circle(double radius) {
        // EXPLAIN: Store the radius needed for both calculations.
        this.radius = radius;
    }
    @Override
    double area() {
        // EXPLAIN: Calculate the area of a circle using pi times radius squared.
        return Math.PI * radius * radius;
    }
    @Override
    double perimeter() {
        // EXPLAIN: Calculate the circumference using 2 times pi times radius.
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private final double length;
    private final double width;
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    double area() {
        // EXPLAIN: Rectangle area equals length multiplied by width.
        return length * width;
    }
    @Override
    double perimeter() {
        // EXPLAIN: Add the length and width, then multiply by two.
        return 2 * (length + width);
    }
}

class Square extends Shape {
    private final double side;
    Square(double side) {
        this.side = side;
    }
    @Override
    double area() {
        // EXPLAIN: A square's area is its side multiplied by itself.
        return side * side;
    }
    @Override
    double perimeter() {
        // EXPLAIN: A square has four equal sides.
        return 4 * side;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        // EXPLAIN: Store different concrete shapes using the Shape superclass type.
        Shape[] shapes = {
            new Circle(3),
            new Rectangle(4, 5),
            new Square(4)
        };
        // EXPLAIN: Polymorphism calls the correct methods for each actual shape.
        for (Shape shape : shapes) {
            System.out.printf("Area: %.2f, Perimeter: %.2f%n",
                shape.area(), shape.perimeter());
        }
    }
}
