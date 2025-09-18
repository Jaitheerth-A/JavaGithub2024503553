package library;

public class Book {
    private String title = "Effective Java";
    private String author = "Joshua Bloch";
    private double price = 799.50;
    private String publisher = "Addison-Wesley";

    // public method
    public void showTitle() {
        System.out.println("Title: " + title);
    }

    // protected method
    protected void showAuthor() {
        System.out.println("Author: " + author);
    }

    // private method
    private void showPrice() {
        System.out.println("Price: " + price);
    }

    // default (package-private) method
    void showPublisher() {
        System.out.println("Publisher: " + publisher);
    }

    // method inside package to test access
    public void testAccessInside() {
        System.out.println("Accessing inside same class:");
        showTitle();      // Accessible
        showAuthor();     // Accessible
        showPrice();      // Accessible
        showPublisher();  // Accessible
    }
}