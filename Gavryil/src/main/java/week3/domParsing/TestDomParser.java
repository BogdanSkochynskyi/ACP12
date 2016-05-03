package week3.domParsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by gavri on 04.03.2016.
 */
public class TestDomParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file2 = new File("Gavryil/src/main/resources/books.xml");
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file2);
        Element element = doc.getDocumentElement();

        //System.out.println("<?xml version="+"\""+doc.getXmlVersion()+"\"" + " encoding="+"\""+doc.getXmlEncoding()+"\""+"?>");
       // System.out.println(DomParsingUtils.parse(element));
        System.out.println(DomParsingUtils.parseDoc(doc));

        DomParsingUtils.stringToXml(DomParsingUtils.parseDoc(doc),"Gavryil/src/main/resources/tryToSave.xml");
    }
}
