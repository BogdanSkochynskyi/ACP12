package my_scanner;


import java.io.IOException;

public class TestScanner {


    public static void main(String[] args) throws IOException {
        // uncomment to test scanner using file of strings
        MyScanner myScanner = new MyScanner("C:/Users/ARTEM/IdeaProjects/ACP12/ArtemBrytchenko/src/usable_files/string_test1");

        System.out.print(myScanner.next());
        System.out.print(myScanner.next());
        System.out.print(myScanner.next());
        System.out.print(myScanner.next());
        System.out.print(myScanner.next());
//        System.out.println(myScanner.nextLine());
//        System.out.println(myScanner.nextLine());
//        System.out.println(myScanner.hasNext());
//        System.out.println(myScanner.nextInt());
//        System.out.println(myScanner.hasNextInt());


    }
}
