package web_loader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.List;

/**
 * Created by dexter on 25.02.16.
 */
public class ImageLoader {

    private StringBuilder content = new StringBuilder();
    private List<String> paths = new ArrayList<>();

    public void load(String webPath, String directoryPath, String fileName) throws Exception {
        loadHtml(webPath);
        parseHtml();
        createFiles(directoryPath, fileName);
    }

    private void createFiles(String directoryPath, String fileName) {
        BufferedImage img;
        int numberImage = 1;
        URL url;
        for(String tmp : paths){
            try{
                url = new URL(tmp);
                img = ImageIO.read(url);
                if (img != null){
                    // for jpg
                    ImageIO.write(img, "jpg",new File(directoryPath + fileName +"_" + numberImage++));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void parseHtml() {
        Document html = Jsoup.parse(content.toString());
        List<String> imgPaths = new ArrayList<>();

        Elements elements = html.select("img");

        for(Element tmp : elements){
            imgPaths.add(tmp.attr("src"));
        }

        for(String tmp : imgPaths){
            if(tmp.startsWith("http")){
                paths.add(tmp);
            }
        }
    }

    private void loadHtml(String path) throws IOException, InterruptedException {
        URL url = new URL(path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        char[] chars = new char[1024];
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        while(reader.read(chars, 0, chars.length) == 1024){
            content.append(chars);
            Thread.sleep(100);
            chars = new char[1024];
        }

        con.disconnect();
    }
}
