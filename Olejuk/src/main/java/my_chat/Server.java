package my_chat;

import java.io.*;
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

            new Read().start();
            new Writer().start();

        }
        private class Writer extends Thread{

            @Override
            public void run(){
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {

                    Scanner sc = new Scanner(System.in);

                    while(true) {
                        System.out.printf("serve to %s client : ", count);
                        String line = sc.nextLine();
                        bw.write(line + "\n");
                        bw.flush();
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
                        System.out.printf("\n%s client : %s\n", count, line);
                    }

                } catch (IOException e){
                    e.printStackTrace();
                }
                System.out.printf("\n%s client left the chat\n", client);
            }
        }
    }


}
