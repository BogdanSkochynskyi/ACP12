package week4;

import week3.objXmlObj.TestObject;

import java.util.Objects;

/**
 * Created by gavri on 04.03.2016.
 */
public class RTTIUtilsTest {
    public static void main(String[] args) throws IllegalAccessException {
        TestObject teOb = new TestObject("Vas'ka",22,20222,"Kiev");

        String str = RTTIUtils.format(teOb);
        System.out.println(str);

        TestObject recovered = (TestObject) RTTIUtils.parse(str);

        System.out.println(recovered);



    }

}
