package week3.objXmlObj;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by gavri on 06.03.2016.
 */
public class TestObject {

    private String name;
    private int age;
    private int salary;
    private String address;

    public TestObject() {
    }

    public TestObject(String name, int age, int salary, String address) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toXml() throws IllegalAccessException, InstantiationException {
        StringBuilder builder = new StringBuilder();
        builder.append("<" + getClass().getSimpleName() + ">\n");
        Class cl = this.getClass();
        if (name != null) {

            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                builder.append("<" + field.getName() + ">" + field.get(this) + "</" + field.getName() + ">\n");
            }

        }
        builder.append("</" + getClass().getSimpleName() + ">");
        return builder.toString();
    }

    public void getFieldsFromXml(File file) throws ParserConfigurationException, IOException, SAXException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        Element root = doc.getDocumentElement();
        NodeList list = root.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeName().equals("name")) {
                this.name = node.getTextContent();
            } else if (node.getNodeName().equals("age")) {
                this.age = Integer.parseInt(node.getTextContent());
            } else if (node.getNodeName().equals("salary")) {
                this.salary = Integer.parseInt(node.getTextContent());
            } else if (node.getNodeName().equals("address")) {
                this.address = node.getTextContent();
            }
        }

    }

    @Override
    public String toString() {
        return "TestObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestObject that = (TestObject) o;

        if (age != that.age) return false;
        if (salary != that.salary) return false;
        if (!name.equals(that.name)) return false;
        return address.equals(that.address);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + salary;
        result = 31 * result + address.hashCode();
        return result;
    }
}
