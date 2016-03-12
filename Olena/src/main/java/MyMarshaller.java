import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;


public class MyMarshaller {

    public void objectToXML(Object toBeMarshalled, String path) throws ParserConfigurationException, JAXBException {

        JAXBContext javaContentTree = JAXBContext.newInstance(toBeMarshalled.getClass());

        // creating new file
        File resultFile = new File(path);
        Marshaller m = javaContentTree.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(toBeMarshalled, resultFile);

    }

    public Object XMLToObject(String path) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        Unmarshaller u = jaxbContext.createUnmarshaller();

        return u.unmarshal(new File(path));
    }

    public void objectToJson(Object toBeMarshalled, String path) throws IOException {

        //boilerplate code
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        //marshalling
        String jsonString = gson.toJson(toBeMarshalled);
        FileWriter resultFile = new FileWriter(path);
        resultFile.append(jsonString);

        resultFile.close();
    }

    public Object jsonToObject(String path) throws FileNotFoundException {

        //boilerplate code
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

       return gson.fromJson(new FileReader(new File(path)),Book.class);
    }
}
