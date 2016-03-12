package week4;

import org.junit.Test;

import java.io.IOException;

public class TestMyImageLoader {

    public static void main(String[] args) {
        MyImageLoader my = new MyImageLoader();
        try {
            my.loadImages("http://www.ex.ua/70965204?r=28739,23777");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
