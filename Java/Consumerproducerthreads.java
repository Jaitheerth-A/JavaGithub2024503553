import java.util.Scanner;
class Actions{
    int n=0;
    boolean valueset=false;
    synchronized int get(int n){
        while (!valueset) {
            try{wait(10000);}//Thread.sleep(100);}
            catch(InterruptedException e){e.printStackTrace();}
        }
        this.n=n;
        System.out.println("Got: " +n);
        valueset=false;
        notify();
        return n;
    }
    synchronized void put(int n)
    {
        while (valueset) {
         try{wait(10000);}//Thread.sleep(100);}
         catch(InterruptedException e){e.printStackTrace();}   
        }
        this.n=n;
        System.out.println("Put: "+n);
        valueset=true;
        notify();
    }
}
class Producer extends Thread{
    Actions a;
    Producer(Actions a)
    {
        super("Producer");
        this.a=a;
        super.start();
    }
    public void run(){
        int i=0;
        while(i<10)
        {
            a.put(i++);
        }
    }
}
class Consumer extends Thread{
    Actions a;
    Consumer(Actions a){
        super("Consumer");
        this.a=a;
        super.start();
    }
    public void run(){
        int i=0;
        while(i<10){
            a.get(i++);
        }
    }
}
public class Consumerproducerthreads {
    public static void main(String[] args) {
        Actions a=new Actions();
        new Producer(a);
        new Consumer(a);
        System.out.println("Press Control+C to stop");
    }
}
