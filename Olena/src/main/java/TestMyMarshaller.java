import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TestMyMarshaller {

    public static void main(String[] args) {

        Book book = new Book(0, "Bruce Eckel", "Thinking in Java");
        String PATH_XML = "Olena/src/main/resources/book.xml";
        String PATH_JSON = "Olena/src/main/resources/book.json";

        MyMarshaller my = new MyMarshaller();

        try {

            my.objectToXML(book, PATH_XML);
            my.objectToJson(book,PATH_JSON);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            Book bookXML = (Book)my.XMLToObject(PATH_XML);
            Book bookJson = (Book)my.jsonToObject(PATH_JSON);
            System.out.println(bookXML.toString());
            System.out.println(bookJson.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}