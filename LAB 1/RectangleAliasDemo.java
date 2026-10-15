import java.awt.Rectangle;

public class RectangleAliasDemo {
    
     public static void main(String[] args) {

        // EXPLAIN: Create a Rectangle object and store its reference in r1.
        Rectangle r1 = new Rectangle();
        r1.height = 5; // EXPLAIN: Set the height of the rectangle to 5
        r1.width = 10; // EXPLAIN: Set the width of the rectangle to 10

        // EXPLAIN: Copy the reference, so r1 and r2 refer to the same object.
        Rectangle r2 = r1;

        // EXPLAIN: Change the width of the shared Rectangle object.
        r2.width = 20;

        // EXPLAIN: Print the width through r1 to demonstrate aliasing.
        System.out.println("Width of r1: " + r1.width);
    }
}
