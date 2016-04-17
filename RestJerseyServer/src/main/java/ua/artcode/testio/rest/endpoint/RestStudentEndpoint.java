package ua.artcode.testio.rest.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.testio.dto.StudentDTO;
import ua.artcode.testio.dto.StudentList;
import ua.artcode.testio.exception.NoStudentFoundException;
import ua.artcode.testio.model.Student;
import ua.artcode.testio.model.StudentType;
import ua.artcode.testio.service.RegisterException;
import ua.artcode.testio.service.StudentService;
import ua.artcode.testio.soap.endpoint.StudentEndpoint;
import ua.artcode.testio.util.DTOConverter;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

@Path("/student")
public class RestStudentEndpoint implements StudentEndpoint {

    @Context
    private ServletContext servletContext;

    //@Autowired
    private StudentService studentService;

    public RestStudentEndpoint() {
        System.out.println("Endpoint constructor");
    }

    @PostConstruct
    public void init() {
        // use listener for init context
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-context.xml");
        studentService = app.getBean(StudentService.class);
    }

    @Path("/hello")
    @GET
    public String hello(){
        return "hello";
    }

    @Override // student/login?name=Oleg
    @Path("/login")
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public StudentDTO login(@QueryParam("name") String login) throws NoStudentFoundException {
        Student student = studentService.login(login);
        return DTOConverter.convert(student);
    }

    @Override // student/info/23
    @Path("/info/{id}")
    @GET
    @Produces({"application/json"})
    public StudentDTO getStudentInfo(@PathParam("id") int id) throws NoStudentFoundException {
        return DTOConverter.convert(studentService.getStudentInfo(id));
    }

    @Override
    @POST
    @Path("/register")
    @Consumes("application/json")
    @Produces("application/json")
    public StudentDTO register(StudentDTO newStudent) throws RegisterException {
        Student registred = studentService.register(DTOConverter.convert(newStudent));
        return DTOConverter.convert(registred);
    }

    @Override
    @GET
    @Path("/all")
    @Consumes("application/json")
    @Produces("application/json")
    public StudentList getAll(@QueryParam("start")int start,@QueryParam("end") int lenght) {
        return DTOConverter.getStudentList(studentService.getAll(start,lenght));
    }
}
