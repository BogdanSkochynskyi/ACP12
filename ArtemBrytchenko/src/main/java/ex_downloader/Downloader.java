package ex_downloader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;


public class Downloader {

    public static Map<String, String> parse(String link) throws URISyntaxException, IOException {

        Document doc = Jsoup.parse(new URL(link), 10000);

        Elements el1 = doc.select("a[href^=/get][title]");

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < el1.size(); i++) {
            map.put(el1.get(i).attr("href"), el1.get(i).attr("title"));
        }

        return map;
    }

    public static void download(String link, String filepath) throws URISyntaxException, IOException, ParserConfigurationException {

        Map<String, String> listOfLinks = parse(link);

        int totalsize = listOfLinks.size(), counter = 1;

        for (Map.Entry<String, String> entries : listOfLinks.entrySet()){

            try (InputStream is = new URI("http://ex.ua" + entries.getKey()).toURL().openStream();
                 OutputStream os = new FileOutputStream(filepath + entries.getValue())) {

                int count;

                while ((count = is.read()) != -1) {
                    os.write(count);
                    os.flush();
                }
                System.out.println("Progress: " + (counter++) + " of " + totalsize + " files are downloaded");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
