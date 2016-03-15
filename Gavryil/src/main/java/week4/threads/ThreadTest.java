package week4.threads;

/**
 * Created by gavri on 11.03.2016.
 */
public class ThreadTest {
    public static void main(String[] args) {
        int[] array = new int[1_000_000_000];
        MyRunnable[] runners = new MyRunnable[4];
        Thread thread = new Thread(new MyRunnable(array,0,3));
        thread.start();
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello");
        }

    }
}

class MyRunnable implements Runnable {
    private final int[] array;
    private final int from;
    private final int to;
    public volatile int maxValue;
    public MyRunnable(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        int currentMaxValue = array[from];
      for (int k = from;k<=to;k++){
         currentMaxValue = Math.max(currentMaxValue,array[k]);
      }
        maxValue = currentMaxValue;
    }
}
