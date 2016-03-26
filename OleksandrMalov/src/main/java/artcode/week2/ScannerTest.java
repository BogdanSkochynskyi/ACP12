package main.java.artcode.week2;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.FileReader;

public class ScannerTest extends TestCase {

    public void testNext() throws Exception {
        Scanner scanner = new Scanner(new FileReader("C:\\Users\\Олександр\\Documents\\Git\\ACP12\\OleksandrMalov\\resources\\nextTest.txt"));
        Assert.assertEquals("nextTest", scanner.next());
    }
}