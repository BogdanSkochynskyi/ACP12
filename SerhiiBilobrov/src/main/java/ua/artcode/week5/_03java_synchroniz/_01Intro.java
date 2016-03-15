package ua.artcode.week5._03java_synchroniz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 12.03.16.
 */
public class _01Intro {

    public static void main(String[] args) {

        IContainer container = new Container();

        long start = System.currentTimeMillis();


        List<Thread> threadList = new ArrayList<>();

        int operationCount = 1000000;

        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(new IncThread(container, operationCount));
            thread1.start();
            Thread thread2 = new Thread(new DecThread(container, operationCount));
            thread2.start();

            threadList.add(thread1);
            threadList.add(thread2);
        }


        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        long end = System.currentTimeMillis();

        System.out.println("time");
        System.out.println(end - start);
        System.out.println("count");
        System.out.println(container.getCount());
    }

}


class IncThread implements Runnable {

    private IContainer container;
    private int operationCount;


    public IncThread(IContainer container, int operationCount) {
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

    private IContainer container;
    private int operationCount;


    public DecThread(IContainer container, int operationCount) {
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


interface IContainer {
    void inc();
    void decr();

    int getCount();
}

// TODO show logging
class Container implements IContainer {

    private volatile int count;

    private Object lock = new Object();

    public void inc() {// monitor this

        synchronized (lock){// monitor -> wait, notify, notifyAll within synchronized
            System.out.printf("inc %d thread id %s, takes monitor\n", count,Thread.currentThread().getId());

            while(count != 0){
                try {
                    System.out.printf("inc %d thread id %s, wait\n", count,Thread.currentThread().getId());
                    lock.wait();// release monitor
                    System.out.printf("inc %d thread id %s, awake\n", count,Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            count++;
            lock.notifyAll();
            System.out.printf("inc %d thread id %s, releas monitor\n", count,Thread.currentThread().getId());
        }

    }

    public void decr() {
        synchronized (lock){
            System.out.printf("decr %d thread id %s, takes monitor\n", count,Thread.currentThread().getId());

            while(count != 1){
                try {
                    System.out.printf("decr %d thread id %s, wait\n", count,Thread.currentThread().getId());
                    lock.wait();
                    System.out.printf("decr %d thread id %s, awake\n", count,Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            count--;
            System.out.printf("decr %d thread id %s, release monitor\n", count,Thread.currentThread().getId());
            lock.notifyAll();
        }
    }

    public int getCount() {
        return count;
    }

}

class ContainerSpinLock implements IContainer{

    private volatile int count = 0;
    private MyLock myLock = new MyLock();

    public void inc() {// monitor this
        try{
            myLock.lockA();
            count++;
        } finally {
            myLock.unlockA();
        }
    }

    public void decr() {
        try{
            myLock.lockB();
            count--;
        }finally {
            myLock.unlockB();
        }
    }

    public int getCount() {
        return count;
    }

}
