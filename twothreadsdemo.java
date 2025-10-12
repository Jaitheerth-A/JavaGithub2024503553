class twothreads extends Thread{
    int s;
    twothreads(String name,int n){
        super(name);s=n;
    }
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("Thread name:" + Thread.currentThread().getName() 
            + " " + i);
            try{
                Thread.sleep(s);
            }
            catch(InterruptedException e){
                System.out.println(e);
        }
    }
}
}
public class twothreadsdemo {
    public static void main(String[] args) {
        twothreads t1 = new twothreads("First Thread",1000);
        twothreads t2 = new twothreads("Second Thread",1000);
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
