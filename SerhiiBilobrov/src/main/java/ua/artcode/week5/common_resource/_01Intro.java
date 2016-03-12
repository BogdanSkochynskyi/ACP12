package ua.artcode.week5.common_resource;

/**
 * Created by serhii on 12.03.16.
 */
public class _01Intro {

    public static void main(String[] args) {

        Container container = new ContainerSpinLock();

        long start = System.currentTimeMillis();



        int operationCount = 1000000;
        Thread thread1 = new Thread(new IncThread(container, operationCount));
        thread1.start();

        Thread thread2 = new Thread(new DecThread(container, operationCount));
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("time");
        System.out.println(end - start);
        System.out.println("count");
        System.out.println(container.getCount());
    }

}


class IncThread implements Runnable {

    private Container container;
    private int operationCount;


    public IncThread(Container container, int operationCount) {
        this.container = container;
        this.operationCount = operationCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < operationCount; i++) {
            container.inc();
        }
    }
}

class DecThread implements Runnable {

    private Container container;
    private int operationCount;


    public DecThread(Container container, int operationCount) {
        this.container = container;
        this.operationCount = operationCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < operationCount; i++) {
            container.decr();
        }
    }
}

class Container {

    private volatile int count;

    private Object lock = new Object();

    public void inc() {// monitor this
        synchronized (lock){
            count++;
        }

    }

    public void decr() {
        synchronized (lock){
            count--;
        }
    }

    public int getCount() {
        return count;
    }

}

class ContainerSpinLock extends Container {

    private volatile int count;
    private MyLock myLock = new MyLock();

    public void inc() {// monitor this
        myLock.lock();
        count++;
        myLock.unlock();
    }

    public void decr() {
        myLock.lock();
        count--;
        myLock.unlock();
    }

    public int getCount() {
        return count;
    }

}
