package my_chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    private String name;

    public MyClient() throws IOException {
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
        private PrintWriter output;
        private Scanner console;
        private Socket client;

        public SendMessage(Socket client) throws IOException {
            this.client = client;
            console = new Scanner(System.in);
            output = new PrintWriter(client.getOutputStream(), true);
        }

        @Override
        public void run() {
            while (true) {
                output.println(name);
                String text;
                text = console.nextLine();
                output.println(text);
            }
        }
    }

    private class GetMessage extends Thread {
        private BufferedReader input;
        private Socket client;

        public GetMessage(Socket client) throws IOException {
            this.client = client;
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String text = input.readLine();
                    if (text == null) {
                        System.out.println("null input");
                        break;
                    }
                    System.out.println(text);
                } catch (IOException e) {
                    System.err.println("Server was shut down");
                    System.exit(0);
                }
            }
        }
    }
}