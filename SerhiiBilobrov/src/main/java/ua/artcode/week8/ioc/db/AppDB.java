package ua.artcode.week8.ioc.db;

import ua.artcode.week8.ioc.MyUser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by serhii on 02.04.16.
 */
public class AppDB {

    private Map<String,MyUser> userMap;

    public AppDB() {
        userMap = new HashMap<>();
        userMap.put("123@gmail.com", new MyUser("123@gmail.com", "123"));
        userMap.put("kolia@gmail.com", new MyUser("kolia@gmail.com", "1234"));

    }

    public Map<String, MyUser> getUserMap() {
        return userMap;
    }
}
