package client_server_app;


import java.io.*;
import java.net.Socket;

public class MyClient1 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("192.168.1.226", 7777);

        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));  //входной поток
//        PrintWriter pw = new PrintWriter(client.getOutputStream(), true);         //выходной поток

        StringBuilder sb = new StringBuilder();

        String line = null;

//        while ((line = br.readLine()) != null){
            pw.print(line);
            System.out.println(line);
        }

    }
}
