package ua.artcode.week4.day1.reflection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import ua.artcode.week3.mapping.DepartmentPrivatBank;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSerialization {

    private ReflectionFormatter formatter = new ReflectionFormatter();

    private static Robot robot;
    private static String robotStr;

    @BeforeClass
    public static void beforeClass() {
        robot = new Robot(1, "DDRW2", 10000);

        robotStr = String.format("type:%s\nID:%s\nMODEL:%s\nPRICE:%s\n",
                robot.getClass().getName(),
                robot.getId(),
                robot.getModel(),
                robot.getPrice());
    }

    @Test()
    public void _01testFormat() {

        String res = formatter.format(robot);
        Assert.assertEquals(robotStr, res);
    }

    @Test
    public void _02testParser() {
        Object object = formatter.parse(robotStr);
        Assert.assertEquals(robot, object);
    }


}
