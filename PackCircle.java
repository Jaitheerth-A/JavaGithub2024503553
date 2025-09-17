package Geometry;
/*2. Package Creation – Shapes Library
Create a package named geometry that contains two classes:
• Circle (with radius and method to calculate area and perimeter).
• Rectangle (with length, breadth, and method to calculate area and perimeter).
Now, write a main program in a different package that imports geometry and
demonstrates the use of both classes.
3. A software company is developing a library management system. To enforce proper */
public class PackCircle {
    static final double PI = 3.14159;
    private double radius;
    public PackCircle(double radius) {
        this.radius = radius;
    }
    public double area() {
        return PI * radius * radius;
    }   
    public double perimeter() {
        return 2 * PI * radius;
    }
}
