/*Question for Operators: Develop a Java program to handle 
the inventory of ‘n’ grocery items.
For each item, input the name, quantity, and unit price.
Calculate the total value using arithmetic operators,
apply a 5% discount if the total exceeds ₹2000 using relational and assignment 
operators, and reduce the quantity by one using unary operators to simulate a sale. 
Use a ternary operator to label items as "High Value" or "Low Value",
and apply a bitwise operator to check if the remaining quantity is even or odd. */
import java.util.*;
class Inventory
{
    int n;
    String name;
    int quantity;
    double unitPrice;
    double totalValue;
    Inventory(int n){this.n = n;if(n>0){System.out.println("Total no. of goods in inventory:" + n);}
    else{System.out.println("No goods in inventory");}}
    Inventory(){}
    void Details()
    {
        try (Scanner sc = new Scanner(System.in)) {
            String c=new String();
            do{
            System.out.print("Enter item name: ");
            name = sc.nextLine();
            System.out.print("Enter quantity: ");
            quantity = sc.nextInt();
            while(quantity> n || quantity <= 0) {
                System.out.println("Enter valid quantity (1 to " + n + "):");
                quantity = sc.nextInt();
            }
            sc.nextLine(); // Consume the newline character
            System.out.print("Enter unit price: ");
            unitPrice = sc.nextDouble();
            totalValue = quantity * unitPrice;

            if (totalValue > 2000) {
                System.out.println("Total value exceeds ₹2000,Discount value:" + totalValue * 0.05);
                totalValue -= totalValue * 0.05; // Apply 5% discount
            }
            System.out.println("Final Total value: ₹" + totalValue);
            n-=quantity; // Simulate a sale by reducing quantity by 1
            System.out.println("Remaining quantity after sale: " + n);
            String valueLabel = (totalValue > 1000) ? "High Value" : "Low Value";
            System.out.println("Item is labeled as: " + valueLabel);
            // Check if remaining quantity is even or odd using bitwise operator
            String quantityType = (n & 1) == 0 ? "Even" : "Odd";
            System.out.println("Remaining quantity is: " + quantityType);
            if(n>0)
            {System.out.print("Do you want to enter another item? (yes/no): ");sc.nextLine();
            c=sc.nextLine().trim().toLowerCase();} // Consume the newline character
            //c = sc.nextLine().charAt(0);
        }while((c.equals("yes") || c.equals("y")) && n>0);
    }
}
}
public class Grocery
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of grocery items: ");
        int n = sc.nextInt();
        while(n <= 0) {
            System.out.println("enter valid number of items:");n= sc.nextInt();
        }
        Inventory inventory = new Inventory(n);
            inventory.Details();
        sc.close();
    }
}