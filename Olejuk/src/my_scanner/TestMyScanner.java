package my_scanner;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by dexter on 23.02.16.e
 */
public class TestMyScanner {

    @Test
    public void testNextLine() throws Exception{
        MyScanner scanner = new MyScanner(new File("./resources/nextLineTestFile.txt"));
        Assert.assertEquals("nextLine test file\n", scanner.nextLine());
    }

    @Test
    public void testNext() throws Exception{
        MyScanner scanner = new MyScanner(new File("./resources/nextLineTestFile.txt"));
        Assert.assertEquals("nextLine", scanner.next());
    }

    @Test
    public void testNextInt() throws Exception{
        MyScanner scanner = new MyScanner(new File("./resources/nextIntTestFile.txt"));
        Assert.assertEquals(123, scanner.nextInt());
    }

    @Test
    public void testHasInt() throws Exception{
        MyScanner scanner = new MyScanner(new File("./resources/nextIntTestFile.txt"));
        if(scanner.hasInt()){
            Assert.assertEquals(123, scanner.nextInt());
        }
    }

    @Test
    public void testHasNext() throws Exception{
        MyScanner scanner = new MyScanner(new File("./resources/nextLineTestFile.txt"));
        MyScanner scanner2 = new MyScanner(new File("./resources/emptyFile.txt"));
        Assert.assertEquals(true, scanner.hasNext());
        Assert.assertEquals(true, scanner.hasNext());
        Assert.assertEquals(false, scanner2.hasNext());
        scanner.nextLine();
        Assert.assertEquals(false, scanner.hasNext());
    }

    @Test
    public void testReadBigFiles() throws Exception{
        MyScanner scanner = new MyScanner(new File("./resources/bigFile.txt"));
        String str = "";
        while(scanner.hasNext()){
            str += scanner.nextLine();
        }

        Assert.assertEquals(305, str.indexOf("including"));
    }

}
