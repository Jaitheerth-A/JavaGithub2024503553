//Robot sum
import java.util.*;
class Robostairs{
public static int climbways(int n)
{
if(n==0) return 1;
if(n<0) return 0;
return climbways(n-1)+climbways(n-2);
}
public static void main(String args[])
{
int x;try(Scanner s=new Scanner(System.in);){
System.out.print("enter number of stairs:");
x=s.nextInt();s.close();
System.out.print("Total number of ways to climb stairs:"+climbways(x));
}}}