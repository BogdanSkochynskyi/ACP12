package main.java.artcode.week3.serializer.obj_json;

import main.java.artcode.week3.serializer.obj_xml.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Created by Олександр on 01.03.2016.
 */
public class Formater {

    public static Map<Integer, Book> booksMap = new HashMap<Integer, Book>();

    public static void formatTo(HashSet<Book> books) {

//        GsonBuilder gsonBuilder = new GsonBuilder();
//        Gson gson = gsonBuilder.create();
//        System.out.println(gson.toJson(new Book("category", new Title("fff,some"), new Author("some"),null,null)));

        try {
            JAXBContext bookClass = JAXBContext.newInstance(Bookstore.class);
            Marshaller m = bookClass.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // To format XML
            m.marshal(books, System.out);
            m.marshal(books, new File("C:\\Users\\Олександр\\Documents\\Git\\ACP12\\OleksandrMalov\\resources\\booksFromObject.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}




