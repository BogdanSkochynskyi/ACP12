package week4;

import blasoUtils.Scanner_BS;

import java.io.IOException;

/**
 * Created by serhii on 04.03.16.
 */
public class TestClassInfo {


    public static void main(String[] args){

        Scanner_BS myScanner;
        try {
            myScanner = new Scanner_BS("hjksahdjksdfhi");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String myScannerString = RTTIUtils.toString(myScanner);
        System.out.println(myScannerString);

        RTTIUtils.fromString(myScannerString);
        //OutputStreamWriter osw = new OutputStreamWriter(myScannerString);


    }
}
