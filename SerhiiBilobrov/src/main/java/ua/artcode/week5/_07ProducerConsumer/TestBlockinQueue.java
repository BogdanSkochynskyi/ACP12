package ua.artcode.week5._07ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by serhii on 13.03.16.
 */
public class TestBlockinQueue {


    public static void main(String[] args) {
        BlockingQueue<Integer> buff = new ArrayBlockingQueue<Integer>(10,true);


        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        try {
                            buff.put((int) (Math.random()) * 100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        try {
                            buff.take();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();
        }


    }
}
