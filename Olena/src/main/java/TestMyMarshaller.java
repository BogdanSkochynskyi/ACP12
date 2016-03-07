

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;


public class TestMyMarshaller {

    public static void main(String[] args) {

        Book book = new Book(0, "Bruce Eckel", "Thinking in Java");
        String PATH = "\\Olena\\src\\main\\resources\\book.xml";

        MyMarshaller my = new MyMarshaller();

        try {
            File myMarshalledFile = my.objectToXML(book,PATH);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            Book newBook = (Book)my.XMLToObject(PATH);
            System.out.println(newBook.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
