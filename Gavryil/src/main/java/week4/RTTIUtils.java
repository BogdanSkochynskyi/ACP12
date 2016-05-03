package week4;

import week2.myScanner.MyScanner;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by gavri on 04.03.2016.
 */
public class RTTIUtils {


    public static String format(Object o) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        Class cl = o.getClass();
        sb.append("type="+cl.getName()+"\n");
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            Object objectFieldValue = field.get(o);
            sb.append(String.format("%s=%s\n",field.getName(),objectFieldValue));
        }
        return sb.toString();
    }
    public static Object parse(String string){
        Map<String,String> map = new HashMap<>();

        try(MyScanner sc = new MyScanner(string)) {
            String firstLine = sc.nextLine();
            String[] lines = string.split("\n");

            for (int i = 0; i < lines.length; i++) {
                String[] keyValueArr = lines[i].split("=");
                map.put(keyValueArr[0],keyValueArr[1]);
            }


            String className = firstLine.split("=")[1];
            Class cl = Class.forName(className);
            Object o = cl.newInstance();
            Class<?> fieldType;

            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields){
                field.setAccessible(true);
                fieldType = field.getType();

                if (int.class == fieldType){
                    if (map.containsKey(field.getName())) field.set(o,Integer.parseInt(map.get(field.getName())));
                }else if (String.class == fieldType) {
                    if (map.containsKey(field.getName())) field.set(o,map.get(field.getName()));
                }
            }
            return  o;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

}
