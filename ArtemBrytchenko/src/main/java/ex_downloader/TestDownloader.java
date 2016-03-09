package ex_downloader;



import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by ARTEM on 02.03.2016.
 */
public class TestDownloader {

    public static void main(String[] args) throws IOException, URISyntaxException, ParserConfigurationException {
        String link = "http://www.ex.ua/99011847?r=3,23776";
        String path = "D:\\download\\idea files\\";

        Downloader.download(link, path);



    }


}
