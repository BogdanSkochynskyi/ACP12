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

    public void load(String webPath, String directoryPath, String fileType) throws Exception {
        loadHtml(webPath);
        parseHtml();
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

    private void parseHtml() {
        Document html = Jsoup.parse(content.toString());
        List<String> imgPaths = new ArrayList<>();

        Elements elements = html.select("a");

        for(Element tmp : elements){
            imgPaths.add(tmp.attr("href"));
        }

        for(String tmp : imgPaths){
            if(tmp.startsWith("http")){
                paths.add(tmp);
            }
        }

        System.out.println(paths.size() + " files founded");
    }

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
