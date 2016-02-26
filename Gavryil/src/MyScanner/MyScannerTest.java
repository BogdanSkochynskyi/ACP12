package MyScanner;

import java.io.*;

/**
 * Created by gavri on 25.02.2016.
 */
public class MyScannerTest {
    public static void main(String[] args) throws FileNotFoundException {

        MyScanner scString = new MyScanner("This is my test MyScanner object");

        Reader reader = new InputStreamReader(new FileInputStream("\\ACP\\ACP12\\Gavryil\\src\\tmp\\try.txt"));

        MyScanner scReader = new MyScanner(reader);

       // String first = scString.next();
       // System.out.println(first);

      //  String second = scReader.next();
      //  System.out.println(second);

       // System.out.println(scString.next());
       // System.out.println(scString.next());
       // System.out.println(scString.next());
       // System.out.println(scString.next());
       // System.out.println(scString.next());

        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scReader.nextUsingUpdate());
        System.out.println(scString.nextUsingUpdate());
        System.out.println(scString.nextUsingUpdate());
        System.out.println(scString.nextUsingUpdate());
        System.out.println(scString.nextUsingUpdate());
        System.out.println(scString.nextUsingUpdate());
        System.out.println(scString.nextUsingUpdate());

    }
}
