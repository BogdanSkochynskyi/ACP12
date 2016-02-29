

import java.io.IOException;
import java.net.URISyntaxException;


public class TestNetUtils {


    public static void main(String[] args) throws IOException, URISyntaxException {
        NetUtils.load("http://www.ex.ua/get/209542176", "resources/TAPTAK.mp3");
    }
}
