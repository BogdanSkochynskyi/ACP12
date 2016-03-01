package MyScanner;

import java.io.*;

/**
 * Created by gavri on 25.02.2016.
 */
public class MyScannerTest {
    public static void main(String[] args) throws FileNotFoundException {

        MyScanner scString = new MyScanner("This, is, my, test MyScanner object");

        Reader reader = new InputStreamReader(new FileInputStream("\\ACP\\ACP12\\Gavryil\\src\\tmp\\try.txt"));

        MyScanner scReader = new MyScanner(reader);

        scReader.useDelimiter(",");
        scReader.reset();
        String first = scString.next();


        String second = scReader.next();
        System.out.println(second);
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
        System.out.println("****************************************");
        System.out.println(first);
        System.out.println(scString.next());
        System.out.println(scString.next());
        System.out.println(scString.next());
        System.out.println(scString.next());
        System.out.println(scString.next());
        System.out.println(scString.next());






        System.out.println("****************************************");


        Reader reader1 = new InputStreamReader(new FileInputStream("\\ACP\\ACP12\\Gavryil\\src\\tmp\\try2.txt"));
        MyScanner sc3 = new MyScanner(reader1);
        System.out.println(sc3.next());


        System.out.println("****************************************");

        MyScanner sc4 = new MyScanner("1234");
        System.out.println(sc4.nextInt());

        System.out.println(scReader.nextLine());
        System.out.println("********************************");

        System.out.println(scString.hasNext());
        System.out.println(scString.next());

        System.out.println("********************************");

        System.out.println(scReader.hasNext());
        System.out.println(scReader.next());
        System.out.println(scReader.nextLine());







    }
}
