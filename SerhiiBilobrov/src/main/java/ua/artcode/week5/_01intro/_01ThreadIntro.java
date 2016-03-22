package ua.artcode.week5._01intro;

/**
 * Created by serhii on 12.03.16.
 */
public class _01ThreadIntro {


    public static void main(String[] args) {
        // get current thread
        Thread main = Thread.currentThread();

        System.out.println(main.getName());

        MyThead myThead = new MyThead("poor info thread");
        myThead.setDaemon(true);
        myThead.start();

        for (int i = 0; i <= 100; i++) {
            System.out.printf("main working %d\n", i);

            if(i == 50){
                myThead.interrupt();
            }

            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}


class MyThead extends Thread {

    private String threadDescription;

    public MyThead(String threadDescription) {
        this.threadDescription = threadDescription;
    }

    @Override
    public void run() {

        while(!isInterrupted()){
            System.out.printf("My work %s, %s, %s\n", getId(), getName(), getState());
            try {
                sleep(1000); // interrupt
            } catch (InterruptedException e) {
                e.printStackTrace();
                interrupt();
            }
        }

    }
}
