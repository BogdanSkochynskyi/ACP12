package face_book_search;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dexter on 01.03.16.
 */
public class FaceBookSearcher {

    public final String yourPage;
    public String currentPage;
    private String pageSource;

    // path for example :
    // https://www.facebook.com/vasilishin.oleg
    public FaceBookSearcher(String path) throws MalformedURLException{
        yourPage = path;
        currentPage = yourPage;
        pageSource = loadPage(currentPage);
    }

    // download all page... for future search
    private String loadPage(String path) throws MalformedURLException {
        URL url = new URL(path);
        StringBuilder stringBuilder = new StringBuilder();
        int kB = 8;

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            char[] buff = new char[8192];

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while(br.read(buff) != -1){
                stringBuilder.append(buff);
                buff = new char[8192];
                kB += 8;
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(kB + " Kb was loaded");
        //System.out.println(stringBuilder.toString());


        return stringBuilder.toString();
    }

    public int getAllFriends() throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {

        currentPage = yourPage + "/friends_all";
        currentPage = "https://habrahabr.ru/post/152971/";
        pageSource = loadPage(currentPage);

//        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(currentPage);

        XPath xPath = XPathFactory.newInstance().newXPath();
        //String str = xPath.compile("//*[@id=\"u_jsonp_2_0\"]").evaluate(document);
        Node node = (Node) xPath.compile("//*[@id=\"post_152971\"]/h1/span").evaluate(pageSource, XPathConstants.NODE);

        System.out.println(node.toString());

        return 0;
    }
}
