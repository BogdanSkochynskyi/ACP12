package my_chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dexter on 05.03.16.
 */
public class Server {

    private int id;
    private List<String> list = new ArrayList<>();
    private ServerSocket serverSocket;

    public void run() {

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server was ran");
            while(true){
                Socket client = serverSocket.accept();
                new Guest(client, id).start();
                String clientInfo = String.format("count %d, address %s, port %d\n",
                        id++,
                        client.getInetAddress(),
                        client.getPort());

                list.add(clientInfo);

                System.out.println(clientInfo);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private class Guest extends Thread {

        Socket client;
        int count;

        Guest(Socket client, int count){
            this.client = client;
            this.count = count;
        }

        @Override
        public void run() {

            System.out.printf("connection to %s server", serverSocket);
            new Read().start();
            new Writer().start();

        }
        private class Writer extends Thread{

            @Override
            public void run(){
                try (PrintWriter pw = new PrintWriter(client.getOutputStream())) {

                    Scanner sc = new Scanner(System.in);

                    while(true) {
                        pw.print(sc.nextLine());
                    }

                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        private class Read extends Thread{

            @Override
            public void run(){
                try (BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))){

                    while(true){
                        String line = br.readLine();
                        if(line == null) break;
                        System.out.println(line);
                    }

                } catch (IOException e){
                    e.printStackTrace();
                }
                System.out.println("client left the chat");
            }
        }
    }


}
