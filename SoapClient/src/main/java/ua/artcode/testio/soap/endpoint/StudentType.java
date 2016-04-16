
package ua.artcode.testio.soap.endpoint;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="studentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="JUNIOR"/>
 *     &lt;enumeration value="MIDDLE"/>
 *     &lt;enumeration value="SENIOR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "studentType")
@XmlEnum
public enum StudentType {

    JUNIOR,
    MIDDLE,
    SENIOR;

    public String value() {
        return name();
    }

    public static StudentType fromValue(String v) {
        return valueOf(v);
    }

}
