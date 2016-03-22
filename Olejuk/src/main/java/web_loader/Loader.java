package web_loader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.List;

/**
 * Created by dexter on 25.02.16.
 */
public class Loader {

    private StringBuilder content = new StringBuilder();
    private Set<String> paths = new HashSet<>();
    private Set<String> images = new HashSet<>();

    public void load(String webPath, String directoryPath, String fileType) throws Exception {
        parseHtml(webPath);
        createFiles(directoryPath, fileType);
    }

    private void createFiles(String directoryPath, String fileType)  {
        int numberFile = 1;
        for(String tmp : paths){

            try {
                try (InputStream is = new URI(tmp).toURL().openStream();
                     OutputStream os = new FileOutputStream(directoryPath + "file" + numberFile + "." + fileType)) {

                    byte[] buff = new byte[8000];
                    int count = 0;

                    while ((count = is.read(buff)) != -1) {
                        os.write(buff, 0, count);
                        os.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            System.out.printf("file%s.%s was created\n", numberFile++, fileType);
        }

    }

    private void parseHtml(String webPath) throws IOException {
        Document html = Jsoup.parse(new URL(webPath), 1000);

        Elements elements = html.select("a[href^=http]");

        for(Element tmp : elements){
            paths.add(tmp.attr("href"));
        }

        System.out.println(paths.size() + " files founded");
    }

    public void surfingPage(String webPath) {
        try{
            Document html = Jsoup.parse(new URL(webPath), 1000);

            Elements links = html.select("a[href^=http]");
            Elements img = html.select("img[src^=http]");

            for(Element tmp : links){

                String newLink = tmp.attr("href");
                if(!paths.contains(newLink)){
                    paths.add(tmp.attr(newLink));
                    surfingPage(newLink);
                }

            }

            for(Element tmp : img){
                images.add(img.attr("src"));
            }

            showElements(links);

        }catch (IOException e){
            System.out.println("bad link");
        }
    }

    public void showAllImgLinks(){
        for(String str : images){
            System.out.println(str);
        }
    }

    private void showElements(Elements elements) {
        for (Element element : elements) {
            System.out.println(String.format(" * a: <%s>  (%s)", element.attr("abs:href"), trim(element.text(), 35)));
        }
    }

    private String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }

    @Deprecated
    private void loadHtml(String path) throws IOException, InterruptedException {
        URL url = new URL(path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        char[] chars = new char[1024];
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        while(reader.read(chars, 0, chars.length) != -1){
            content.append(chars);
            chars = new char[1024];
        }

        con.disconnect();
    }

}
