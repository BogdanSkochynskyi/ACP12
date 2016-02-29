package ua.artcode.week3.mapping;

import com.google.gson.Gson;
import ua.artcode.utils.NetUtils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by serhii on 28.02.16.
 */
public class TestMapping {

    public static final String PATH = "https://api.privatbank.ua/p24api/pboffice?json&city=Днепропетровск&address=Титова";
    public static final String PRIVAT_JSON_PATH = "SerhiiBilobrov/resources/privat.json";

    public static void main(String[] args) throws IOException, URISyntaxException {
        Gson gson = new Gson();


        String jsonDep = gson.toJson(new DepartmentPrivatBank("name1", "sdd", 1,
                "UA","Kiev",1232,"2343","@gmail.com","sdfsdf"));

        System.out.println(jsonDep);


        NetUtils.load(PATH, PRIVAT_JSON_PATH);

        DepartmentPrivatBank[] departmetns =
                gson.fromJson(
                        new FileReader(PRIVAT_JSON_PATH),
                        DepartmentPrivatBank[].class);
    }
}
