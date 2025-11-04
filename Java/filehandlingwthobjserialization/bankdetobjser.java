package filehandlingwthobjserialization;
import java.io.*;
public class bankdetobjser {
    public static void main(String[] args) {
       try{ bankcustdet bcd=new bankcustdet("John.A",3000,50000.50,101);
    BufferedOutputStream bo=new BufferedOutputStream(new FileOutputStream("bankdetails.ser"));
    ObjectOutputStream oo=new ObjectOutputStream(bo);
    oo.writeObject(bcd);
    oo.flush();
    oo.close();
    bo.close();
    System.out.println("Object serialized successfully");
    try{
    BufferedInputStream bi=new BufferedInputStream(new FileInputStream("bankdetails.txt"));
    ObjectInputStream oi=new ObjectInputStream(bi);
    bankcustdet b2=(bankcustdet)oi.readObject();
    oi.close();
    bi.close();
    b2.display();
    System.out.println("Object deserialized successfully");}
     catch(ClassNotFoundException e)
    {e.printStackTrace();}
    }
    catch(FileNotFoundException e)
    {e.printStackTrace();}
    catch(IOException e)
    {e.printStackTrace();}
}
}

class bankcustdet implements Serializable{
String custnm;
int custno;
transient double accbal;
int brcd;
public bankcustdet(String custnm,int custno,double accbal,int brcd){
this.custnm=custnm;
this.custno=custno;
this.accbal=accbal;
this.brcd=brcd;
System.out.println("Customer Name: " + custnm);
System.out.println("Customer Number: " + custno);
System.out.println("Account Balance: " + accbal);
System.out.println("Branch Code: " + brcd);
}
public void display()
{System.out.println("Customer Name: " + custnm);
System.out.println("Customer Number: " + custno);
System.out.println("Account Balance: " + accbal);
System.out.println("Branch Code: " + brcd);
}
}