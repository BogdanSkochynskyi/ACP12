package MyScanner;


import java.io.IOException;

public class TestScanner {
    public static void main(String[] args) throws IOException {
        MyScanner myScanner = new MyScanner(System.in);
        System.out.println(myScanner.next());
    }
}
