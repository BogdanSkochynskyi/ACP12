package ua.artcode.week8.ioc.db;

import org.springframework.stereotype.Component;
import ua.artcode.week8.ioc.model.MyUser;

import java.util.HashMap;
import java.util.Map;

@Component(value = "appDbBean")
// <bean id="appDbBean" class="ua.artcode.week8.ioc.db.AppDB">
public class AppDB {

    private Map<String,MyUser> userMap;

    public AppDB() {
        userMap = new HashMap<>();
        userMap.put("123@gmail.com", new MyUser("123@gmail.com", "12345678"));
        userMap.put("kolia@gmail.com", new MyUser("kolia@gmail.com", "1234"));
    }

    public Map<String, MyUser> getUserMap() {
        return userMap;
    }
}
