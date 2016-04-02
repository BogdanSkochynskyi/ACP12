package ua.artcode.week8.ioc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.week8.ioc.exception.MyAppException;
import ua.artcode.week8.ioc.service.MyService;

/**
 * Created by serhii on 02.04.16.
 */
public class TestApplicationContext {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/week8/app-context.xml");
        MyService service = (MyService) context.getBean("service");
        try {
            String accessKey = service.login("123@gmail.com","12345678");
            System.out.println(accessKey);

        } catch (MyAppException e) {
            e.printStackTrace();
        }


    }


}
