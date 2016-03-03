package face_book_search;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dexter on 01.03.16.
 */
public class Test {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Enter your email
        System.out.print("Enter your email - ");
        String email = br.readLine();

        //Enter your pass
        System.out.print("Enter your pass - ");
        String pass = br.readLine();

        try {
            FaceBookSearcher fb = FaceBookSearcher.logIn(email, pass);
        } catch (LogException e) {
            System.out.println(e.getMessage());
        }
    }
}
