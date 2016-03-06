package my_chat;

/**
 * Created by dexter on 06.03.16.
 */
public class RunClient {
    public static void main(String[] args) {
        new Client().run("192.168.0.102", 8080);
    }
}
