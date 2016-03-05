package ua.artcode.utils;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParser {


    public static void main(String[] args) throws IOException {

        List<String> linksList = new ArrayList<>();

        Document document = Jsoup.parse(new URL("http://www.ex.ua/98554142?r=71793,23776"),1000);
        Element el = document.body();
        Elements elements = el.select("a[href^=/load]");
        for (Element element : elements) {
            linksList.add(element.attr("href"));
        }


        linksList.stream().forEach(System.out::println);




    }

}
