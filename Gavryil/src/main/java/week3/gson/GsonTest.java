package week3.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import week3.objXmlObj.TestObject;

/**
 * Created by gavri on 07.03.2016.
 */
public class GsonTest {
    public static void main(String[] args) {
        TestObject testObject = new TestObject("John",24,2000,"Gaysin");

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
         String st = gson.toJson(testObject);
        System.out.println(testObject);
        System.out.println(st);

        TestObject testObject1 = gson.fromJson(st,TestObject.class);
        System.out.println(testObject1);
    }
}
