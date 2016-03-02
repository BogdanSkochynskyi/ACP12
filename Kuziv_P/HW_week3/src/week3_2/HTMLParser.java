package week3_2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HTMLParser  {

    public static void main(String[] args) throws Exception   {

        Document document = Jsoup.parse(new URL("http://www.ex.ua/96058160"),999);
        Element e = document.body();
        Elements elements = e.getElementsByTag("a");
        List<String > linksList = new ArrayList<>();
        int i =1;
        for (Element element : elements ) {
            if(element.attr("href").contains("/load") && !element.attr("href").contains("id")){

               linksList.add(element.attr("href"));
               NetUtils.load(element.attr("href"), "Song_"+i+".mp3");
               System.out.println(i+" song download");
               i++;

            }

        }


    }
}
