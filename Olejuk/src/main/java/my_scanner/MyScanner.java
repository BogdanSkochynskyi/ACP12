package my_scanner;

import java.io.*;

/**
 * Created by dexter on 23.02.16.
 */
public class MyScanner implements Closeable{

    private final static int DEFAULT_BUFFER_CAPACITY = 8192;
    private Reader reader;
    private StringBuilder strBuilder = new StringBuilder();
    private String delimiter = " ";
    private Integer intBuffer;

    public MyScanner(InputStream source){
            reader = new InputStreamReader(source);
    }

    public MyScanner(File fileName) throws FileNotFoundException{
        reader = new InputStreamReader(new FileInputStream(fileName));
        readStream();
    }

    private void readStream() {
        strBuilder = new StringBuilder();

        char[] buff = new char[DEFAULT_BUFFER_CAPACITY];

        try {
            reader.read(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }

        strBuilder.append(buff);
    }

    public String nextLine(){
        if(!hasNext()){
            readStream();
        }

        String out = strBuilder.substring(0, strBuilder.indexOf("\n")+1);
        strBuilder.delete(0, strBuilder.indexOf("\n")+1);
        return out;
    }

    public String next(){
        if(!hasNext()){
            readStream();
        }
        String out = "";
        try{
            out = strBuilder.substring(0, strBuilder.indexOf(delimiter));
            strBuilder.delete(0, strBuilder.indexOf(delimiter)+1);
        }catch (StringIndexOutOfBoundsException e){
            out = strBuilder.substring(0, strBuilder.indexOf("\n"));
            strBuilder.delete(0, strBuilder.indexOf("\n"));
        }

        return out;
    }

    public void useDelimiter(String newDelimiter){
        delimiter = newDelimiter;
    }

    public int nextInt(){
        if(intBuffer != null){
            int out = intBuffer;
            intBuffer = null;
            return out;
        }
        return Integer.parseInt(next());
    }

    public boolean hasNext(){
        return !(strBuilder.length() == 0 || strBuilder.charAt(0) == '\u0000');
    }

    public boolean hasInt(){
        try{
            intBuffer = new Integer(next());
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public void reset(){
        strBuilder = new StringBuilder();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

}
