package MyScanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by gavri on 29.02.2016.
 */
public class MyScannerDelimiterTest {
    public static void main(String[] args) throws FileNotFoundException {
        Reader reader = new InputStreamReader(new FileInputStream("\\ACP\\ACP12\\Gavryil\\src\\tmp\\try.txt"));

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
    }
}
