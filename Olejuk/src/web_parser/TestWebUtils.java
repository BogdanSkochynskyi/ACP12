package web_parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.*;
import java.util.Scanner;

/**
 * Created by dexter on 28.02.16.
 */
public class TestWebUtils {

    public static final String PATH = "/home/dexter/Java/IdeaProjects/ACP12/Olejuk/resources/company.xml";

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        System.out.println(WebUtil.findByXPath(PATH));
    }
}
