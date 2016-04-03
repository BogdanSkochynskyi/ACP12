package ua.artcode.week8.ioc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.artcode.week8.ioc.dao.GeneralDao;
import ua.artcode.week8.ioc.model.MyUser;

/**
 * Created by serhii on 03.04.16.
 */
public class InitAnnotationConfigContext {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("ua.artcode.week8.ioc");

        GeneralDao generalDao = applicationContext.getBean(GeneralDao.class);
        MyUser myUser = generalDao.find("123@gmail.com");

        // no autowired
        GeneralDao myDao = new GeneralDao();



        System.out.println(myUser);
    }

}
