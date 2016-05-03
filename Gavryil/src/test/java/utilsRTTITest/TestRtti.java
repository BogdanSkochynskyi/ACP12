package utilsRTTITest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import week3.objXmlObj.TestObject;
import week4.RTTIUtils;

/**
 * Created by kroshkamedved on 04.05.16.
 */
public class TestRtti {

    TestObject testObject;
    String testObjectInString;
    TestObject recoverdObject;

    @Before
    public void setUp() throws IllegalAccessException {
       testObject = new TestObject("Vas'ka",22,20222,"Kiev");
       testObjectInString = RTTIUtils.format(testObject);
       recoverdObject = (TestObject) RTTIUtils.parse(testObjectInString);

    }
    @Test
    public void testRecover(){
        Assert.assertEquals(testObject,recoverdObject);
    }
}
