package web_loader;

import java.io.IOException;

/**
 * Created by dexter on 17.03.16.
 */
public class TestSurf {

    private static final String testWebPath = "http://rozetka.com.ua";

    public static void main(String[] args) {
        Loader surfer = new Loader();
        surfer.surfingPage(testWebPath);
        System.out.println("*************************************************************");
        surfer.showAllImgLinks();
    }
}
