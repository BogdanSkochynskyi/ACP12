package ua.artcode.week3.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
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


    public static String findByXPath(String xml) throws ParserConfigurationException, XPathExpressionException, IOException, SAXException {


        /// get Document from xml path
        Document document = DocumentBuilderFactory.
                newInstance().newDocumentBuilder().parse(new File(xml));

        XPath xPath = XPathFactory.newInstance().newXPath();

        // /*/*/adress[city]
        // send document to evaluate method
        String getUserById = "//user[@id='1']";
        String getAddresOfUser = "//user[@id='1']/address";
        String getUserFromKiev = "//user[address[city='Kiev']]";

        // //user[@id='1']/address

        Node user = (Node) xPath.compile(getUserById)
                .evaluate(document, XPathConstants.NODE);

        NodeList users = (NodeList) xPath.compile(getUserFromKiev)
                        .evaluate(document, XPathConstants.NODESET);

        Node address = (Node) xPath.compile(getAddresOfUser)
                        .evaluate(document, XPathConstants.NODE);

        // get user with id 1
        // get address of user 1
        // get user with city Kiev

        return "";
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        System.out.println(findByXPath(Constants.PATH));
    }

}
