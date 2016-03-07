package week3;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLToStringParser {

    private static StringBuilder xmlContent = new StringBuilder();
    public static final String PATH_XML = "SerhiiBilobrov/resources/company.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

        // document - xml
        Document xmlDoc = documentBuilder.parse(new File(PATH_XML));
        Element root = xmlDoc.getDocumentElement();
        showNode(root);
        System.out.println(xmlContent.toString());

    }

    public static void checkChildNodes(NodeList nodeList){
        for (int i = 0; i < nodeList.getLength(); i++) {
            showNode(nodeList.item(i));
        }
    }

    public static void showNode(Node node){
        if(node.getNodeType() == Node.ELEMENT_NODE){

            xmlContent.append(String.format("<%s", node.getNodeName()));
            getAttr(node);
            xmlContent.append(String.format(">", node.getNodeName()));

            checkChildNodes(node.getChildNodes());
            xmlContent.append(String.format("</%s>", node.getNodeName()));
        } else if(node.getNodeType() == Node.TEXT_NODE){
            xmlContent.append(node.getTextContent());
        }
    }

    public static void getAttr(Node node){
        NamedNodeMap attr = node.getAttributes();
        for (int i = 0; i < attr.getLength(); i++) {
            xmlContent.append(" " + attr.item(i).getNodeName() + "=" + attr.item(i).getNodeValue());
        }
    }

}
