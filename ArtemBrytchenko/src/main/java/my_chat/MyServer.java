package my_chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer{
    private BufferedReader br;

    public MyServer(int port) throws IOException {
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket client = server.accept();
                br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                new GetMessage().start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private class GetMessage extends Thread{
        @Override
        public void run() {
            try{
                String text;
                while ((text = br.readLine()) != null && !text.equals("exit")) {
                    System.out.println(text);
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

}

