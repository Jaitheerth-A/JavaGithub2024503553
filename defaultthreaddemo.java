class defaultthread extends Thread
{
    public void run()
    {
        System.out.println("Thread name:" + Thread.currentThread().getName() +
        " Thread Priority:" + Thread.currentThread().getPriority());        
    }    
}
public class defaultthreaddemo {
    public static void main(String[] args) {
        defaultthread t1=new defaultthread();
        t1.setName("Child Thread");
        t1.setPriority(Thread.NORM_PRIORITY);
        t1.start();
    }
}
