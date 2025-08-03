//TO FIND FACE AND PLACE VALUE OF DIGITS IN INTEGER
import java.util.*;
public class PlaceFace {
    public static byte getlen(int a){byte l=0;
        while(a!=0)
        {
            a/=10;l++;
        }
        System.out.println(l);
        return l;}
    public static void main(String args[]) {
        int x;
        byte i,a;
        Scanner s=new Scanner(System.in);
        String place[]={"ones","tens","hundreds","thousands",
        "ten thousands","hundred thousands","millions","ten millions",
        "hundred millions","billions"};
        System.out.print("enter integer:");
        x=s.nextInt();
        System.out.println(x);
        System.out.print("enter digit to search:");
        a=s.nextByte();
        byte l=getlen(x);
         s.close();
        for (i = 0; i <= l; i++) {
            if((x%10)==a)
            {
                break;
            }
            x/=10;
        }
        System.out.println(i);
        System.out.println("Place:"+place[i]+"\nPLace value:"
        +(int)(Math.pow(10,i)*a)+"\nFace value:"+a);
    }
    
}
