package ua.artcode.testio.service;

import ua.artcode.testio.exception.NoStudentFoundException;
import ua.artcode.testio.model.Student;

import java.util.List;

/**
 * Created by serhii on 26.03.16.
 */
public interface StudentService {


    Student login(String login) throws NoStudentFoundException;

    Student getStudentInfo(int id) throws NoStudentFoundException;

    Student register(Student newStudent) throws RegisterException;

    List<Student> getAll(int start, int lenght);

}
