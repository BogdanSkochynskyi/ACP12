package week5.threads.homework;

/**
 * Created by gavri on 18.03.2016.
 */
public class SchedulerTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm a live");
            }
        });

        SchedullerTask scheduller = new SchedullerTask(thread,1000,0);
        scheduller.runEveryXMills();
    }
}
