
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by Олена on 28.02.2016.
 */
public class TestMyXPathParser {

    private static final String PATH = "C:\\Users\\Олена\\IdeaProjects\\ACP12\\SerhiiBilobrov\\resources\\company.xml";

    public static void main(String[] args) {
        try {
            MyXPathParser.findByXPath(PATH);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }


}
