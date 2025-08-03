//to find if even or odd
import java.util.*;
class oddeve{
public static void main(String ars[]){
    try(Scanner s=new Scanner(System.in);){
int x;System.out.print("enter integer:");
x=s.nextInt();s.close();
if((x%2)==0)System.out.print("even");
else System.out.print("odd");
}}}