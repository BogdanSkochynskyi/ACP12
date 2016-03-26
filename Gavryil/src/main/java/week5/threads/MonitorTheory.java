package week5.threads;

/**
 * Created by gavri on 16.03.2016.
 */
public class MonitorTheory {
    public static void main(String[] args){

        Object ref = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ref){
                    try {
                        System.out.println("RUN:wait...");
                        ref.wait();
                    } catch (InterruptedException ignore) {/*NOP*/}
                    System.out.println("RUN:thanks");
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        synchronized (ref){
            System.out.println("MAIN:sleep!");
            System.out.println("MAIN:notify!");
            ref.notify();
        }
    }
}
