//TO FIND IF GIVEN NUMBER IS ARMSTRONG NUMBER
import java.util.*;
public class Armstrong {
    public static void main(String[] args) {
        try(Scanner s=new Scanner(System.in);){
        int x;
        System.out.print("ENTER INTEGER:");
        int i;
        int len=0;
        x=s.nextInt();
        s.close();
        int n=x;
        while(n!=0)
        {
            n/=10;
            len++;
        }
       // System.out.println(len);
        int res=0;n=x;
        for(i=0;i<len;i++)
        {
            //System.out.println(a);
            res+=(int)Math.pow(n%10,len);
           // System.out.println(res);
            n/=10;
        }
        if(res==x)
        {
            System.out.print("GIVEN INTEGER IS ARMSTRONG NUMBER");
        }
        else System.out.print("GIVEN INTEGER IS NOT ARMSTRONG NUMBER");
       /*  for(i=0;i<len;i++)
        {
            res+=a[i]*Math.pow(a[i],len);
        }*/
    }
}
}
