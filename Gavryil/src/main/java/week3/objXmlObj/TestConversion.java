package week3.objXmlObj;

import org.xml.sax.SAXException;
import week3.domParsing.DomParsingUtils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by gavri on 06.03.2016.
 */
public class TestConversion {

    public static final String XML_PATH = "Gavryil/src/main/resources/TestObject.xml";

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ParserConfigurationException, IOException, SAXException {
        TestObject object = new TestObject("Me",24,700,"Kyiv");

        String xmlObject = object.toXml();
        DomParsingUtils.stringToXml(xmlObject, XML_PATH);

        String result = DomParsingUtils.parseDoc(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(XML_PATH)));
        System.out.println(result);

        TestObject clone = new TestObject();
        clone.getFieldsFromXml(new File(XML_PATH));
        System.out.println("****************");
        System.out.println(clone);
    }
}
