package ex_downloader;



import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by ARTEM on 02.03.2016.
 */
public class TestDownloader {

    public static void main(String[] args) throws IOException, URISyntaxException, ParserConfigurationException {
        String link = "http://www.ex.ua/98869320?r=3,23776";
        String path = "C:\\Users\\ARTEM\\IdeaProjects\\ACP12\\ArtemBrytchenko\\src\\downloads\\";

        Downloader.download(link, path);



    }


}
