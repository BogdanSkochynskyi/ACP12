package ua.artcode.week8.ioc.dao;

import ua.artcode.week8.ioc.common.Inject;
import ua.artcode.week8.ioc.db.AppDB;
import ua.artcode.week8.ioc.model.MyUser;

/**
 * Created by serhii on 02.04.16.
 */
public class GeneralDao {

    @Inject
    private AppDB db;

    private String name;


    public GeneralDao() {
    }

    public GeneralDao(AppDB db, String name) {
        this.db = db;
        this.name = name;
    }

    public MyUser find(String email) {
        return db.getUserMap().get(email);
    }

    public AppDB getDb() {
        return db;
    }

    public void setDb(AppDB db) {
        this.db = db;
    }
}
