package ua.artcode.week4.day2.client;

import java.io.*;
import java.net.Socket;

/**
 * Created by serhii on 05.03.16.
 */
public class RunClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.61",8080);

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        StringBuilder sb = new StringBuilder();

        String line = null;

        while ((line = br.readLine()) != null){
            sb.append(line).append("\n");
        }

        System.out.println(sb.toString());


    }
}
