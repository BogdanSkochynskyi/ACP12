package xmlObjTest;

import org.junit.Assert;
import org.junit.Test;
import week3.objXmlObj.TestObject;

/**
 * Created by gavri on 06.03.2016.
 */
public class TestXmlObjXml {

    @Test
    public void testToXml(){
        TestObject testObject = new TestObject();

        String expected = "<TestObject>\n</TestObject>";
        String result = testObject.toXml();

        Assert.assertEquals(expected,result);
    }
}
