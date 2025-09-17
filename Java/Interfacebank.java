/*1. A bank system handles different types of accounts. Define an interface Account with 
methods deposit(double amount) and withdraw(double amount).Additionally, define a 
static protected method inside the interface to display the bank policy (e.g., minimum 
balance for savings and overdraft limit for current account).
Create two classes that implement this interface:
• SavingsAccount → Allows withdrawal only if the remaining balance is at least 
₹1000.cannot withdraw more than 15000.
• CurrentAccount → Allows overdraft facility up to ₹50,000.
Write a main program that:
1. Creates objects of both account types.
2. Performs deposit and withdrawal operations.
3. Calls the static protected method from the interface to display bank policy*/
import java.util.Scanner;
interface Account
{
    //all var in interface are final static
    double min=1000, Min=50000;
    void deposit(double amount);double withdraw(double amount);
    static void policy(){System.out.println(
        "\n-----------------\n"+
    "BANK POLICY REGARDING ACCOUNTS:\n• SavingsAccount → Allows withdrawal only if the remaining balance is at least \r\n" + //
                "₹1000.cannot withdraw more than 15000.\r\n" + //
                "• CurrentAccount → Allows overdraft facility up to ₹50,000.\n-----------------\n");}
}
class SavingsAccount implements Account
{
    double bal=0;
    String acc;
    SavingsAccount(double a)
    {
        this();
        bal=a;
    }
       
    SavingsAccount()
    {
        System.out.println("Enter Account name ");acc=Interfacebank.sc.nextLine().trim();
        System.out.println("Savings Account of name:" +acc+ " is created");
    }
    public void deposit(double amount)
    {
        bal+=amount;
        System.out.println("Balance Amount:"+bal);
        if(bal<min)
        {System.out.println("The account has less than the required minimum for the savings account(<1000)");}
    }
   public void deposit(){
        double a;
        do{
        System.out.println("Enter amount to deposit:");
        a=Interfacebank.sc.nextDouble();Interfacebank.sc.nextLine();
        }while(a<0);deposit(a);
    }
    public double withdraw(double a)
    {
        if(bal<min)
        {System.out.println("The account has less than the required minimum for the savings account(<1000)");
    return 0;}
      /*   else if(a>=15000)
        {
            System.out.println("The withdrawal amount is greater than the withdrawal limit(>=15000)");
            return 0;
        }*/
        else if((bal-a)<min)
        {
            a=bal-min;
            char ch;
            System.out.println("Can only Withdraw :" + a + "Would you withdraw from this amount? (y/n):");ch=Interfacebank.sc.next().charAt(0);
            if(ch=='y' || ch=='Y'){
                do{
                System.out.println("Enter Amount to be withdrawn from "+a+':');
                a=Interfacebank.sc.nextDouble();Interfacebank.sc.nextLine();
                }while(a>bal-min ||a<0);}    
            else {System.out.println("Withdrawal Cancelled");return 0;  }
        }
        else
        bal-=a;
        System.out.println("Remaining Balance Amount:"+bal);
        System.out.println("Successfully withdrawed amount:"+a);
        return a;
    }
    
    public double withdraw(){
        double a;
        do{
        System.out.println("Enter amount to withdraw:");
        a=Interfacebank.sc.nextDouble();Interfacebank.sc.nextLine();
        /*if(a>=15000)
        {
            System.out.println("The withdrawal amount is greater than the withdrawal limit(>=15000)");
        }*/
        }while(a<min);//a>=15000 || a<min);
        a=withdraw(a);return a;

    }
}

class CurrentAccount implements Account
{
    double bal=0;
    String acc;
    CurrentAccount(double a)
    {
        this();
        bal=a;
    }
       
    CurrentAccount()
    {
       
        System.out.println("Enter Account name ");acc=Interfacebank.sc.nextLine().trim();
        System.out.println("Current Account of name:" +acc+ " is created");
        
    }
    public void deposit(double amount)
    {
        bal+=amount;
        System.out.println("Balance Amount:"+bal);
        if(bal<min)
        {System.out.println("The account has less than the required minimum for the savings account(<1000)");}
    }
    public void deposit(){
        double a;
        do{
        System.out.println("Enter amount to deposit:");
        a=Interfacebank.sc.nextDouble();Interfacebank.sc.nextLine();
        }while(a<0);deposit(a);
    }
    public double withdraw(double a)
    {
        if(bal<=0 && bal<a)
        {
            if(bal<=0)
            System.out.println("Balance amount is less than 0");
        }
        else if((bal-a)<Min)///////////////
        {
            a=bal-Min;
            char ch;
            System.out.println("Can only Withdraw :" + a + "Would you withdraw from this amount? (y/n):");ch=Interfacebank.sc.next().charAt(0);
            if(ch=='y' || ch=='Y'){
                do{
                System.out.println("Enter Amount to be withdrawn from "+a+':');
                a=Interfacebank.sc.nextDouble();Interfacebank.sc.nextLine();
                }while(a>bal-min ||a<0);}    
            else {System.out.println("Withdrawal Cancelled");return 0;  }
        }
        else
        bal-=a;
        System.out.println("Remaining Balance Amount:"+bal);
        System.out.println("Successfully withdrawed amount:"+a);
        return a;
    }
    
    public double withdraw(){
        double a;
        do{
        System.out.println("Enter amount to withdraw:");
        a=Interfacebank.sc.nextDouble();Interfacebank.sc.nextLine();
         if(a>=50000)
        {
            System.out.println("The withdrawal amount is greater than the withdrawal limit(>=15000)");
            continue;
        }
        }while(bal<0);
        a=withdraw(a);
        return a;}
    }

public class Interfacebank {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Account.policy();
        SavingsAccount a = new SavingsAccount(500000);
        a.withdraw();
        a.deposit();
        CurrentAccount b = new CurrentAccount(500000);
        b.withdraw();
        b.deposit();
        sc.close();
    }
}
//better version:
/*import java.util.Scanner;

interface Account {
    double MIN_BALANCE = 1000;
    double OVERDRAFT_LIMIT = 50000;

    void deposit(double amount);
    double withdraw(double amount);

    static void policy() {
        System.out.println("\n-----------------");
        System.out.println("BANK POLICY REGARDING ACCOUNTS:");
        System.out.println("• SavingsAccount → Withdrawal allowed only if remaining balance is at least ₹1000 and max ₹15000 at a time.");
        System.out.println("• CurrentAccount → Allows overdraft facility up to ₹50,000.");
        System.out.println("-----------------\n");
    }
}

class SavingsAccount implements Account {
    private double balance;
    private String accountName;

    SavingsAccount(double initialBalance) {
        this.accountName = promptAccountName();
        this.balance = initialBalance;
        System.out.println("Savings Account '" + accountName + "' created with balance ₹" + balance);
    }

    private String promptAccountName() {
        System.out.print("Enter Account Name: ");
        return Interfacebank.sc.nextLine().trim();
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + ". New balance: ₹" + balance);
    }

    public void deposit() {
        double amount;
        do {
            System.out.print("Enter amount to deposit (must be positive): ");
            amount = Interfacebank.sc.nextDouble();
            Interfacebank.sc.nextLine();
        } while (amount <= 0);

        deposit(amount);
    }

    @Override
    public double withdraw(double amount) {
        if (amount > 15000) {
            System.out.println("Withdrawal limit exceeded (₹15000 max per transaction).");
            return 0;
        }

        if (balance - amount < MIN_BALANCE) {
            double maxWithdrawable = balance - MIN_BALANCE;
            System.out.println("You can withdraw up to ₹" + maxWithdrawable + ". Proceed? (y/n): ");
            char choice = Interfacebank.sc.next().charAt(0);
            Interfacebank.sc.nextLine();
            if (choice == 'y' || choice == 'Y') {
                amount = maxWithdrawable;
                balance -= amount;
            } else {
                System.out.println("Withdrawal cancelled.");
                return 0;
            }
        } else {
            balance -= amount;
        }

        System.out.println("Withdrawn ₹" + amount + ". New balance: ₹" + balance);
        return amount;
    }

    public double withdraw() {
        double amount;
        do {
            System.out.print("Enter amount to withdraw (must be positive and ≤ ₹15000): ");
            amount = Interfacebank.sc.nextDouble();
            Interfacebank.sc.nextLine();
        } while (amount <= 0 || amount > 15000);

        return withdraw(amount);
    }
}

class CurrentAccount implements Account {
    private double balance;
    private String accountName;

    CurrentAccount(double initialBalance) {
        this.accountName = promptAccountName();
        this.balance = initialBalance;
        System.out.println("Current Account '" + accountName + "' created with balance ₹" + balance);
    }

    private String promptAccountName() {
        System.out.print("Enter Account Name: ");
        return Interfacebank.sc.nextLine().trim();
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + ". New balance: ₹" + balance);
    }

    public void deposit() {
        double amount;
        do {
            System.out.print("Enter amount to deposit (must be positive): ");
            amount = Interfacebank.sc.nextDouble();
            Interfacebank.sc.nextLine();
        } while (amount <= 0);

        deposit(amount);
    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return 0;
        }

        if (amount > (balance + OVERDRAFT_LIMIT)) {
            System.out.println("Overdraft limit exceeded (₹50,000). Withdrawal denied.");
            return 0;
        }

        balance -= amount;
        System.out.println("Withdrawn ₹" + amount + ". New balance: ₹" + balance);
        return amount;
    }

    public double withdraw() {
        double amount;
        do {
            System.out.print("Enter amount to withdraw (must be positive and ≤ ₹50000): ");
            amount = Interfacebank.sc.nextDouble();
            Interfacebank.sc.nextLine();
        } while (amount <= 0 || amount > 50000);

        return withdraw(amount);
    }
}

public class Interfacebank {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Account.policy();

        SavingsAccount sa = new SavingsAccount(500000);
        sa.withdraw();
        sa.deposit();

        CurrentAccount ca = new CurrentAccount(500000);
        ca.withdraw();
        ca.deposit();

        sc.close();
    }
} */