package ua.artcode.testio.dao;

import ua.artcode.testio.model.Student;

import java.util.List;

/**
 * Created by serhii on 03.04.16.
 */
public interface StudentDao {


    Student create(Student student);

    Student remove(int id);

    Student find(String login);

    Student find(int id);

    List<Student> getAll(int start, int end);


}
