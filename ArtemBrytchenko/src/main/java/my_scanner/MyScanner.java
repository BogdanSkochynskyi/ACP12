package my_scanner;

import java.io.*;

public class MyScanner implements Closeable{

    private Reader reader;
    private StringBuilder dataLine;
    private char[] buffer = new char[1024];
    private static int startIndex, endIndex = 0;
    private char delimiter = ' ';

    public MyScanner() {
    }

    public MyScanner(InputStream is) {
        reader = new InputStreamReader(is);
        read();
    }

    public char[] getBuffer() {
        return buffer;
    }

    public MyScanner(String filePath) throws FileNotFoundException {
        reader = new InputStreamReader(new FileInputStream(new File(filePath)));
        read();
        int startIndex, endIndex = 0;
    }

    private void read(){
        dataLine = new StringBuilder();
        try {
            do {
                reader.read(buffer, 0, buffer.length);
                dataLine.append(buffer);
            } while (buffer.length != 1024);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public String next() throws IOException {
        String s = "";
        if (dataLine.charAt(startIndex) == 0){
            throw new StringIndexOutOfBoundsException();
        }
        for (int i = startIndex; i < dataLine.length(); i++) {
            if (dataLine.charAt(i) == delimiter || dataLine.charAt(i) == 0) {
                s = dataLine.substring(startIndex, i + 1);
                startIndex = endIndex + 2;
                endIndex = i;
                return s;
            }
            endIndex = i;
        }
        return s;
    }

    public int nextInt() throws IOException {
        if (hasNextInt()){
            for (int i = 0; i < dataLine.length();) {
                if (dataLine.substring(i, i+1).equals(" ")) {
                    return Integer.parseInt(dataLine.substring(0, i));
                } else i++;
            }
        }
        return Integer.parseInt(dataLine.toString().trim());
    }

    public String nextLine(){
        for (int i = 0; i < dataLine.length();) {
            if (dataLine.substring(i, i+1).equals(".") || dataLine.substring(i, i+1).equals("\n")) {
                return dataLine.substring(0, i);
            } else i++;
        }
        return String.valueOf(dataLine);
    }

    public boolean hasNext(){
        return dataLine.length() != 0;
    }

    public boolean hasNextInt() throws IOException {
        return Character.isDigit(buffer[0]);
    }

    /*private void resetBuffer(){
        dataLine = new StringBuilder();
    }*/

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
