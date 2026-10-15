public class Rectangle {    
    // Explain: These fields store the dimensions of the rectangle
    double height;
    double width;

    /* Explain: This is the constructor for the Rectangle class.
    It initializes the height and width fields with the provided values */
    public Rectangle(double height, double width) {
        /* Explain: The 'this' keyword is used to refer to the current object's fields
        so that we can distinguish between the constructor parameters and the object's fields.*/
        this.height = height;
        this.width = width;
    }
    // Explain: This method calculates the area of the rectangle
    public double calculateArea() {
        return height * width;
    }
    // Explain: This method calculates the perimeter of the rectangle
    public double calculatePerimeter() {
        return 2 * (height + width);
    }
    public static void main(String args[]){
        /* Explain: Creating an array of Rectangle objects 
        which will store 5 Rectangle instances */
        Rectangle[] rectangles = new Rectangle[5];
        // Explain: Initializing the Rectangle objects with different dimensions
        rectangles[0] = new Rectangle(4, 5);
        rectangles[1] = new Rectangle(6, 8);
        rectangles[2] = new Rectangle(10, 3);
        rectangles[3] = new Rectangle(7, 7);
        rectangles[4] = new Rectangle(12, 9);
        
        // EXPLAIN: at first i assumed that the first rectangle has the largest area.
        Rectangle largest = rectangles[0];
        // EXPLAIN: Check the remaining rectangles to find the largest area.
            for (int i = 1; i < rectangles.length; i++) {
                if (rectangles[i].calculateArea() > largest.calculateArea()) {
                    // EXPLAIN: Update largest when a bigger area is found.
                    largest = rectangles[i];
                }
            }
            // EXPLAIN: Display the area and perimeter of every rectangle.
            for (int i = 0; i < rectangles.length; i++) {
            System.out.println("Rectangle " + (i + 1)
                    + ": Width = " + rectangles[i].width
                    + ", Height = " + rectangles[i].height
                    + ", Area = " + rectangles[i].calculateArea()
                    + ", Perimeter = " + rectangles[i].calculatePerimeter());
            }
            // EXPLAIN: Print the rectangle with the largest area
            System.out.println("\nRectangle with the largest area:");
            System.out.println("Width: " + largest.width);
            System.out.println("Height: " + largest.height );
            System.out.println("Area: " + largest.calculateArea());
    }
}

class RectangleAliasDemo {
    

    public static void main(String[] args) {

        // EXPLAIN: Create a Rectangle object and store its reference in r1.
        Rectangle r1 = new Rectangle(5, 10);

        // EXPLAIN: Copy the reference, so r1 and r2 refer to the same object.
        Rectangle r2 = r1;

        // EXPLAIN: Change the width of the shared Rectangle object.
        r2.width = 20;

        // EXPLAIN: Print the width through r1 to demonstrate aliasing.
        System.out.println("Width of r1: " + r1.width);
    }
}