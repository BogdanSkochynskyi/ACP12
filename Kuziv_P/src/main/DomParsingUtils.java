package main;


import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.File;


public class DomParsingUtils {

    public static String findByXPath(String xml) throws Exception{

        Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xml));
        XPath xPath = XPathFactory.newInstance().newXPath();
        System.out.println(xPath.compile("/PurchaseOrder/Address[@Type='Billing']/Name").evaluate(d).toString());




        return "";
    }


    public static StringBuffer stringBuffer = new StringBuffer();



    public static String parse(Node node){
        stringBuffer.append("<"+node.getNodeName());
        for (int i = 0; i <node.getAttributes().getLength(); i++) {
            stringBuffer.append(" " +node.getAttributes().item(i));
        }

        stringBuffer.append(">");

        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            if(node.getChildNodes().item(i).getNodeName()!="#text" && node.getChildNodes().item(i).getNodeName()!="#comment" ){
                if (node.hasChildNodes())
                    parse(node.getChildNodes().item(i));
            }
            else {
                stringBuffer.append(node.getChildNodes().item(0).getNodeValue());
            }
        }



        stringBuffer.append("</"+node.getNodeName()+">"+"\n");
        return stringBuffer.toString();

    }

}
