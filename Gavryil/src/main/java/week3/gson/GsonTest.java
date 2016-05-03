package week3.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import week3.downloadUtil.MyDownloader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Created by gavri on 07.03.2016.
 */
public class GsonTest {


    String url = "https://api.privatbank.ua/p24api/pboffice?json&city=%D0%94%D0%BD%D0%B5%D0%BF%D1%80%D0%BE%D0%BF%D0%B5%D1%82%D1%80%D0%BE%D0%B2%D1%81%D0%BA&address=%D0%A2%D0%B8%D1%82%D0%BE%D0%B2%D0%B0";
    String dest = "src/main/resources/private.json";


    GsonBuilder builder;
    Gson gson;

    @Before
    public void setUp() throws IOException {
        MyDownloader.load(new URL(url),dest);
        builder = new GsonBuilder();
        gson = builder.create();

    }
    @After
    public void tearDown(){

    }

    @Test
    public void testConvertion1() throws FileNotFoundException {
       PrivatDepartment[] deps = gson.fromJson(new FileReader(dest),PrivatDepartment[].class);
       PrivatDepartment[] handDeps = {new PrivatDepartment("Днепропетровская","2943","Украина","Днепропетровск","49000","8(056)373-33-54, 373-33-56","julija.tverdokhlebova@pbank.com.ua","ул Титова 29-М"),
               new PrivatDepartment("Днепропетровская","2980","Украина","Днепропетровск","49055","8(056)771-20-83","elena.vasik@pbank.com.ua","ул Титова 9")};
       Assert.assertArrayEquals(handDeps,deps);

    }

    @Test
    public void reverseConvertion() throws FileNotFoundException {
        PrivatDepartment[] handDeps = {new PrivatDepartment("Днепропетровская","2943","Украина","Днепропетровск","49000","8(056)373-33-54, 373-33-56","julija.tverdokhlebova@pbank.com.ua","ул Титова 29-М"),
                new PrivatDepartment("Днепропетровская","2980","Украина","Днепропетровск","49055","8(056)771-20-83","elena.vasik@pbank.com.ua","ул Титова 9")};

        String myDep1 = gson.toJson(handDeps[0]);

        PrivatDepartment[] deps = gson.fromJson(new FileReader(dest),PrivatDepartment[].class);

        String myDep2 = gson.toJson(deps[0]);

        Assert.assertEquals(myDep1,myDep2);

    }
}

