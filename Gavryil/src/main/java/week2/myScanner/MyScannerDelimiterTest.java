package week2.myScanner;

import java.io.*;

/**
 * Created by gavri on 29.02.2016.
 */
public class MyScannerDelimiterTest {
    public static void main(String[] args) throws FileNotFoundException {
        Reader reader = new InputStreamReader(new FileInputStream("Gavryil/src/main/resources/try.txt"));

        MyScanner scReader = new MyScanner(reader);

        scReader.useDelimiter("что");

        System.out.println(scReader.next());
        System.out.println(scReader.next());
        System.out.println(scReader.next());
        System.out.println(scReader.next());
        System.out.println(scReader.next());
        System.out.println(scReader.next());
        System.out.println(scReader.next());
        System.out.println(scReader.next());
        System.out.println(scReader.next());
        System.out.println(scReader.next());
        System.out.println(scReader.next());
        System.out.println(scReader.next());
        System.out.println(scReader.next());
        System.out.println(scReader.next());

        MyScanner scSys = new MyScanner(System.in);
        int key = scSys.nextInt();
        System.out.println(scSys.next());
        System.out.println(key);
        int key2 = scSys.nextInt();
        System.out.println(key2);




    }
}
