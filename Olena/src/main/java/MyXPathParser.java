
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Олена on 28.02.2016.
 */
public class MyXPathParser {

    public static void findByXPath(String xml) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xml));
        XPath xPath = XPathFactory.newInstance().newXPath();

        System.out.println(xPath.compile("//user[@id='1']").evaluate(document));
        System.out.println(xPath.compile("//user[@id='1']/address").evaluate(document));
        System.out.println(xPath.compile("//user[address[city='Kiev']]/address").evaluate(document));

    }
}
