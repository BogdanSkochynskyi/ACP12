package ua.artcode.week5._05Atomic;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by serhii on 12.03.16.
 */
public class _01Intro {

    private static final Logger LOG = Logger.getLogger(_01Intro.class.getName());

    public static void main(String[] args) {

        LOG.setLevel(Level.INFO);
        LOG.addHandler(new ConsoleHandler());

        IContainer container = new Container();

        long start = System.currentTimeMillis();


        ExecutorService service = Executors.newFixedThreadPool(20);

        int operationCount = 100000;

        for (int i = 0; i < 10; i++) {
            Future future = service.submit(new IncThread(container,operationCount));
            service.submit(new DecThread(container,operationCount));
        }

        service.shutdown();
        while(!service.isTerminated()){
            try {
                service.awaitTermination(1000, TimeUnit.MILLISECONDS);
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

    private volatile AtomicInteger count = new AtomicInteger();

    // sync(){sync(){sycn}}
    public void inc() {// monitor this
        int temp = count.incrementAndGet();
        //System.out.println(temp);
    }

    public void decr() {
        int temp = count.decrementAndGet();
        //System.out.println(temp);
    }

    public int getCount() {
        return count.get();
    }

}

