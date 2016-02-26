package myScanner;

import java.io.*;

public class MyScanner implements Closeable {
    private String path;
    private InputStream inputStream;

    public MyScanner(String path) {
        this.path = path;
    }

    public void next() throws IOException {

        inputStream = new FileInputStream(path);

        int data = inputStream.read();
        char content;

        while (data != -1) {
            content = (char) data;
            if (content == ' ') break;
            System.out.print(content);
            data = inputStream.read();
        }
        System.out.println();
        inputStream.close();
    }

    public void nextLine() throws IOException {

        inputStream = new FileInputStream(path);

        int data = inputStream.read();
        char content;

        while (data != -1) {
            content = (char) data;
            if (content == '\n') break;
            System.out.print(content);
            data = inputStream.read();
        }
        System.out.println();
        inputStream.close();
    }

    public boolean hasNext() throws IOException {
        inputStream = new FileInputStream(path);
        int data = inputStream.read();
        return data != -1;
    }

    public boolean hasInt() throws IOException{
        inputStream = new FileInputStream(path);
        int data = inputStream.read();
        char content;
        while(data != -1) {

            content = (char) data;
            String number = String.valueOf(content);

            try {
                Integer.parseInt(number);
                return true;
            } catch (Exception e) {
                data = inputStream.read();
            }

        }
        inputStream.close();
        return false;
    }


    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
