
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class MyMarshaller {

    public File objectToXML(Object toBeMarshalled, String fileName) throws ParserConfigurationException, JAXBException {

        JAXBContext javaContentTree = JAXBContext.newInstance(toBeMarshalled.getClass());

        // creating new file
        File resultFile = new File(fileName);
        Marshaller m = javaContentTree.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(toBeMarshalled, resultFile);

        return resultFile;

    }

    public Object XMLToObject(String path) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
        Unmarshaller u = jaxbContext.createUnmarshaller();

        return u.unmarshal(new File(path));
    }
}
