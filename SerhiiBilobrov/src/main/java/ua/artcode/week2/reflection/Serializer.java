package ua.artcode.week2.reflection;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by serhii on 21.02.16.
 */
public class Serializer {

    public static void save(Robot robot, String path){

        try (Writer writer = new FileWriter(path)){
            writer.write(robot.getModel());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
