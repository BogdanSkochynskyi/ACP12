package artcode.week4.day2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Олександр on 21.03.2016.
 */
public class RunServer {

    public static void main(String[] args) {

        new Server().run();
    }
}
