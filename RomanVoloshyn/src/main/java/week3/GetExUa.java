package week3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetExUa {

    final private static int CORES = Runtime.getRuntime().availableProcessors();
    final private static String PREFIX_LINK = "http://www.ex.ua";

    final private static String CSS_QUERY_PAGES = "a[href~=/\\w+.r=\\S+&p=\\d+]";
    final private static String CSS_QUERY_LOADS = "a[href~=/load/\\d+$]";//"a[href^=/load]";
    final private static String CSS_QUERY_LINKS = "a[href~=/\\w+.r=[\\d,]+$]";

    final private static Pattern PATTERN_PARENT_INDEX = Pattern.compile("[?]r=\\d+($|&)");
    final private static Pattern PATTERN_PAGE_NUMBER = Pattern.compile("&p=(\\d+)$");

    public static void main(String[] args) {

        List<String> linksList = new ArrayList<>();
        String target = "http://www.ex.ua/ru/audio";
        collectAllLinks(target, linksList, false);
//        String target = "http://www.ex.ua/3?r=23776&p=4";
//        String target = "http://www.ex.ua/98261610?r=28712,23776";

    }

    public static void collectAllLinks(String target, List<String> linksList, boolean ignorePages) {

        Document document = null;
        try {
            document = Jsoup.parse(new URL(target), 1000);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //links
        Element body = document.body();
        Elements elements = body.select(CSS_QUERY_LOADS);
        if (elements.size() == 0) {
            elements = body.select(CSS_QUERY_LINKS);
        }

        boolean parentContainsPrefix = PATTERN_PARENT_INDEX.matcher(target).find();
        for (Element e : elements) {
            String link = e.attr("href");
            if ((parentContainsPrefix ? !PATTERN_PARENT_INDEX.matcher(link).find() : true) && !linksList.contains(link)) {
                linksList.add(PREFIX_LINK + link);
                collectAllLinks(PREFIX_LINK + link, linksList, false);
            }
        }

        //pages
        if (!ignorePages) {
            parsePages(target, body, linksList);
        }
    }

    public static void parsePages(String target, Element body, List<String> linksList) {

        int maxPage = 0;
        Elements elements = body.select(CSS_QUERY_PAGES);
        if (elements.size() != 0) {

            for (Element e : elements) {
                String link = e.attr("href");
                Matcher matcher = PATTERN_PAGE_NUMBER.matcher(link);
                if (matcher.find()) {

                    int n = Integer.parseInt(matcher.group(1));
                    maxPage = Math.max(maxPage, n);
                }
            }

            for (int i = 1; i <= maxPage; i++) {
                collectAllLinks(target + "&p=" + i, linksList, true);
            }
        }
    }
}
