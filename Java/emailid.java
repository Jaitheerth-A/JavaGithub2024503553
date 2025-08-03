import java.util.*;
public class emailid {
    public static void main(String args[])
    {
        String fname,lname;int id;byte age;
        try(Scanner s=new Scanner(System.in);){
        System.out.print("Enter first name:");fname=s.nextLine();
        System.out.print("Enter last name:");lname=s.nextLine();
        System.out.print("Enter employee id:");id=s.nextInt();
        System.out.print("Enter age:");age=s.nextByte();
        s.close();
        int len=lname.length();
        String email=(fname.substring(0,3)+lname.substring(len-3,len)
        )+age+id/100+"@xxx.com";
        System.out.print(email);
    }
}
}
