import java.util.*;
class register
{
    public
    int custid[];String product[][];float cost[][];
    register(int n){custid=new int[n];product=new String[n][];cost=new float[n][];}
}
class customer
{
    register r;
    static int count;
    //constructors
    customer(){}
    customer(int n)
    {

    r=new register(n);
    int id;
    System.out.print("Enter the id number of "+ suffix(i+1));
    for(int i=0;i<n;i++)
    {getinfo(id);}

    }
    //methods

    String suffix(int i){}
    void getinfo(int id)
    {
                r.custid[count++]=id;
    }
} 
public class storeregister
{
    public static void main()
    {}
}
