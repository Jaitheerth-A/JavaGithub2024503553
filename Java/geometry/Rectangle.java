package geometry;

public class Rectangle {
    private double length;
    private double breadth;

    // Constructor
    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Method to calculate area
    public double area() {
        return length * breadth;
    }

    // Method to calculate perimeter
    public double perimeter() {
        return 2 * (length + breadth);
    }
}