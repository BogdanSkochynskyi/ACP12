package week5.threads.homework;

public class SchedullerTask {

    private Runnable runnable;
    private long mills;
    private int repeat;

    //endless repeat;
    public SchedullerTask(Runnable runnable, long mills) {
        this.runnable = runnable;
        this.mills = mills;
    }
    // Zero argument means endless repeat;
    //repeat should be > 0;

    public SchedullerTask(Runnable runnable, long mills, int repeat) {
        this.runnable = runnable;
        this.mills = mills;
        this.repeat = repeat;
    }

    public void runEveryXMills() throws InterruptedException {
        Thread thread = new Thread(runnable);
        if (repeat < 0) throw new IllegalArgumentException("Repeat can't be less than 0");
        if (repeat > 0) {
            thread.start();
            int count = 01;
            for (; count < repeat; count++) {
                thread.join();
                if (!thread.isAlive()) {
                    Thread.sleep(mills);
                    thread = new Thread(runnable);
                    thread.start();
                }
            }
        }
        if (repeat == 0) { // Zero argument means endless repeat;
            while (true) {
                if (!thread.isAlive()) {
                    Thread.sleep(mills);
                    thread = new Thread(runnable);
                    thread.start();
                }
            }
        }
    }




}
