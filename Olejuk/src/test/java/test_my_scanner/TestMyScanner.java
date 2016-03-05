package test_my_scanner;

import my_scanner.MyScanner;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by dexter on 23.02.16.e
 */
public class TestMyScanner {

    @Test
    public void testNextLine() throws Exception{
        MyScanner scanner = new MyScanner(new File("./src/test/resources/nextLineTestFile.txt"));
        Assert.assertEquals("nextLine test file\n", scanner.nextLine());
    }

    @Test
    public void testNext() throws Exception{
        MyScanner scanner = new MyScanner(new File("./src/test/resources/nextLineTestFile.txt"));
        Assert.assertEquals("nextLine", scanner.next());
    }

    @Test
    public void testNextInt() throws Exception{
        MyScanner scanner = new MyScanner(new File("./src/test/resources/nextIntTestFile.txt"));
        Assert.assertEquals(123, scanner.nextInt());
    }

    @Test
    public void testHasInt() throws Exception{
        MyScanner scanner = new MyScanner(new File("./src/test/resources/nextIntTestFile.txt"));
        if(scanner.hasInt()){
            Assert.assertEquals(123, scanner.nextInt());
        }
    }

    @Test
    public void testHasNext() throws Exception{
        MyScanner scanner = new MyScanner(new File("./src/test/resources/nextLineTestFile.txt"));
        MyScanner scanner2 = new MyScanner(new File("./src/test/resources/emptyFile.txt"));
        Assert.assertTrue(scanner.hasNext());
        Assert.assertTrue(scanner.hasNext());
        Assert.assertFalse(scanner2.hasNext());
        scanner.nextLine();
        Assert.assertFalse(scanner.hasNext());
    }

    @Test
    public void testReadBigFiles() throws Exception{
        MyScanner scanner = new MyScanner(new File("./src/test/resources/bigFile.txt"));
        String str = "";
        while(scanner.hasNext()){
            str += scanner.nextLine();
        }

        Assert.assertEquals(305, str.indexOf("including"));
    }

}
