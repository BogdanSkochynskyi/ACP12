


import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestMyParser {

    private static final String PATH = "C:\\Users\\Олена\\IdeaProjects\\ACP12\\Olena\\Olena.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(PATH));

        MyParser my = new MyParser(document);
        String actual = my.parse(document.getDocumentElement());
        System.out.println(actual);
        Scanner scanner = new Scanner(new File(PATH));

        //test parse()
        StringBuilder expected = new StringBuilder();
        scanner.useDelimiter("$");

        while(scanner.hasNext()) {
            expected.append(scanner.next());
        }
        String expectedString = expected.toString().replace("\r","");
        String actualString = actual.toString().replace("\r","");

        System.out.println(expectedString);
        System.out.printf("test parse(): passed: %s\n",(expectedString.equals((actualString))));


    }
}
