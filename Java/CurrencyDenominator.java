//TO FIND DIFFERENT WAYS TO PAY A PRINCIPLE
import java.util.*;
public class CurrencyDenominator {
    public static void main(String args[]) {
        short denom[]={2_000,500,100,50,20,10,5,2};
        int x;
        System.out.print("Enter principle amount:");
        try (Scanner s= new Scanner(System.in)) {
            x=s.nextInt();
        }
        if(x<0) System.out.println("Error!! enter positive number");
        for(short d:denom)
        {
            int c;
            c=x/d;
            x%=d;
            System.out.println("Rs"+d+':'+c+"notes");
        }
        if(x!=0) System.out.println("Couldn\'t express with just given denominator");
    }
}
