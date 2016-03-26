package main.java.artcode.week2;

import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 * Created by Олександр on 25.02.2016.
 */
public class TestScanner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("C:\\Users\\Олександр\\Documents\\Git\\ACP12\\OleksandrMalov\\resources\\nextTest.txt"));
        scanner.useDelimiter("/n");
        //Scanner sc = new Scanner("05809 23095 ");
        //while (sc.hasNextInt())
            //System.out.println(sc.nextInt());
        //sc.close();
        while (scanner.hasNext())
            System.out.println(scanner.next());
        scanner.close();

    }


}

