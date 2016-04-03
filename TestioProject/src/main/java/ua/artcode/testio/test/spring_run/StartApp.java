package ua.artcode.testio.test.spring_run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.testio.exception.NoStudentFoundException;
import ua.artcode.testio.model.Student;
import ua.artcode.testio.model.StudentType;
import ua.artcode.testio.service.RegisterException;
import ua.artcode.testio.service.StudentService;

import java.util.Date;
import java.util.List;

/**
 * Created by serhii on 03.04.16.
 */
public class StartApp {


    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");

        StudentService studentService = context.getBean(StudentService.class);


        try {
            Student student = studentService.getStudentInfo(2);
            studentService.register(new Student("Bogdan", 5, StudentType.SENIOR, new Date(), "234"));

            List<Student> studentList = studentService.getAll(0,100);
            studentList.stream().forEach(System.out::println);
        } catch (NoStudentFoundException e) {
            e.printStackTrace();
        } catch (RegisterException e) {
            e.printStackTrace();
        }
    }
}
