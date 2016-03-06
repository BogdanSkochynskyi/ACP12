package week3.objXmlObj;

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

    public String toXml(){
        StringBuilder builder = new StringBuilder();
        builder.append("<"+getClass().getSimpleName()+">\n");

        builder.append("</"+getClass().getSimpleName()+">");
        return builder.toString();
    }
}
