package week3.domParsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by gavri on 04.03.2016.
 */
public class SaxParserTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        saxParser.parse(new File("Gavryil/src/main/resources/company.xml"),new MyHandler());
    }

     static class MyHandler extends DefaultHandler {

         @Override
         public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
             System.out.printf("<%s>",qName);
         }

         @Override
         public void endElement(String uri, String localName, String qName) throws SAXException {
             System.out.printf("</%s>",qName);
         }

         @Override
         public void characters(char[] ch, int start, int length) throws SAXException {
             System.out.print(String.valueOf(ch,start,length));
         }
     }
}