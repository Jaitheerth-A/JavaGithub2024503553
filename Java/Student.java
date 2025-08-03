import java.util.*;
class Marks{
    Integer rollno;//static int r;//index;
    static int numberofstudents=0;static float avg=0;
    float marks[]=new float[5];
    String grade[]=new String[5];
    String subject[]={"Maths","Science","Social Science","Language","English"};
    float total=0;
    String status; 
    static int rank[];
    static float rankmarks[];
    //static void Setrank(){rank=new int[r];rankmarks=new float[r];}
     static float classavg()
           {avg/=numberofstudents;
            return avg;
           }
    void Display()
           {
           Formatter f=new Formatter();
           System.out.println("\nStudent rollno:" + rollno);
           for(int j=0;j<5;j++)
               {
               f.format("%n%-20s %-8.2f %-2s",subject[j],marks[j],grade[j]); 
               }
           System.out.println(f);
           System.out.println("\nTOTAL:"+ total);
           System.out.println("\nSTATUS of Student:" + status);
           /*if(status.equals("PASS"))
           {rank[index][0]=rollno;
           index++;
           System.out.println("index:" + index);
           }*/
           }
Marks()
{
               Scanner s = new Scanner(System.in);
                System.out.print("Enter Student Roll no:");
                   rollno=s.nextInt();
                   for(int i=0;i<5;i++)
                   {
                   System.out.print("Enter "+subject[i]+" mark:");
                   marks[i]=s.nextFloat();
                   if(marks[i]<=100 && marks[i]>=90){grade[i]="S";}
                   else if(marks[i]<90 && marks[i]>=80){grade[i]="A+";}
                   else if(marks[i]<80 && marks[i]>=70){grade[i]="A";}
                   else if(marks[i]<70 && marks[i]>=60){grade[i]="B+";}
                   else if(marks[i]<60 && marks[i]>=50){grade[i]="B";}
                   else if(marks[i]<50 && marks[i]>=0){grade[i]="F";}
                   else {System.out.println("Error!! Please enter suitable answer");i--;continue;}
                   total+=marks[i];
               } if(marks[0]>=50 && marks[1]>=50 && marks[2]>=50 && marks[3]>=50 && marks[4]>=50){status="PASS";}//r++;}
           else {status="FAIL";}
                avg+=total;numberofstudents++;
}
static void CalcRank(Marks a[]) {
   // Setrank();
    int passCount = 0;
    for (Marks m : a) {
        if (m.status.equals("PASS")) passCount++;
    }

    rank = new int[passCount];
    rankmarks = new float[passCount];

    int idx = 0;
    for (Marks m : a) {
        if (m.status.equals("PASS")) {
            rank[idx] = m.rollno;
            rankmarks[idx] = m.total;
            idx++;
        }
    }

    // Sort based on marks (descending)
    for (int i = 0; i < passCount - 1; i++) {
        for (int j = 0; j < passCount - 1 - i; j++) {
            if (rankmarks[j] < rankmarks[j + 1]) {
                int t = rank[j]; rank[j] = rank[j + 1]; rank[j + 1] = t;
                float c = rankmarks[j]; rankmarks[j] = rankmarks[j + 1]; rankmarks[j + 1] = c;
            }
        }
    }

   Formatter  f=new Formatter();
    f.format("%n%-10s %-8s","ROLL NO","TOTAL MARKS");
    System.out.println("RANK LIST:");
    System.out.println(f);
    for (int i = 0; i < passCount; i++) 
               {
               f.format("%n%-10d %-8.2f",rank[i],rankmarks[i]); 
               }
           System.out.println(f);
        
}
}
public class Student
{
    public static void main(String args[]){
        try(Scanner s=new Scanner(System.in);){
            short n;
            System.out.print("Enter no of students:");
            n=s.nextShort();
            Marks m[]=new Marks[n];
            for(int i=0;i<n;i++)
                {System.out.println("Enter "+(i+1)+" Student Marks:");
                    m[i]=new Marks();
                }
            Formatter f=new Formatter();f.format("%n%-20s %-8s %-2s%n","SUBJECT","MARKS","GRADES");
            System.out.println(f);
            for(int i=0;i<n;i++)
                {
                m[i].Display();
                }
                 Marks.CalcRank(m);
            System.out.println("\nCLASS AVERAGE:" + Marks.classavg());
           System.out.println("Total number of students:" + Marks.numberofstudents);
        }
    }
}
