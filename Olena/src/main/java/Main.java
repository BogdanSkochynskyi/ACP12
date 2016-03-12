


import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Олена on 21.02.2016.
 */
public class Main {
    public static void main(String[] args) {

        TestMyScanner test = new TestMyScanner();
        try {
            test.preTest("C:\\Users\\Олена\\IdeaProjects\\ACP12\\Olena\\positive.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            test.positiveTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
