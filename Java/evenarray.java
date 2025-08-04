import java.util.*;
class even
{
    void display(int[] a)
    {
        for(int i=0;i<a.length;i++)
        {
                System.out.println(Arrays.toString(a));
        }
    }
    boolean iscontain(int a[],int l,int v)
    {
        for(int i=0;i<l;i++)
        {
            if(a[i]==v)
            {
                return true;
            }
        }
        return false;
    }
    int[] calc(int a[],int b[])
    {
        int k=0;
        int[] c=new int[a.length>b.length? a.length : b.length];
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<b.length;j++)
            {
                if(a[i]==b[j] && a[i] % 2 == 0 && b[j] % 2 == 0 && !iscontain(c, k, a[i]))
                {
                    c[k]=a[i];
                    k++;
                    break; // To avoid duplicates in c
                }
            }
        }
        return c;
    }
}
public class evenarray {
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)) {
            even e = new even();
            int n;
            System.out.println("Enter the size of the first array:");
            n = sc.nextInt();
            int[] a = new int[n];
            System.out.println("Enter the elements of the first array:");
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println("Enter the size of the second array:");
            n= sc.nextInt();
            int[] b = new int[n];
            System.out.println("Enter the elements of the second array:");
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            int[] c = e.calc(a, b);
            System.out.println("The first array is:");
            e.display(a);
            System.out.println("The second array is:");
            e.display(b);
            if (c.length == 0) {
                System.out.println("No common even elements found.");
            }
            else{
            System.out.println("The common even elements are:");
            e.display(c);}
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
