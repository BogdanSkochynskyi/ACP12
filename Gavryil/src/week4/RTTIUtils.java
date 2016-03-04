package week4;

import com.sun.javafx.binding.StringFormatter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Scanner;

import myScanner.*;


/**
 * Created by gavri on 04.03.2016.
 */
public class RTTIUtils {


    public static String format(Object o) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        Class cl = o.getClass();
        sb.append(cl.getName()+"\n");
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            Object objectFieldValue = field.get(o);
            sb.append(String.format("%s, %s\n",field.getName(),objectFieldValue));
        }
        return sb.toString();
    }
    public static Object parse(String string){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(string.getBytes())));) {
            String firstLine = br.readLine();
            Class cl = Class.forName(firstLine);
            Object o = cl.newInstance();
            Field[] fields = o.getClass().getFields();
            for (Field field : fields){
                if (field.getName().equals(br.readLine())) field.set(o,br.readLine());
            }
            return  null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
