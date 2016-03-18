package my_chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    private String name;

    public MyClient() {
        try {
            Socket client = new Socket("localhost", 7777);
            Scanner readName = new Scanner(System.in);
            System.out.println("Type your name: ");
            name = readName.nextLine();

            new SendMessage(client).start();
            new GetMessage(client).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SendMessage extends Thread {
        private PrintWriter pw;
        private Scanner sc;
        private Socket client;

        public SendMessage(Socket client) throws IOException {
            this.client = client;
        }

        public void close(){
            try {
                pw.close();
                sc.close();
                client.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            sc = new Scanner(System.in);
            while (true) {
                try {
                    pw = new PrintWriter(client.getOutputStream(), true);
                    pw.println(name);

                    String text;

                    text = sc.nextLine();
                    if (text.equals("exit")) {
                        break;
                    }
                    pw.println(text);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close();
                }
            }
        }
    }

    private class GetMessage extends Thread {
        private BufferedReader br;
        private Socket client;

        public GetMessage(Socket client) {
            this.client = client;
        }

        public void close(){
            try {
                br.close();
                client.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            boolean isConnected = true;
            while (isConnected) {
                try {
                    br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    System.out.println(br.readLine());
                } catch (IOException e) {
                    close();
                    isConnected = false;
                    System.err.println("Server was shut down");
                }
            }
        }
    }
}
