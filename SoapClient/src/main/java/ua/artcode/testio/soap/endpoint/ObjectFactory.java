
package ua.artcode.testio.soap.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.artcode.testio.soap.endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NoStudentFoundException_QNAME = new QName("http://endpoint.soap.testio.artcode.ua/", "NoStudentFoundException");
    private final static QName _RegisterException_QNAME = new QName("http://endpoint.soap.testio.artcode.ua/", "RegisterException");
    private final static QName _StudentsList_QNAME = new QName("http://endpoint.soap.testio.artcode.ua/", "studentsList");
    private final static QName _Student_QNAME = new QName("http://endpoint.soap.testio.artcode.ua/", "student");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.artcode.testio.soap.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StudentDTO }
     * 
     */
    public StudentDTO createStudentDTO() {
        return new StudentDTO();
    }

    /**
     * Create an instance of {@link RegisterException }
     * 
     */
    public RegisterException createRegisterException() {
        return new RegisterException();
    }

    /**
     * Create an instance of {@link NoStudentFoundException }
     * 
     */
    public NoStudentFoundException createNoStudentFoundException() {
        return new NoStudentFoundException();
    }

    /**
     * Create an instance of {@link StudentList }
     * 
     */
    public StudentList createStudentList() {
        return new StudentList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoStudentFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.soap.testio.artcode.ua/", name = "NoStudentFoundException")
    public JAXBElement<NoStudentFoundException> createNoStudentFoundException(NoStudentFoundException value) {
        return new JAXBElement<NoStudentFoundException>(_NoStudentFoundException_QNAME, NoStudentFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.soap.testio.artcode.ua/", name = "RegisterException")
    public JAXBElement<RegisterException> createRegisterException(RegisterException value) {
        return new JAXBElement<RegisterException>(_RegisterException_QNAME, RegisterException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.soap.testio.artcode.ua/", name = "studentsList")
    public JAXBElement<StudentList> createStudentsList(StudentList value) {
        return new JAXBElement<StudentList>(_StudentsList_QNAME, StudentList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.soap.testio.artcode.ua/", name = "student")
    public JAXBElement<StudentDTO> createStudent(StudentDTO value) {
        return new JAXBElement<StudentDTO>(_Student_QNAME, StudentDTO.class, null, value);
    }

}
