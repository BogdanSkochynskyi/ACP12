package week3.vkParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gavri on 11.03.2016.
 */
public class VkParser {

    public static final String VK_SEARCH_PAGE = "http://vk.com/search?c%5Bage_from%5D=14&c%5Bage_to%5D=35&c%5Bcity%5D=314&c%5Bcountry%5D=2&c%5Bname%5D=1&c%5Bphoto%5D=1&c%5Bsection%5D=people";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.parse(new URL(VK_SEARCH_PAGE),10000);
            Element body = doc.body();
            Elements elements = body.getElementsByAttributeValueContaining("onclick","return nav.go(this, event);");
            System.out.println(elements.size());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {http://vk.com/search?c%5Bage_from%5D=14&c%5Bage_to%5D=35&c%5Bcity%5D=314&c%5Bcountry%5D=2&c%5Bname%5D=1&c%5Bphoto%5D=1&c%5Bsection%5D=people
            e.printStackTrace();
        }
    }
}
