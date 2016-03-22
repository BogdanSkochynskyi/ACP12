package main.java.artcode.week3.serializer.obj_xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Олександр on 02.03.2016.
 */

public class ObjectToXmlParser {

    public void format (Object object){
        String XMLHead = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        Class structure = object.getClass();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(XMLHead + "\n");
        stringBuilder.append(String.format("<%s>\n", structure.getSimpleName()));

        Field[] fields = structure.getDeclaredFields();
        for (Field field : fields) {
            try {
                String fieldName = field.getName();
                String firstUpperCaseLetter = fieldName.substring(0, 1).toUpperCase();
                Method getFieldValue = structure.getMethod("get" + firstUpperCaseLetter + fieldName.substring(1));
                stringBuilder.append(String.format("\f\f<%s>%s</%s>\n", fieldName, getFieldValue.invoke(object), fieldName));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        stringBuilder.append(String.format("</%s>", structure.getSimpleName()));
        try (Writer writer = new FileWriter("C:\\Users\\Олександр\\Documents\\Git\\ACP12\\OleksandrMalov\\src\\main\\resources\\books.xml")){
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Saved to the file:\n\n" + stringBuilder.toString());
    }

    public Bookstore parse(String source){

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Bookstore.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Bookstore bookstore = (Bookstore) jaxbUnmarshaller.unmarshal(new File(source));
            return bookstore;
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }


//    public Object parse(String src){
//
//        String[] lines = src.split("\n");
//        String str = lines[1].split(">")[0];
//        String type = str.substring(1).toLowerCase();
//
//        Map<String,String> keyValuesMap = new HashMap<>();
//
//        for (int i = 2; i < lines.length; i++) {
//            String[] keyValue = lines[i].split("<");
//            for (int j = 0; j < keyValue.length; j++) {
//                String[] words = keyValue[i].split(">");
//                keyValuesMap.put(words[0], words[1]);
//            }
//        }
//
//        try {
//            Class cl = Class.forName(type);
//            Object instance = cl.newInstance();
//
//
//            Map<String, Field> fieldAnnotNameMap = new HashMap<>();
//            for(Field field : cl.getDeclaredFields()){
//                Save save = field.getAnnotation(Save.class);
//                if(save != null){
//                    fieldAnnotNameMap.put(save.name(), field);
//                }
//            }
//
//            // iteration over map
//            for (String key : keyValuesMap.keySet()) {
//                // getField using Annotation property
//                Field field = fieldAnnotNameMap.get(key);
//
//                Class<?> fieldType = field.getType();
//
//                String firstUpperCaseLetter = field.getName().substring(0, 1).toUpperCase();
//                String other = field.getName().substring(1);
//                Method setMethod = cl.getMethod("set" + firstUpperCaseLetter + other, fieldType);
//
//                if(int.class == fieldType){
//                    setMethod.invoke(instance, Integer.parseInt(keyValuesMap.get(key)));
//                } else if(double.class == fieldType){
//                    setMethod.invoke(instance, Double.parseDouble(keyValuesMap.get(key)));
//                } else if(String.class == fieldType){
//                    setMethod.invoke(instance, keyValuesMap.get(key));
//                }
//
//            }
//
//            return instance;
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

//    public void parserToFile(Iint iint){
//
//        try {
//            JAXBContext objectContext = JAXBContext.newInstance(iint.getClass());
//            Marshaller m = objectContext.createMarshaller();
//            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // To format XML
//            m.marshal(iint, System.out);
//            m.marshal(iint, new File("C:\\Users\\Олександр\\Documents\\Git\\ACP12\\OleksandrMalov\\resources\\booksFromObject.xml"));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }
}
