class Runnablethread implements Runnable {
    Thread t;
    Runnablethread() {
        t = new Thread(this, "Runnable-Thread");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
    }
    public void run() {
       for(int i=0; i<5; i++) {
           System.out.println("Runnable Thread: " + i + ").Priority:" + t.getPriority()
            + ",Thread Name: " + t.getName());
       }
    }
}
public class Runnablethreadmain {
    public static void main(String[] args) {
        Runnablethread r1 = new Runnablethread();
    }
}
