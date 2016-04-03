package ua.artcode.testio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.artcode.testio.dao.StudentDao;
import ua.artcode.testio.exception.NoStudentFoundException;
import ua.artcode.testio.model.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student login(String login) throws NoStudentFoundException {

        // validate login

        Student student = studentDao.find(login);

        if(student == null){
            throw new NoStudentFoundException("no student with login " + login);
        }

        return student;
    }

    @Override
    public Student getStudentInfo(int id) throws NoStudentFoundException {

        Student student = studentDao.find(id);
        if(student == null){
            throw new NoStudentFoundException("no student with id " + id);
        }

        return student;
    }

    @Override
    public Student register(Student newStudent) throws RegisterException {

        // validation

        return studentDao.create(newStudent);
    }

    @Override
    public List<Student> getAll(int start, int lenght) {
        return studentDao.getAll(start,lenght);
    }
}
