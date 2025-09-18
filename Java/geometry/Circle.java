package geometry;

public class Circle {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double area() {
        return Math.PI * radius * radius;
    }

    // Method to calculate perimeter
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}