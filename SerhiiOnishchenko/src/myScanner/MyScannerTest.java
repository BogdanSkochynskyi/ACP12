package myScanner;

import java.io.IOException;

public class MyScannerTest {
    public static void main(String[] args) throws IOException {
        MyScanner scanner = new MyScanner("/home/sergey/Стільниця/ioTest.txt");

        scanner.next();
        scanner.nextLine();
        System.out.println(scanner.hasNext());
        System.out.println(scanner.hasInt());
    }
}
