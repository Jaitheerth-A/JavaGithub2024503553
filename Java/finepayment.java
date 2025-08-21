import java.util.*;
public class finepayment
{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    enum type{UG,PG,SCHOLARS,STAFF};

    int a;String post=new String();
    System.out.print("Enter number of borrowed days:");a=sc.nextInt();
    System.out.println("Enter position:");post=sc.nextLine();
        type p;
        p=type.valueOf((post.toUpperCase()));
        library std=new library();
        switch(p)
        {
            case UG:std=new ug(a);break;
            case PG:
            case SCHOLARS:std=new pg(a);break;
            case STAFF:std=new staff(a);break;
            default:System.out.println("Error!! invalid choice");
        }
        std.display();
        sc.close();
}}

class library
{
    int day;
    int fine;
    int finedays;
    library(){}
    library(int day){this.day=day; }
    void display()
    {
        System.out.println("Number of days late:" + day + "\nTotal Fine:" + fine);
    }
    int calc(){System.out.println("pre defined not defined");return 0;}
}


class ug extends library
{
    ug(int day)
    {
        super(day);
    }
    void display(){System.out.println("UG student:");super.display();}
    int calc()
    {
        finedays=Math.max(0, day-15);
        fine=finedays>=10?(((finedays-10)*10) + (10*5)):finedays*5;
        return fine;
    }
}

class pg extends library
{
    pg(int day){super(day);}
    void display(){System.out.println("PG student:");super.display();}
    int calc()
    {
        finedays=Math.max(0, day-30);
        fine=finedays>=10?(((finedays-10)*10) + (10*5)):finedays*5;
        return fine;
    }
}

class staff extends library
{
    staff(int day){super(day);}
    void display(){System.out.println("STAFF:");super.display();}
    int calc()
    {
        finedays=Math.max(0, day-90);
        fine=finedays*10;
        return fine;
    }
}
