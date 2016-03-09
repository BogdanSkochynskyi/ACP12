package week4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyImageLoader {

    private static final int BUFFER_SIZE = 1024;
    private List<URL> links = new ArrayList<>();

    public void loadImages(String url) throws IOException {

        Document document = Jsoup.parse(new URL(url),1000);
        Elements elements = document.body().getElementsByTag("a");

        for(Element e: elements){

            String attr = e.attr("href");

            if(attr.startsWith("/load")&&!attr.contains("?")){
                links.add(new URL("http://www.ex.ua"+attr));
            }
        }

        for(URL link: links){

            InputStream in = new BufferedInputStream(link.openStream());
            FileOutputStream out = new FileOutputStream("Olena\\src\\main\\resources\\"+link.toString().substring(22)+".jpeg");
            byte[] buf = new byte[BUFFER_SIZE];

            int n = 0;
            while ((n=in.read(buf))!=-1){
                out.write(buf, 0, n);
            }

            out.close();
            in.close();

        }

    }

}
