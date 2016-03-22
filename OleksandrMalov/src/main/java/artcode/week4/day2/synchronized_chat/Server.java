package artcode.week4.day2.synchronized_chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by Олександр on 22.03.2016.
 */
public class Server extends Thread {

    private ServerSocket serverSocket;

    public Server(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run() {

        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

        while(true) {

            try {

                Socket server = serverSocket.accept();

                DataInputStream in = new DataInputStream(server.getInputStream());
                BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
                DataOutputStream out = new DataOutputStream(server.getOutputStream());

                System.out.println("Client: " + in.readUTF());

                String lineFromConsole = fromConsole.readLine();

                out.writeUTF(lineFromConsole);
                server.close();
            }catch(SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            }catch(IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
    public static void main(String [] args) {
        int port = 8080;
        try {
            Thread t = new Server(port);
            t.start();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
