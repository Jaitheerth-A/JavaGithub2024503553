//divided by zero
/*import java.util.Scanner;

public class excepdemo {
    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in)) {int a,b;System.out.print("Enter numerator:");a=sc.nextInt();
    System.out.println("Enter Denominator:");b=sc.nextInt();
    if(b==0){throw new ArithmeticException("Denominator was zero");}
    System.out.println("Quotient:" + a/b);}
    
    catch(ArithmeticException a){System.out.println(a.toString());}
    catch(Exception a){System.out.println(a.toString());}
    }  
}*/
/*import java.util.Scanner;
public class excepdemo{
    public static void main(String[] args){
        try(Scanner sc=new Scanner(System.in)){int[] a={1,2,3,4};System.out.print("Enter index of array:");int c=sc.nextInt();
        System.out.println("Array element:"+a[c]);
        try{
            int d;System.out.print("Enter number to divide with:");d=sc.nextInt();
            System.out.println("Quotient:"+a[c]/d);
        }
        catch(ArithmeticException b){System.out.println(b.toString());}
    }catch(ArrayIndexOutOfBoundsException e){System.out.println(e.toString());}
    }
}*/
