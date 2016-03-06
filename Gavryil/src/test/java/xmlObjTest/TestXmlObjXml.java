package xmlObjTest;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;
import week3.domParsing.DomParsingUtils;
import week3.objXmlObj.TestObject;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by gavri on 06.03.2016.
 */
public class TestXmlObjXml {


    public static final String RESOURCES_PATH = "src/test/resources/";

    @Test
    public void testToXml() throws InstantiationException, IllegalAccessException {
        TestObject testObject = new TestObject();

        String expected = "<TestObject>\n</TestObject>";
        String result = testObject.toXml();

        Assert.assertEquals(expected,result);
    }

    @Test
    public void testStringToXml(){
        String fileName = "testString.xml";
        DomParsingUtils.stringToXml("Some text which should be saved in the PATH",RESOURCES_PATH+ fileName);
        boolean result = (new File(RESOURCES_PATH+fileName)).exists();

        Assert.assertTrue(result);
    }

   @Test
    public void testGetFieldsFromXml() throws InstantiationException, IllegalAccessException, IOException, SAXException, ParserConfigurationException {

        TestObject expexted = new TestObject("Vasja",25,500,"Gaysin");

        String xmlName = "testObject.xml";

        DomParsingUtils.stringToXml(expexted.toXml(),RESOURCES_PATH+xmlName);

        TestObject result = new TestObject();
        result.getFieldsFromXml(new File(RESOURCES_PATH+xmlName));

        Assert.assertEquals(expexted,result);



    }
}
