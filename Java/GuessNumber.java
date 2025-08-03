import java.util.*;
class GuessNumber
{
    void guess()
    {
       Scanner sc=new Scanner(System.in);
       int c, rand=(int)(Math.round(Math.random()*100)+1);
       System.out.println("Guess the Random number:");
       do
       {
       System.out.print("Enter a number:");c=sc.nextInt();
       if(c==rand){System.out.println("Congrats! you got the number:" + rand);break;}
       else if(c>rand){System.out.println("Sorry! A little bit lower");}
       else{System.out.println("Sorry! A little bit higher");}
       }while(true);
    }
    public static void main(String[] args)
    {
     GuessNumber a=new GuessNumber();
     a.guess();  
    }
}