package ua.artcode.testio.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.testio.service.StudentService;
import ua.artcode.testio.soap.endpoint.StudentEndpointImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by serhii on 16.04.16.
 */
public class RunSoapServer {

    public static void main(String[] args) {

        ApplicationContext appCon = new ClassPathXmlApplicationContext("spring-context.xml");
        StudentService studentService = appCon.getBean(StudentService.class);


        Endpoint.publish(
                "http://192.168.1.61:9999/soap/student", new StudentEndpointImpl(studentService));


    }
}
