package ua.artcode.week2;

/**
 * Created by Олександр on 25.02.2016.
 */
public interface IScanner {

    String next ();

    int nextInt();

    String nextLine();

    boolean hasNext();

    boolean hasNextInt();

    void useDelimiter(String delimiter);

    void close();

}
