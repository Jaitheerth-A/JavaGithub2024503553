import java.util.*;
class Book{
    Scanner sc=new Scanner(System.in); 
    String  title,author;int year,late;float fine,totfine;
    Book(){
        System.out.print("Enter Title of Book:");title=sc.nextLine();
        System.out.print("Enter Author of Book:");author=sc.nextLine();
        System.out.print("Enter Year of Publication:");year=sc.nextInt();
        System.out.print("Enter Fine Charged per Day Late:");fine=sc.nextFloat();
    }
    void Late()
    {
        System.out.print("Enter Number of Days the Book is Returned Late:");late=sc.nextInt();        
    }
    void Totfine()
    {
        totfine=fine*late;        
    }
    void Display()
    {
        System.out.println("Title of Book:" + title);
        System.out.println("Author of Book:" + author);
        System.out.println("Year of Publication:" + year);
        System.out.println("Fine Charged per Day Late" + fine);
        System.out.println("Number of Days the Book was Returned Late:" + late);
        System.out.println("Total Fine:" + totfine);
    }
}
public class Library{
    public static void main(String args[]){
        System.out.println("ENTER DETAILS FOR LIBRARY MANAGEMENT:");
        System.out.println("----First Book----");
        Book b1=new Book();b1.Late();b1.Totfine();
        System.out.println("----First Book Desciption----");
        b1.Display();
        System.out.println("----Second Book----");
        Book b2=new Book();b2.Late();b2.Totfine();
        System.out.println("----Second Book Desciption----");
        b2.Display();
    }
}
