package ua.artcode.week8.ioc.test;

import ua.artcode.week8.ioc.dao.GeneralDao;
import ua.artcode.week8.ioc.db.AppDB;
import ua.artcode.week8.ioc.service.MyService;

/**
 * Created by serhii on 02.04.16.
 */
public class ServiceLocator {

    private final AppDB db;
    private MyService myService;
    private final GeneralDao genDao;

    public ServiceLocator() {
        myService = new MyService();
        genDao = new GeneralDao();
        db = new AppDB();
        genDao.setDb(db);
        myService.setGenDao(genDao);

    }

    public Object get(String name) {
        if("myService".equals(name)){
            return myService;
        }
        return null;
    }
}
