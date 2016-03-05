package ua.artcode.week4.day1.reflection;

import ua.artcode.week3.mapping.DepartmentPrivatBank;

/**
 * Created by serhii on 04.03.16.
 */
public class TestClassInfo {


    public static void main(String[] args) {
        DepartmentPrivatBank dep = new DepartmentPrivatBank("name1", "sdd", 1,
                "UA", "Kiev", 1232, "2343", "@gmail.com", "sdfsdf");


        System.out.println(RTTIUtils.getInfo(String.class));
        System.out.println(RTTIUtils.getObjecrtInfo(dep));



    }
}
