package ua.artcode.week3.scanner;


import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by serhii on 28.02.16.
 */
public class TestMyScanner {

    private MyScannerG scanner;

    @Before
    public void setUp(){
        String source = new String("12 34 next line\nnext line");
        scanner = new MyScannerG(source);
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testNext(){
        String actual = scanner.next();
        String expected = "12";
        Assert.assertEquals(expected, actual);
    }

    @Ignore
    //@Test(expected = Throwable.class)
    public void testNextExcepction() throws Exception {
        //scanner.close();
        scanner.next();
    }

    @Test
    public void hasNext(){
        boolean condition = scanner.hasNext();
        Assert.assertTrue(condition);
    }


    @Test
    public void testNextInt(){
        int actual = scanner.nextInt();
        int expected = 12;
        Assert.assertEquals(expected, actual);
    }

    public void textNextLine(){

    }



}
