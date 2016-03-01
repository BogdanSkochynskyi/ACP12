package parsing_xml_to_string;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

public class ParseTask {
    private static final String PATH = "C:/Users/ARTEM/IdeaProjects/ACP12/ArtemBrytchenko/src/usable_files/xml_parsing_task";



    public static String parse(Element root){
        StringBuilder sb = new StringBuilder();
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element el = (Element) node;
                sb.append(el.getTagName());
                System.out.println(el.getTagName());
            } else if(node.getNodeType() == Node.TEXT_NODE){
            }
        }
        return null;
    }

}
