package ex_downloader;



import org.jsoup.Jsoup;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ARTEM on 02.03.2016.
 */
public class Downloader {

    public static List<String> parse(String link) throws URISyntaxException, IOException {

        String html = String.valueOf(Jsoup.parse(new URL(link), 1000));

        Set<String> linksList = new HashSet<>();

//        (?!.*fs_id)   //not working regexp

        Pattern pattern = Pattern.compile("(/load)+/+\\d+");

        Matcher matcher = pattern.matcher(html);

        while(matcher.find()) {
            linksList.add("http://www.ex.ua" + matcher.group(0));
        }

        Iterator<String> iter = linksList.iterator();
        List<String> uniqLinks = new ArrayList<>();

        while (iter.hasNext()){
            uniqLinks.add(iter.next());
        }

        return uniqLinks;
    }

    /*public static String nameCreator(){

    }*/

    public static void download(String link, String filepath) throws URISyntaxException, IOException, ParserConfigurationException {

        List<String> listOfLinks = parse(link);

        int totalsize = listOfLinks.size(), namecounter = 0;

        for (int i = 0; i < totalsize; i++) {

            try (InputStream is = new URI(listOfLinks.get(i)).toURL().openStream();
                    OutputStream os = new BufferedOutputStream(new FileOutputStream(filepath+"file"+namecounter+".mp3"))) {

                namecounter++;
                int count;

                while ((count = is.read()) != -1) {
                    os.write(count);
                    os.flush();
                }
                System.out.println("Progress: " + (i+1) + " of " + " all " + totalsize + " song are downloaded");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
