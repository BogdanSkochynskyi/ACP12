package week3.downloadUtil;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

/**
 * Created by gavri on 05.03.2016.
 */
public class DownloaderTest {

    public static final String URL = "http://www.ex.ua/11656119";
    public static final String DEST = "E:\\download\\";

    public static void main(String[] args) throws IOException, ParserConfigurationException {
       // MyDownloader.load(URL, DEST);

     MyDownloader.groupDownload(new URL(URL),DEST,"mp3");




    }
}
