package my_chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient{
    public MyClient(){
        try {
            Socket client = new Socket("localhost", 7777);
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);

            String text = "";
            while (!text.equals("exit")) {
                text = sc.nextLine();
                pw.println(text);
            }
//// TODO: safe close of client without exception.
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
