package my_chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by dexter on 06.03.16.
 */
public class Client {

    Socket socket;

    public void run(String ip, int port){

        try{

            socket = new Socket(ip, port);
            System.out.printf("connect to %s\n", socket);
            new Write().start();
            new Read().start();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private class Write extends Thread{

        @Override
        public void run(){
            try (PrintWriter pw = new PrintWriter(socket.getOutputStream())) {

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
            try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

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
