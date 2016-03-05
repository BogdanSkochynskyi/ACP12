package myScanner;

import java.io.FileReader;
import java.io.IOException;

public class TestMyScanner {

    public static void main(String[] args) throws IOException, InterruptedException {

        MyScanner msc = new MyScanner(System.in);
        msc.nextLine();

//        // http://www.ex.ua/144968917177
//        FileReader fr = new FileReader("C:\\1c_exchange.log");
//        MyScanner msc = new MyScanner(fr);
//
//
//        int counter = 0;
//        while (true) {
//            int res = msc.nextInt();
//            if (res == 0) {
//                break;
//            }
//            counter++;
//            System.out.println(res);
//
//        }
//
//        System.out.println(counter);
//
//
//        counter = 0;
//        while (true) {
//            String res = msc.next();
//            if (res == null || res.isEmpty()) {
//                break;
//            }
//            counter++;
//            System.out.println(res);
//
//        }
//
//        System.out.println(counter);
    }

}
