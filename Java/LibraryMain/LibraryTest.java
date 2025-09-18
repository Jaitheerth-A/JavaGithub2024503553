package LibraryMain;

import library.Book;

public class LibraryTest {
    public static void main(String[] args) {
        Book b = new Book();

        System.out.println("Accessing from outside package:");
        b.showTitle();        //Accessible (public)

        // b.showAuthor();    //Not accessible (protected: only within package or subclass)
        // b.showPrice();     //Not accessible (private)
        // b.showPublisher(); //Not accessible (default/package-private)

        // Only showTitle() works here
    }
}