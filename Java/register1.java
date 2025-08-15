import java.util.*;
//import java.lang.Enum;
class uni
{
    String name;
    String course[]=new String[3];
    float in[]=new float[3];
    float sem[]=new float[3];
    String grade[]=new String[3];
    float tot[]=new float[3];
    int rno;
    uni(){}
    uni(String name,int rno)
    {
        this.name=name;
        this.rno=rno;
    }
    void getinfo()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter courses:");
        for(int i=0;i<3;i++)
        {
            System.out.println("Enter course name " + (i+1) + ':');course[i]=sc.nextLine();
            System.out.println("Enter internal marks in " + course[i] + ':');in[i]=sc.nextFloat();
            System.out.println("Enter end semester marks in " + course[i] + ':');sem[i]=sc.nextFloat();
            sc.nextLine();
        }
        sc.close();
        calctot();
    }
    void calctot()
    {
        for(int i=0;i<in.length;i++)
        {
            tot[i]=(in[i]*0.5f) + (sem[i]*0.5f);
            System.out.println("Total mark of " + course[i] +':' + tot[i]);
        }
        getgrade();
    }
    void getgrade()
    {
        for(int i=0;i<in.length;i++)
        {
            grade[i]=(tot[i]>=90 && tot[i]<=100)?"S":(tot[i]>=80)?"A+":(tot[i]>=70)?"A":(tot[i]>=60)?"B+":(tot[i]>=50)?"B":"U";
        } 
    }

    void display()
    {
        //System.out.println("Details of Student:" + rno);
        System.out.println("Name:" + name);
        System.out.println("COURSE\t\t\tGRADE");
        for(int i=0;i<3;i++)
        System.out.println(course[i] + "\t\t\t"+ grade[i]);
    }
}

class fulltime extends uni
{
    fulltime(String name,int rno)
    {super(name,rno);}
    @Override
    void display() {
        System.out.println("DETAILS OF FULL TIME STUDENT:" + rno);
        super.display();
    }
}
class parttime extends uni
{
    parttime(String name,int rno)
    {super(name,rno);}
    @Override
    void display() {
        System.out.println("DETAILS OF PART TIME STUDENT:" + rno);
        super.display();
    }
    void calctot()
    {
        for(int i=0;i<in.length;i++)
        {
            tot[i]=(in[i]*0.6f) + (sem[i]*0.4f);
            System.out.println("Total mark of " + course[i] +':' + tot[i]);
        }
        getgrade();
    }
}
public class register1 {
    public static void main(String[] args) {
        fulltime a=new fulltime("RAM",202);
        parttime b=new parttime("ARUN",101);
        a.display();
        b.display();        
    }
}
