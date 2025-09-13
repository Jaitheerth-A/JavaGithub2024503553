/*1.create a code that finds the roots of the quadratic equation using static nested class
Note:the program should test for all cases with real and imaginary roots
2.create a code that maintains a dictionary of 3 letter words.
it accepts word from the user of n letters and tries to find the 3 letter words in the given string.
3.a token for employees for a project.
token must be created with last 3 digits of empno Along with rank which is calc by over time hours.
 limit for overtime is 8 hours.*/
import java.util.*;
class equ
{
    //-b+-/(b^2 - 4ac)/2astatic class
    static double a,b,c;
    static double r1,r2,r3;
   static String getdeg(int p)
    {
        String deg;
        deg=(p==1)?("Linear"):(p==2)?("Quadratic"):(p==3)?("Cubic"):("Polinomial");
        return deg;
    }
    static class root
    {
        void getinfo()
        {
            Scanner sc = new Scanner(System.in);  
            System.out.println("Enter " + getdeg(2) + " Equation:");
            System.out.print("x^2:");a=sc.nextDouble();sc.nextLine();
            System.out.print("x:");b=sc.nextDouble();sc.nextLine();
            System.out.print("c:");c=sc.nextDouble();sc.nextLine();
            sc.close();

        }

        char dsign(double v)
        {
            if(v>=0)
            return '+';
            return ' ';
        }
        void quad()
        { 
            getinfo();
            double d=Math.abs(Math.pow(b,2)-(4*a*c));
            if(a==0){System.out.println("Given equation is not " + getdeg(2) + "Equation.");return;}
            r1=(-b/2*a);  
            r2=Math.sqrt(d)/2*a;
            r3=-Math.sqrt(d)/2*a;  
            if(Math.pow(b,2)<4*a*c)
            {
                System.out.println("Imaginary roots:\nR1:" + r1 + dsign(r2) + r2 + 'i');
                System.out.println("R2:" + r1 +  dsign(r3) + r3 + 'i');   
            }   
            else
            {
                System.out.println("Real roots:\nR1:" + (r1+r2));
                System.out.println("R2:" + (r1+r3));
            }
        }
    } 
}
public class rootofquad
{
    static public void main(String args[])
    {
        equ.root r=new equ.root();
        r.quad();
    }
}
