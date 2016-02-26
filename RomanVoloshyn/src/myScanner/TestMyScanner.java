package myScanner;

import java.io.FileReader;
import java.io.IOException;

public class TestMyScanner {

    public static void main(String[] args) throws IOException, InterruptedException {

        FileReader fr = new FileReader("C:\\profiles_settings.xml");
        MyScanner msc = new MyScanner(fr);

        while (true) {
            String res = msc.next();
            if (res == null || res.isEmpty()) {
                break;
            }
            System.out.println(res);

        }

    }

}
