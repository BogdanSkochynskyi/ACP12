package artcode.week4.day2.synchronized_chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by Олександр on 22.03.2016.
 */
public class Client {

    public static void main(String [] args) {

        String serverName = "127.0.0.1";
        int port = 8080;
        System.out.println("Connecting to " + serverName + " on port " + port);
        while (true) {
            try {

                Socket client = new Socket(serverName, port);

                BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
                OutputStream out = client.getOutputStream();
                InputStream in = client.getInputStream();

                DataOutputStream outToServer = new DataOutputStream(out);
                DataInputStream inFromServer = new DataInputStream(in);

                String lineFromConsole = fromConsole.readLine();
                outToServer.writeUTF(lineFromConsole);


                System.out.println("Server: " + inFromServer.readUTF());


            }catch(IOException e) {
                e.printStackTrace();
            }
        }
}
}
