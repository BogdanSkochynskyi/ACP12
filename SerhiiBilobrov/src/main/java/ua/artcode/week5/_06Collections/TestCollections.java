package ua.artcode.week5._06Collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by serhii on 13.03.16.
 */
public class TestCollections {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        List<Integer> synchList = Collections.synchronizedList(list);

        /*Map<Integer, String> synMap =
                Collections.synchronizedMap(new HashMap<Integer, String>());*/

        Map<Integer, String> synMap =
                new ConcurrentHashMap<>();





        ExecutorService service = Executors.newFixedThreadPool(50);

        long start = System.currentTimeMillis();

        final int count = 1000;
        for (int i = 0; i < count; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < count; j++) {
                        synMap.put(j,"asadf");
                    }
                }
            });

            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < count; j++) {
                        synMap.remove(j, "asadf");
                    }
                }
            });


            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < count; j++) {
                        synMap.get(j);
                    }
                }
            });
        }


        service.shutdown();

        try {
            service.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
