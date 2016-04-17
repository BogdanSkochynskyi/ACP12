package ua.artcode.testio.util;

import ua.artcode.testio.dto.StudentDTO;
import ua.artcode.testio.dto.StudentList;
import ua.artcode.testio.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 17.04.16.
 */
public class DTOConverter {

    public static StudentDTO convert(Student student){
        return new StudentDTO(student.getId(),student.getName(),student.getStudentType());
    }

    public static Student convert(StudentDTO student){
        return new Student(student.getName(),0.0,student.getStudentType(),null,null);
    }


    public static StudentList getStudentList(List<Student> students) {
        StudentList studentList = new StudentList();
        List<StudentDTO> studentDTOs = new ArrayList<>();

        for (Student student : students) {
            studentDTOs.add(new StudentDTO(student.getId(),student.getName(),student.getStudentType()));
        }

        studentList.setDtoList(studentDTOs);

        return studentList;
    }
}
