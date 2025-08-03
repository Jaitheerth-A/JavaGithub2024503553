import java.util.*;
class ATM{
    double balance,prev;byte status;
    void deposit(double money)
    {
        if(money>0)
        {status=1;prev=balance;balance+=money;System.out.println("\nSuccessfully deposited:Rs" + money);}

        else
        {System.out.println("\nEnter valid amount to deposit");}
    }
    void withdraw(double amount)
    {
        if(amount>balance)
        {System.out.println("\nEnter amount less than Balance to Withdraw");}

        else
        {status=-1;prev=balance;balance-=amount;System.out.println("\nSuccessfully withdrew:Rs" + amount);}
    }
    void CheckBalance()
    {
        System.out.println("\nCURRENT BALANCE:"+balance);
        if(status==1)
        {System.out.println("\nBALANCE BEFORE DEPOSIT:"+prev);}
        else if(status==-1)
        {System.out.println("\nBALANCE BEFORE WITHDRAWAL:"+prev);}
    }   
    void choice()
    {   try (Scanner sc = new Scanner(System.in)) {
        int c=0;
        double d,w;
        while(c!=4)
        {
            System.out.print("\nCHOOSE OPERATION\n1)CHECK BALANCE\n2)DEPOSIT\n3)WITHDRAW\n4)EXIT\nENTER CHOICE:");
            c=sc.nextByte();
            switch(c)
            {
                case 1:{CheckBalance();break;}
                case 2:{System.out.println("\nEnter amount to deposit:");d=sc.nextDouble();deposit(d);break;}
                case 3:{System.out.println("\nEnter amount to withdraw:");w=sc.nextDouble();withdraw(w);break;}
                case 4:{System.out.println("\nThank you!");break;}
                default:{System.out.println("\nError!! Enter valid input");}
            }
        }
        }
        System.out.println("\nFunction Successfully completed!");        
    }
}
public class ATMBanking
{
    public static void main(String[] args)
    {
        ATM a=new ATM();
        a.choice();
    }
}