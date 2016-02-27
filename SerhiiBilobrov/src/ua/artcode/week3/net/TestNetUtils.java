package ua.artcode.week3.net;

import ua.artcode.utils.NetUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by serhii on 27.02.16.
 */
public class TestNetUtils {


    public static void main(String[] args) throws IOException, URISyntaxException {
        NetUtils.load("http://www.ex.ua/get/228871765", "SerhiiBilobrov/resources/audio.mp3");
    }
}
