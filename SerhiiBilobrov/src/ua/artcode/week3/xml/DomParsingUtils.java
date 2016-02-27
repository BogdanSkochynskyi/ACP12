package ua.artcode.week3.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by serhii on 27.02.16.
 */
public class DomParsingUtils {


    public static void parse(String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        // document - xml
        Document document = documentBuilder.parse(new File(path));

        Element root = document.getDocumentElement();// root -> team


        System.out.printf("root %s, att %s\n", root.getTagName(), root.getAttribute("id"));


        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element el = (Element) node;
                System.out.println(el.getTagName());
            } else if(node.getNodeType() == Node.TEXT_NODE){

            }


        }

        System.out.println( " size " + nodeList.getLength());



    }



    // <team>...</team>
    public static String parse(Element root){
        return null;
    }


}
