class Worker1thread extends Thread{
    Worker1thread(){
        super("Worker-1 thread");
        start();
    }
    public void run(){
        setPriority(MAX_PRIORITY);
        for(int i=1;i<=5;i++){
            System.out.println("Priority of "+getName()+" is "+getPriority());
        }
    }
    
}
public class Worker1threadmain {
    public static void main(String[] args) {
        Worker1thread w1=new Worker1thread();
    }
    
}
