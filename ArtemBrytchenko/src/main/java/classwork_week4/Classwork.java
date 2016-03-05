package classwork_week4;

import java.lang.reflect.Field;


public class Classwork {

    public static String format(Object object) {
        Class struc = object.getClass();
        StringBuilder sb = new StringBuilder();

        sb.append(struc.getName()).append("\n");
        Field[] fields = struc.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object objFieldValue = field.get(object);
                sb.append(String.format("%s:%s\n",
                        field.getName(),
                        objFieldValue));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

//        String s = struc.getName();
        return String.valueOf(sb);
    }

    public static Object parse(String string) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        /*Class cl = Class.forName("classwork_week4.Departments");
        Object obj = cl.newInstance();

        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            cl.getField(field.getName()).set(obj, "1");
        }*/

        return null;
    }



    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        Departments dep = new Departments("name1", "sdd", 1,
                "UA", "Kiev", 1232, "2343", "@gmail.com", "sdfsdf");

        System.out.println(Classwork.parse(Classwork.format(dep)));
    }

}
