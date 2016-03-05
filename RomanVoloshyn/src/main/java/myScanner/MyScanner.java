package myScanner;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;
import java.io.*;
import java.sql.SQLException;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyScanner {

    private int DEFAULT_SIZE_IN_BYTES = 1024;

    //собственно объект чтения
    private BufferedReader inputBufReader;
    private boolean inputReaderIsEmpty = false;
    private boolean inputReaderIsConsole = false;
    private int globalByteCounter = 0;

    //подкачка символов из объекта
    private int indexBuf = 0;
    private char[] bufChar = new char[DEFAULT_SIZE_IN_BYTES];
    private StringBuilder bufStrBuilder = new StringBuilder(DEFAULT_SIZE_IN_BYTES);

    //паттерны
    private Pattern PATTERN_DELIMITER = Pattern.compile("\\s+");
    private Pattern PATTERN_INT = Pattern.compile("\\d+");
    private Pattern PATTERN_DELIMITER_ROWS = Pattern.compile("\\n");

    public MyScanner() throws IOException {
        inputReaderIsEmpty = true;
        bufStrBuilder.append("default scanner");
    }

    public MyScanner(InputStream inputStream){
        inputReaderIsConsole = true;
        inputBufReader = new BufferedReader (new InputStreamReader(inputStream));
    }

    public MyScanner(Reader inputReader) throws IOException {
        inputBufReader = new BufferedReader(inputReader);
        pumpNextPart(false);
    }

    public MyScanner(String inputString) throws IOException {
        inputReaderIsEmpty = true;
        bufStrBuilder.append(inputString);
    }

    private boolean pumpNextPart(boolean trimAllow) throws IOException {
        if (inputReaderIsEmpty) {
            return false;
        }

        int counter = 0;
        if (inputReaderIsConsole) {
            String text;
            text = inputBufReader.readLine();
            if (text.equals("ESC")) {
                inputReaderIsEmpty = true;
                return false;
            }
            System.out.println(text);
            counter = text.length();
            return false;
        } else {
            counter = inputBufReader.read(bufChar);
            if (counter == -1) {
                inputReaderIsEmpty = true;
                return false;
            }
        }

        if (trimAllow && indexBuf >= DEFAULT_SIZE_IN_BYTES) {
            String currentString = bufStrBuilder.substring(indexBuf);
            bufStrBuilder = new StringBuilder(DEFAULT_SIZE_IN_BYTES + currentString.length());
            bufStrBuilder.append(currentString);
            indexBuf = 0;
        }

        globalByteCounter += counter;
        bufStrBuilder.append(bufChar);
        if (counter < DEFAULT_SIZE_IN_BYTES) {
            int index = bufStrBuilder.indexOf("\u0000");
            if (index != -1) {
                bufStrBuilder.delete(bufStrBuilder.indexOf("\u0000"), bufStrBuilder.length());
            }
        }

        return true;
    }

    //чтение вхождения по PATTERN_DELIMITER
    public String nextByPattern(Pattern pattern) throws IOException, InterruptedException {

        Matcher matcher = findMatcher(pattern);
        if (matcher == null) {
            return null;
        }

        int indexStartString = indexBuf;
        int indexStartPattern = matcher.start();
        indexBuf = matcher.end();

        if (indexStartPattern == indexStartString) {
            return nextByPattern(pattern);
        }

        return bufStrBuilder.substring(indexStartString, indexStartPattern);

    }

    //
    private Matcher findMatcher(Pattern pattern) throws IOException {
        while (true) {
            String currentString = bufStrBuilder.toString();
            Matcher matcher = pattern.matcher(currentString);

            if (!matcher.find(indexBuf)) {
                if (!pumpNextPart(true)) {
                    return null;
                }
            } else {
                return matcher;
            }
        }
    }

    public boolean hasNextByPattern(Pattern pattern) throws IOException, InterruptedException {
        while (true) {
            String currentString = bufStrBuilder.toString();
            Matcher matcher = pattern.matcher(currentString);

            if (!matcher.find(indexBuf)) {
                if (!pumpNextPart(false)) {
                    return false;
                }
            } else {//что-то нашли
                int index = matcher.start();
                if (index == indexBuf) {
                    //в таком варианте проблема будет в таком виде:
                    //hasNext -> useDelimiter -> hasNext
                    //часть строки уже может быть откушена
                    indexBuf = matcher.end();
                } else {
                    return !currentString.substring(indexBuf, index).isEmpty();
                }
            }
        }
    }

    //чтение по разделителю
    public String next() throws IOException, InterruptedException {
        return nextByPattern(PATTERN_DELIMITER);
    }

    //чтение всей строки
    public String nextLine() throws IOException, InterruptedException {
        return nextByPattern(PATTERN_DELIMITER_ROWS);
    }

    //определение наличия в потоке данных
    public boolean hasNext() throws IOException, InterruptedException {
        return hasNextByPattern(PATTERN_DELIMITER);
    }

    //чтение целого числа из строки или InputMismatchException
    public int nextInt() throws IOException {
        Matcher matcher = findMatcher(PATTERN_INT);
        if (matcher == null) {
            return 0;
        }

        int indexEnd = matcher.end();
        if (indexEnd == bufStrBuilder.length() && pumpNextPart(true)) {
            return nextInt();
        }

        indexBuf = indexEnd;
        return Integer.parseInt(bufStrBuilder.substring(matcher.start(), indexEnd));
    }

    //определение наличия в потоке целого int числа
    public boolean hasNextInt() throws IOException {

        return findMatcher(PATTERN_INT) != null;

    }

    //использует разделитель
    public void useDelimiter(String newDelimiter) {
        PATTERN_DELIMITER = Pattern.compile(newDelimiter);
    }

//    close() - закрытие сканнера, теперь нельзя использовать и NoSuchElementException

}
