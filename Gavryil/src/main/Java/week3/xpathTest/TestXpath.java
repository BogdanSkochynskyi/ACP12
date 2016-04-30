package week3.xpathTest;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by gavri on 28.04.2016.
 */
public class TestXpath {
    public static void main(String[] args) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().
                    newDocumentBuilder().parse(new File
                    ("Gavryil/src/main/resources/company.xml"));

            String request = "//user";

            XPath xPath = XPathFactory.newInstance().newXPath();

          XPathExpression xPathExpression = xPath.compile(request);

           NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);

           String result;

            for (int i = 0; i < nodeList.getLength(); i++){
                result = nodeList.item(i).getTextContent();
                System.out.println(nodeList.item(i).getNodeName());
                System.out.println(result);
           }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}
