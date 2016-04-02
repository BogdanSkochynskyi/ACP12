package ua.artcode.week8.ioc.dao;

import ua.artcode.week8.ioc.AppDB;
import ua.artcode.week8.ioc.MyUser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by serhii on 02.04.16.
 */
public class GeneralDao {

    private AppDB db;


    public GeneralDao() {

    }

    public MyUser find(String email) {
        return db.getUserMap().get(email);
    }
}
