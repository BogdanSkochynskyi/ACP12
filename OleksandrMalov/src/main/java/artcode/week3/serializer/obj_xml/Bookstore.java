package main.java.artcode.week3.serializer.obj_xml;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Олександр on 02.03.2016.
 */
@XmlRootElement(name = "bookstore")
public class Bookstore {

    @XmlElementRef
    Book[] books = new Book[]{new Book(), new Book(), new Book(), new Book()};


//    public  void createAndStart(){
//
//
//
//        try {
//            JAXBContext bookClass = JAXBContext.newInstance(Bookstore.class);
//            Marshaller m = bookClass.createMarshaller();
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // To format XML
//            m.marshal(booksSet, System.out);
//            m.marshal(booksSet, new File("C:\\Users\\Олександр\\Documents\\Git\\ACP12\\OleksandrMalov\\resources\\booksFromObject.xml"));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//
//    }

    public Bookstore() {
    }

    public static void main(String[] args) {


        Book book = new Book("title", "author", 1960, 25);
        ObjectToXmlParser objectToXmlParser = new ObjectToXmlParser();
 //   objectToXmlParser.format(book);
        Bookstore bookstore = objectToXmlParser.parse("C:\\Users\\Олександр\\Documents\\Git\\ACP12\\OleksandrMalov\\src\\main\\resources\\books.xml");
        System.out.println(bookstore.books[0]);
        System.out.println(bookstore.books[1]);
        System.out.println(bookstore.books[2]);
        System.out.println(bookstore.books[3]);


    }
}
