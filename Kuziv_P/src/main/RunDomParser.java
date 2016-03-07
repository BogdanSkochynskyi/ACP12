package main;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class RunDomParser {
    public static final String PATH = "company.xml";
    public static void main(String[] args) throws Exception {
        //DomParsingUtils.parse(Constants.PATH);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(PATH));

        Element root = document.getDocumentElement();
        System.out.println(DomParsingUtils.parse(root));

       // System.out.println(DomParsingUtils.findByXPath(PATH));


    }
}

