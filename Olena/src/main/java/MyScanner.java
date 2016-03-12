
import java.io.*;
import java.util.*;

public class MyScanner implements Closeable{

    private static final int BUFFER_SIZE = 3486;
    private char[] buffer;
    private Reader reader;
    private String delimiter = "\u0020";
    private List<String> words;
    private StringBuilder contentsOfAFile = new StringBuilder();
    private ListIterator<String> wordsIterator;

    public MyScanner(String path) throws IOException {

        reader = new FileReader(path);
        buffer = new char[BUFFER_SIZE];
        words = new ArrayList<>();
        fillBuffer();

    }

    protected void fillBuffer() throws IOException {

        while(reader.read() != -1){
            reader.read(buffer);
            contentsOfAFile.append(buffer);
        }

        parseWords();

    }

     protected void parseWords(){

        String[] words = contentsOfAFile.toString().split(delimiter);

        this.words.clear();
        for(int i=0; i<words.length; i++) {
            this.words.add(words[i]);
        }

        wordsIterator = this.words.listIterator();
    }

    public String next() throws IOException{ return wordsIterator.next(); }

    public int nextInt() throws IOException { return Integer.parseInt(next());}

    public String nextLine() throws IOException {

      StringBuilder sb = new StringBuilder();

        while(wordsIterator.hasNext()) {
            String poc = wordsIterator.next();

            if(poc.contains("\r\n")) {
                sb.append(poc.substring(0, poc.indexOf("\r")-1));
                break;
            } else {
                sb.append(poc+delimiter);
            }

        }
        return sb.toString();
    }

    public boolean hasNext() throws IOException { return wordsIterator.hasNext(); }

    public boolean hasNextInt(){

        if(!wordsIterator.hasNext()) {
            return false;

        } else {

            char[] toCheck = wordsIterator.next().toCharArray();
            wordsIterator.previous();

            for (int i = 0; i < toCheck.length; i++) {
                if (!Character.isDigit(toCheck[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public void useDelimiter(String delimiter){
        this.delimiter = delimiter;
        parseWords();
    }

    @Override
    public void close() throws IOException { reader.close(); }

    public String getContentsOfAFile(){
        return contentsOfAFile.toString();
    }
}
