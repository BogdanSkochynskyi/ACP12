package artcode.week4.day2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Олександр on 21.03.2016.
 */
public class RunClient {

    public static void main(String[] args) {

        try {
            String line = null;
            StringBuilder sb = new StringBuilder();
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            Socket socket = new Socket(inetAddress, 8080);

            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            PrintWriter toServer = new PrintWriter(outputStream, true);
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(inputStream));
            BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                line = fromConsole.readLine();
                System.out.println(line);

                toServer.write(line);
                toServer.flush();

                line = fromServer.readLine();
                System.out.println(line);

//                toServer.close();
//                fromServer.close();
//                fromConsole.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
