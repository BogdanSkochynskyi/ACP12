package myScanner;

import java.io.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyScanner {

    //собственно объект чтения
    private boolean inputReaderIsEmpty = false;
    private Reader inputReader;

    //подкачка символов из объекта
    private char[] bufChar = new char[1024];
    //private int countReading = 0;

    //буфер строки
    private int indexBuf = 0;
    private StringBuilder bufStrBuilder = new StringBuilder();

    //паттерны
    private Pattern PATTERN_DELIMITER = Pattern.compile("\\s+");
    private Pattern PATTERN_INT = Pattern.compile("\\d+");
    private Pattern PATTERN_DELIMITER_ROWS = Pattern.compile("\\n");

//    public MyScanner(InputStream inputStream){
//        this.inputStream = inputStream;
//    }

    public MyScanner(Reader inputReader) throws IOException {
        this.inputReader = inputReader;
        pumpNextPart();
    }

    private boolean pumpNextPart() throws IOException {
        if (inputReaderIsEmpty) {
            return false;
        }

        int counter = inputReader.read(bufChar);
        if (counter == -1) {
            inputReaderIsEmpty = true;
            return false;
        }

        bufStrBuilder.append(bufChar);
        if (counter < 1024) {
            int index = bufStrBuilder.indexOf("\u0000");
            if (index != -1) {
                bufStrBuilder.delete(bufStrBuilder.indexOf("\u0000"), bufStrBuilder.length());
            }
        }

        return true;
    }

    //чтение вхождения по PATTERN_DELIMITER
    public String next() throws IOException, InterruptedException {
        while (true) {
            String currentString = bufStrBuilder.toString();
            Matcher matcher = PATTERN_DELIMITER.matcher(currentString);

            if (!matcher.find(indexBuf)) {
                if (!pumpNextPart()) {
                    return null;
                }
            } else {//что-то нашли
                currentString = currentString.substring(indexBuf, matcher.start());
                indexBuf = matcher.end();
                return currentString;
            }
        }
    }

    //определение наличия в потоке данных
    public boolean hasNext() {
        return false;
    }

    // - чтение целого числа из строки или InputMismatchException
    public int nextInt() {
        return 0;
    }

    //чтение всей строки
    public String nextLine() {
        return "";
    }

    //определение наличия в потоке целого int числа
    public boolean hasNextInt() {
        return false;
    }

    //использует разделитель
    public void useDelimiter(String newDelimiter) {
        PATTERN_DELIMITER = Pattern.compile(newDelimiter);
    }

//    close() - закрытие сканнера, теперь нельзя использовать и NoSuchElementException

}
