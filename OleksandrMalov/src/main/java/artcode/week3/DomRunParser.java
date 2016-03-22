package main.java.artcode.week3;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by Олександр on 27.02.2016.
 */
public class DomRunParser {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        //DomUtilsParsing.parse(Constants.PATH);
        //ParserXML.runParse(Constants.PATH);
        DomUtilsParsing.parrse(Constants.PATH);
    }
}
