package week3_2; /**
 * Created by Петро on 01.03.2016.
 */
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class NetUtils {

    public static void load(String url, String dest)
            throws URISyntaxException, IOException {

        try (InputStream is = new URI("http://www.ex.ua"+url).toURL().openStream();
             OutputStream os = new FileOutputStream("download/"+dest)){

            byte[] buff = new byte[8000];
            int count = 0;

            while((count = is.read(buff)) != -1){
                os.write(buff, 0, count);
                os.flush();
            }
        }

    }

}