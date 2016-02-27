package week3;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MyParser {

    private StringBuilder res;

    MyParser(Document document) {
        res = new StringBuilder();
        res.append("<?xml version=\""+document.getXmlVersion()+"\"?>" + "\r\n");
    }

    public String parse(Node root){

        formatOpen(root); //open tag

        if(root.hasChildNodes()){
            NodeList children = root.getChildNodes();

            for(int i = 0; i<children.getLength();i++){
                parse(children.item(i)); //recursive call
            }

        }

        formatClose(root); //close tag

        return res.toString();
    }

    protected void formatOpen(Node node){

        String nodeName = node.getNodeName();
        NamedNodeMap attrs = node.getAttributes();

        if(!nodeName.contains("#")) {
            res.append("<" + nodeName);
        }

        if(node.hasAttributes()){
            for(int i = 0; i< attrs.getLength();i++) {
                res.append(" "+attrs.item(i));
            }
        }

        if(node.getNodeValue()!=null) {
            res.append(node.getNodeValue());
        }

        if(!nodeName.contains("#text")) {
            res.append(">");
        }
    }

    protected void formatClose(Node node){

        String nodeName = node.getNodeName();

        if(!nodeName.contains("#text")) {
            res.append("</" + nodeName + ">");
        }

    }

}
