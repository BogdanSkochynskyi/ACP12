package my_scanner;

import java.io.*;

/**
 * Created by dexter on 23.02.16.
 */
public class MyScanner implements Closeable{

    private final static int DEFAULT_BUFFER_CAPACITY = 1024;
    private Reader reader;
    private StringBuilder strBuilder = new StringBuilder();
    private char delimiter = ' ';

    public MyScanner(InputStream source){
            reader = new InputStreamReader(source);
    }

    public MyScanner(File fileName) throws FileNotFoundException{
        reader = new InputStreamReader(new FileInputStream(fileName));
        read();
    }

    private void read(){
        strBuilder = new StringBuilder();
        int ready = 0;
        try {
            do {
                char[] bArray = new char[DEFAULT_BUFFER_CAPACITY];
                ready = reader.read(bArray, 0, bArray.length);
                strBuilder.append(bArray);
            }while(ready == DEFAULT_BUFFER_CAPACITY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String nextLine(){

        if(!hasNext()){
            read();
        }

        String out = strBuilder.substring(0, strBuilder.indexOf("\n")+1);
        strBuilder.delete(0, strBuilder.indexOf("\n")+1);
        return out;
    }

    public String next(){
        if(!hasNext()){
            read();
        }
        String out = "";
        try{
            out = strBuilder.substring(0, strBuilder.indexOf(String.valueOf(delimiter)));
            strBuilder.delete(0, strBuilder.indexOf(String.valueOf(delimiter))+1);
        }catch (StringIndexOutOfBoundsException e){
            out = strBuilder.substring(0, strBuilder.indexOf("\n"));
            strBuilder.delete(0, strBuilder.indexOf("\n"));
        }

        return out;
    }

    public void useDelimiter(char newDelimiter){
        delimiter = newDelimiter;
    }

    public int nextInt(){
        return Integer.parseInt(next());
    }

    public boolean hasNext(){
        if(strBuilder.length() == 0 || strBuilder.charAt(0) == '\u0000'){
            return false;
        }
        return true;
    }

    public boolean hasInt(){
        try{
            String futureInt = strBuilder.substring(0, strBuilder.indexOf(String.valueOf(delimiter)));
            Integer.parseInt(String.valueOf(futureInt));
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
