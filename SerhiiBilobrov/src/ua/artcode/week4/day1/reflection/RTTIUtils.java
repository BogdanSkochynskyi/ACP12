package ua.artcode.week4.day1.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by serhii on 04.03.16.
 */
public class RTTIUtils {


    public static String getObjecrtInfo(Object obj){
        Class struc = obj.getClass();
        StringBuilder sb = new StringBuilder();

        Field[] fields = struc.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object objFieldValue = field.get(obj);
                sb.append(String.format("%s:%s\n",
                        field.getName(),
                        objFieldValue));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    private static Object callMethod(Object obj, String name, Class...types) {
        try {
            Method method = obj.getClass().getMethod(name, types);
            return method.invoke(obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getInfo(Class clazz){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("className : %s\n", clazz.getTypeName()));
        sb.append("METHODS\n");


        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            sb.append(String.format("%s\n", method.toString()));
        }

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            sb.append(String.format("%s\n", field.toString()));
        }


        return sb.toString();


    }
}
