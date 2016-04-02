package ua.artcode.week8.ioc.test;

import ua.artcode.week8.ioc.dao.GeneralDao;
import ua.artcode.week8.ioc.di.DependencyInjector;
import ua.artcode.week8.ioc.model.MyUser;

/**
 * Created by serhii on 02.04.16.
 */
public class TestDI {


    public static void main(String[] args) {
        DependencyInjector dependencyInjector = new DependencyInjector();
        GeneralDao generalDao = new GeneralDao();

        dependencyInjector.inject(generalDao);

        MyUser myUser = generalDao.find("123@gmail.com");

        System.out.println(myUser);

    }
}
