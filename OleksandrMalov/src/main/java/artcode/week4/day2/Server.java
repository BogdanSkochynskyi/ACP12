package artcode.week4.day2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Олександр on 21.03.2016.
 */
public class Server {

    private int id;

    public void run(){

        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            Socket client = serverSocket.accept();

            String clientInfo = String.format("number of connection %d, address %s, port %d",
                    id++,
                    client.getInetAddress(),
                    client.getPort());


            System.out.println(clientInfo);
            String line = null;

            OutputStream outputStream = client.getOutputStream();
            InputStream inputStream = client.getInputStream();



            PrintWriter toClient = new PrintWriter(outputStream, true);
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(inputStream));
            BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));


            while (true) {

                line = fromClient.readLine();
                System.out.println(line);

                line = fromConsole.readLine();
                toClient.write(line);
                toClient.flush();

                line = fromClient.readLine();
                System.out.println(line);

//                toClient.close();
//                fromClient.close();
//                fromConsole.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
