class childthread extends Thread
{
    childthread(String name){super(name);}
    public void run()
    {
        System.out.println("Thread Name:"+Thread.currentThread().getName()+
        "\nThread Priority:"+Thread.currentThread().getPriority());        
    }
}
public class childthreaddemo {
    public static void main(String[] args) {
        //System.out.println("Main Thread Name:"+Thread.currentThread().getName()
       // +"\nMain Thread Priority:"+Thread.currentThread().getPriority());
        childthread t1=new childthread("First Child");
        t1.setPriority(Thread.MAX_PRIORITY);
        childthread t2=new childthread("Second Child");
        t1.setPriority(Thread.MIN_PRIORITY);
        childthread t3=new childthread("Third Child");
        t1.setPriority(Thread.NORM_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());
    }
}
