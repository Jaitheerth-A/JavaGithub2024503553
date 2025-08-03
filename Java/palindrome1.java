//TO FIND IF GIVEN INTEGER IS PALINDROME
import java.util.*;
public class palindrome1{
    public static void main(String a[])
    {
        try(Scanner s=new Scanner(System.in);){
        int x;
        System.out.print("ENTER INTEGER:");
        x=s.nextInt();
        s.close();
        int n,d,r=0;n=x;
        System.out.println(n);
        while(n!=0)
        {
            d=n%10;
            r=(r*10)+d;
            n/=10;
        }
        if(r==x){System.out.println("GIVEN INTEGER IS A PALINDROME");}
        else {System.out.println("GIVEN INTEGER IS NOT A PALINDROME");}
    }
}
}

