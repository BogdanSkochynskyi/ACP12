package ua.artcode.testio.soap.test;

import ua.artcode.testio.soap.endpoint.StudentEndpoint;
import ua.artcode.testio.soap.endpoint.StudentEndpointImplService;
import ua.artcode.testio.soap.endpoint.StudentList;

/**
 * Created by serhii on 16.04.16.
 */
public class RunClient {

    public static void main(String[] args) {
        StudentEndpoint studentEndpoint = new StudentEndpointImplService().getStudentEndpointImplPort();
        StudentList studentList = studentEndpoint.getAll(0, 100);

        studentList.getStudents().stream().
                forEach((s) ->
                        System.out.printf("%d,%s,%s\n", s.getId(),s.getName(),s.getStudentType()));

    }


}
