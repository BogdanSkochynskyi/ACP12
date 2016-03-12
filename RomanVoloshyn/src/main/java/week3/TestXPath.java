package week3;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import java.io.File;
import java.io.IOException;

public class TestXPath {
    private static StringBuilder xmlContent = new StringBuilder();
    public static final String PATH_XML = "SerhiiBilobrov/resources/company.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document xmlDoc = documentBuilder.parse(new File(PATH_XML));
        XPath xpath = XPathFactory.newInstance().newXPath();

        System.out.println(xpath.compile("//*[city='Kiev']").evaluate(xmlDoc));

//        System.out.println("User id = 1");
//        System.out.println(xpath.compile("//user[@id='1']").evaluate(xmlDoc));
//
//        System.out.println("User id = 1 / address");
//        System.out.println(xpath.compile("//user[@id='1']/address").evaluate(xmlDoc));
//
//        System.out.println("User city = Kiev");
//        System.out.println(xpath.compile("//user[address[city='Kiev']]").evaluate(xmlDoc));

    }
}
