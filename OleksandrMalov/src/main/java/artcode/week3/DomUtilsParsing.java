package main.java.artcode.week3;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.Attribute;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;


/**
 * Created by Олександр on 27.02.2016.
 */
public class DomUtilsParsing {


    public static void parse(String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(new File(Constants.PATH));

        Element root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        Element element = null;
        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
                element = (Element) node;

        }
        NodeList nodeElementList = element.getChildNodes();
        for (int i = 0; i < nodeElementList.getLength(); i++) {
            Node node = nodeElementList.item(i);

            if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
                Attribute attribute = (Attribute) node;
                System.out.println(attribute.getValue());
            }
        }
    }


    public static String parrse(String xml) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xml));

        XPath xPath = XPathFactory.newInstance().newXPath();
        String path = "//user[address[city='Kiev']]";
        String res = xPath.compile("/team/user[@id = '1']/address").evaluate(document);
        String res1 = xPath.compile(path).evaluate(document);
        System.out.println(res1);
        return res1;


}










    // <team>...</team>
    public static String parse(Element root){
        return null;
    }


}
