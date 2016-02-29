
import jdk.nashorn.internal.objects.DataPropertyDescriptor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class RunDomParser {

    public static void main(String[] args) throws Exception {
        //DomParsingUtils.parse(Constants.PATH);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        // document - xml
        Document document = documentBuilder.parse(new File(Constants.PATH));

        Element root = document.getDocumentElement();



        System.out.println(DomParsingUtils.parse(root));

        System.out.println(DomParsingUtils.findByXPath(Constants.PATH));


    }
}
