/*import java.util.Scanner;
class CreditLevelException extends Exception
{
    private double w;
    private String s;
    CreditLevelException(double a)
    {w=a;if(w>=0){s="The withdrawal amount "+ w +" exceeds Rs.10000";}
else{s="The withdrawal amount "+ w +" is negative";} }
    public String toString()
    {
        return s;
    }
    static void check(double d)throws CreditLevelException{if(d>10000){throw new CreditLevelException(d);}
else if(d<0){throw new CreditLevelException(d);}}
}
public class excepdemo2 {
    static double balance=10000;
    public static void main(String[] args)
    {
        try(Scanner sc=new Scanner(System.in)){
        double w;
        System.out.print("Enter withdrawal amount:");w=sc.nextDouble();
        CreditLevelException.check(w);
        System.out.println("Successfully withdrawn "+w);
        balance-=w;
    }
        catch(CreditLevelException c){System.out.println(c.toString());}
        finally{
        System.out.println("Remaining balance:"+balance);}
    }
}
*/