package week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by ����� on 25.02.2016.
 */
public class TestMyScanner {

    private static MyScanner my;

    public static void preTest(String path) throws IOException { my = new MyScanner(path); }

    public static void positiveTest() throws IOException {

        //test0 hasNext()
        boolean actual0 = my.hasNext();
        boolean expected0 = true;
        System.out.printf("\ntest0 hasNext(): expected=%s, actual=%s, passed: %s\n",expected0,actual0,(expected0==actual0));

        //test1 next()
        String actual1 = my.next();
        String expected1 = "Бе-седа";

        System.out.printf("test1 next(): expected=%s, actual=%s, passed: %s\n",expected1,actual1,(expected1.equals(actual1)));

        //test2 useDelimiter()
        my.useDelimiter("-");
        String actual2 = my.next();
        String expected2 = "Бе";

        System.out.printf("test2 useDelimiter(): expected=%s, actual=%s, passed: %s\n",expected2,actual2,(expected2.equals(actual2)));

        //test3 nextLine()
        String actual3 = my.nextLine();
        String expected3 = "седа журналистки и писателя об";

        //по стандартній схемі чомусь не виводить результат
        System.out.println("test3 nextLine():\nexpected=" + expected3);
        System.out.println("actual=" + actual3);
        System.out.printf("passed: %s\n",expected3.equals(actual3));

        //test4 hasNextInt()
        boolean actual4 = my.hasNextInt();
        boolean expected4 = true;

        System.out.printf("test4 hasNextInt(): expected=%s, actual=%s, passed: %s\n",expected4,actual4,(expected4==actual4));

        //test5 nextInt()
        int actual5 = my.nextInt();
        int expected5 = 1000;

        System.out.printf("test5 nextInt(): expected=%s, actual=%s, passed: %s\n",expected5,actual5,(expected5==actual5));

        //test6 close()
        try {
            my.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
