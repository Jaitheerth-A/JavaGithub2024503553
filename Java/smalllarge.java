//to find largest and smallest combination of 4 digit number
import java.util.*;
class smalllarge{
public static void main(String args[])
{
int t,i,j;
try (Scanner s = new Scanner(System.in)) {
    System.out.print("enter 4 digit integer:");
    int a[]=new int[4];
    //for getting separate digits
    for(i=0;i<4;i++)
    {
        a[i]=s.nextInt();
    //a[i]=x%10;x/=10;
    }
    s.close();
    //sorting
    for(i=0;i<3;i++){for(j=0;j<3-i;j++){if(a[j]<a[j+1]){t=a[j];a[j]=a[j+1];a[j+1]=t;}}}
    int min=0,max=0;
    //maximum
    for(i=0;i<4;i++)
    {
    max=(max*10)+a[i];
    }
    //minimum
    for(i=3;i>=0;i--)
    {
    min=(min*10)+a[i];
    }
    System.out.print("Maxium value:"+max+"\nMinimum value:"+min);
}
}
}