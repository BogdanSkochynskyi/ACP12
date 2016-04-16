package ua.artcode.testio.soap.endpoint;

import ua.artcode.testio.dto.StudentDTO;
import ua.artcode.testio.dto.StudentList;
import ua.artcode.testio.exception.NoStudentFoundException;
import ua.artcode.testio.model.Student;
import ua.artcode.testio.service.RegisterException;
import ua.artcode.testio.service.StudentService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface StudentEndpoint {

    @WebMethod
    StudentDTO login(String login) throws NoStudentFoundException;

    @WebMethod
    StudentDTO getStudentInfo(int id) throws NoStudentFoundException;

    @WebMethod
    StudentDTO register(StudentDTO newStudent) throws RegisterException;

    @WebMethod
    StudentList getAll(int start, int lenght);

}
