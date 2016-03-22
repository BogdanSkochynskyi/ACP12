package my_chat;

import java.io.IOException;

public class RunServer {
    public static void main(String[] args) throws IOException {
        new MyServer(7777);
    }
}
