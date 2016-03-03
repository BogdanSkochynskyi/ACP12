package face_book_search;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by dexter on 01.03.16.
 */
public class Test {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {

        String email = ""; //Enter your email
        String pass = ""; //Enter your pass

        FaceBookSearcher fb = new FaceBookSearcher(email, pass);
    }
}
