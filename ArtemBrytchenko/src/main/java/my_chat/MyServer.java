package my_chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyServer {
    private List<Socket> clientList = Collections.synchronizedList(new ArrayList<>());

    public MyServer(int port) throws IOException {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("*=*=*=*=*=*=*=*=*\n" +
                    "Server is ready to work\n" + "*=*=*=*=*=*=*=*=*");
            while (true) {
                Socket client = server.accept();
                System.out.printf("new client was connected: IP %s, port %s\n",
                        client.getInetAddress(), client.getPort());
                new ForwardMessage(client).start();
                clientList.add(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ForwardMessage extends Thread {
        private BufferedReader input;
        private PrintWriter output;
        private Socket client;
        private boolean isConnected = true;

        public ForwardMessage(Socket client) {
            this.client = client;
        }

        public void sendToAll(String name, String text) throws IOException {
            Iterator<Socket> iter = clientList.iterator();
            while (iter.hasNext()) {
                output = new PrintWriter(iter.next().getOutputStream(), true);
                output.println(name + " : " + text);
            }
        }

        @Override
        public void run() {
            while (isConnected) {
                try {
                    input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String name = input.readLine();
                    String text;
                    text = input.readLine();
                    sendToAll(name, text);
                } catch (IOException e) {
                    isConnected = false;
                    System.out.println("client " + client.getInetAddress() + " was disconnected");
                }
            }
        }
    }
}

