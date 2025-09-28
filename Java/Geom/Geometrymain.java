package Geom;

import geometry.Circle;
import geometry.Rectangle;

public class Geometrymain {

public class ShapeTest {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        Rectangle r = new Rectangle(4, 6);

        System.out.println("Circle:");
        System.out.println("Area = " + c.area());
        System.out.println("Perimeter = " + c.perimeter());

        System.out.println("\nRectangle:");
        System.out.println("Area = " + r.area());
        System.out.println("Perimeter = " + r.perimeter());
    }
}
}
