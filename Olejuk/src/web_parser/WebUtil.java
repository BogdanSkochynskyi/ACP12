package web_parser;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dexter on 28.02.16.
 */
public class WebUtil {

    public static String findByXPath(String path) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        Document document  = DocumentBuilderFactory.newInstance().
                newDocumentBuilder().parse(new File(path));

        XPath xPath = XPathFactory.newInstance().newXPath();

        //return xPath.compile("//user[@id='1']/adress").evaluate(document);

        InputSource iSource = new InputSource(new FileInputStream(path));

        String str = xPath.compile("//user[city='Kiev']").evaluate(iSource);

        return str;
    }
}
