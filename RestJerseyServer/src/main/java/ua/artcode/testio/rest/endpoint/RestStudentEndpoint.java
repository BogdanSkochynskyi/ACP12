package ua.artcode.testio.rest.endpoint;

import ua.artcode.testio.dto.StudentDTO;
import ua.artcode.testio.dto.StudentList;
import ua.artcode.testio.exception.NoStudentFoundException;
import ua.artcode.testio.model.StudentType;
import ua.artcode.testio.service.RegisterException;
import ua.artcode.testio.soap.endpoint.StudentEndpoint;

import javax.ws.rs.*;

@Path("/student")
public class RestStudentEndpoint implements StudentEndpoint {


    @Path("/hello")
    @GET
    public String hello(){
        return "hello";
    }

    @Override // student/login?name=Oleg
    @Path("/login")
    @GET
    public StudentDTO login(@QueryParam("name") String login) throws NoStudentFoundException {
        return new StudentDTO(1, login, StudentType.JUNIOR);
    }

    @Override // student/info/23
    @Path("/info/{id}")
    @GET
    public StudentDTO getStudentInfo(@PathParam("id") int id) throws NoStudentFoundException {
        return new StudentDTO(id, "Test", StudentType.JUNIOR);
    }

    @Override
    @POST
    @Path("/register")
    public StudentDTO register(StudentDTO newStudent) throws RegisterException {
        System.out.println(newStudent);
        return null;
    }

    @Override
    @GET
    @Path("/all")
    public StudentList getAll(int start, int lenght) {
        return null;
    }
}
