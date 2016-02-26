package MyScanner;

import java.io.*;

public class MyScanner implements Closeable{

    private Reader reader;
    private StringBuilder dataLine = new StringBuilder();
    private char[] buffer = new char[1024];

    public MyScanner(InputStream is) {
        reader = new InputStreamReader(is);
    }

    public MyScanner(File file) throws FileNotFoundException {
        reader = new InputStreamReader(new FileInputStream(file));
    }

    public String next() throws IOException {
        int index = 0;
        while (isEndOfWord(index)) {
             index++;
        }
        return String.valueOf(buffer).trim();
    }

    private boolean isEndOfWord(int index) throws IOException {
        return (buffer[index] = (char) reader.read()) != ' ';
    }

    public int nextInt(){
        return 0;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
