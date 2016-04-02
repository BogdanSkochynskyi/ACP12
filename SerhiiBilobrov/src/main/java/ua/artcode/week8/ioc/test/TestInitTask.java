package ua.artcode.week8.ioc.test;

import ua.artcode.week8.ioc.dao.GeneralDao;
import ua.artcode.week8.ioc.db.AppDB;
import ua.artcode.week8.ioc.service.MyService;

/**
 * Created by serhii on 02.04.16.
 */
public class TestInitTask {

    public static void main(String[] args) {


        ServiceLocator serviceLocator = new ServiceLocator();
        MyService myService = (MyService) serviceLocator.get("myService");


    }
}
