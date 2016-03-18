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
        private BufferedReader br;
        private PrintWriter pw;
        private Socket client;
        private boolean setBlock = true;

        public ForwardMessage(Socket client) {
            this.client = client;
        }

        public void close() {
            try {
                br.close();
                pw.close();
                Iterator<Socket> iter = clientList.iterator();
                while (iter.hasNext()){
                    iter.next().close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (setBlock) {
                try {
                    br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String name = br.readLine();
                    String text;
                    text = br.readLine();
                    if (text.equals("exit")) {
                        break;
                    }
                    Iterator<Socket> iter = clientList.iterator();
                    while (iter.hasNext()) {
                        pw = new PrintWriter(iter.next().getOutputStream(), true);
                        pw.println(name + " : " + text);
                    }
                } catch (IOException e) {
                    e.getMessage();
                    setBlock = false;
                } finally {
                    close();
                }
            }
        }
    }
}

