package ua.artcode.week3;

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
 * Created by Олександр on 27.02.2016.
 */
public class ParserXML {

    public static void runParse(String path) throws ParserConfigurationException, IOException, SAXException {

    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

    Document root = documentBuilder.parse(new File(Constants.PATH));

        visit(root, 0);

    }

    public static void visit(Node root, Integer level){
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            process(node, level + 1);
            visit(node, level + 1);
        }
    }

    public static void process(Node node, Integer level){
        for (int i = 0; i < level; i++) {
            System.out.print('\t');
        }
        System.out.print(node.getNodeName());
        if (node instanceof Element){
            Element element = (Element)node;
            System.out.println(element.getTagName());
        }
        System.out.println();
    }
}
