package my_chat.controller;

import java.io.IOException;

/**
 * Created by dexter on 06.03.16.
 */
public class RunClient {
    public static void main(String[] args) {
        try {
            new Client().run("192.168.0.101", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
