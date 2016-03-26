package week5.threads;

/**
 * Created by gavri on 15.03.2016.
 */
public class DeadLock {
    public static void main(String[] args) {
        final Thread[] threads = new Thread[2];
        threads[0] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("wait for  1 death");
                    threads[1].join();
                    System.out.println("He is dead know");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        threads[1] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("wait for  0 death");
                    threads[0].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        threads[0].start();
        threads[1].start();
        threads[1].interrupt();

    }
}
