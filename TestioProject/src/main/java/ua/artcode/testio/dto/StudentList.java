package ua.artcode.testio.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by serhii on 16.04.16.
 */

// JAXB
@XmlRootElement(name = "studentsList")
public class StudentList {


    private List<StudentDTO> dtoList;

    public StudentList() {
    }

    @XmlElement(name = "students")
    public List<StudentDTO> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<StudentDTO> dtoList) {
        this.dtoList = dtoList;
    }
}
