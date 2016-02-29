package MyScanner;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by gavri on 25.02.2016.
 */
public class MyScanner {

    public static final int BUFFER_CAPACITY = 1000;
    private char[] data = null;
    private char[] buffer = new char[BUFFER_CAPACITY];
    private int currentStartPosition;
    private int currentPosition;
    private Reader reader;
    private char delimiter = ' ';
    private char defautLineSeparator = Character.LINE_SEPARATOR;
    private String delimiterString;


    public MyScanner(String text) {
        if (text != null) {
            data = text.toCharArray();
        }
    }

    public MyScanner(Reader reader) {

        initializeReader(reader);

    }

    private void initializeReader(Reader reader) {

        if (reader != null) {
            this.reader = reader;
            int count = 0;
            try {
                count = reader.read(buffer, 0, buffer.length);
                System.arraycopy(buffer, 0, data = new char[count], 0, count);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private boolean updateBuffer() {
        if (reader == null) return false;
        int count = 0;
        try {
            while ((count = reader.read(buffer, 0, buffer.length)) != -1) {
                if (data == null) data = new char[count];
                System.arraycopy(buffer, 0, data, 0, count);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public String next() {
        String remains = "";
        for (; currentPosition < data.length; currentPosition++) {
            if (data[currentPosition] == delimiter || data[currentPosition] == defautLineSeparator) {
                if (delimiterString != null)  {
                    String res = checkCoincidence();
                   if (res != null) return res;
                }
                if (delimiterString == null) {
                    char[] tmpArray = new char[currentPosition - currentStartPosition];
                    System.arraycopy(data, currentStartPosition, tmpArray, 0, currentPosition - currentStartPosition);
                    currentPosition++;
                    currentStartPosition = currentPosition;
                    return new String(tmpArray);
                }
            }
        }
        if (delimiterString == null){
            char[] tmpArray = new char[currentPosition - currentStartPosition];
            System.arraycopy(data, currentStartPosition, tmpArray, 0, currentPosition - currentStartPosition);
            remains = new String(tmpArray);
        } else {
            updateBuffer(currentStartPosition, data.length - currentStartPosition);
            for (; currentPosition < data.length; currentPosition++) {
                if (data[currentPosition] == delimiter || data[currentPosition] == defautLineSeparator) {
                    if (delimiterString != null) {
                        String res = checkCoincidence();
                        if (res != null) return res;
                    }
                }
            }
        }

        if (currentPosition == data.length) {
            if (updateBuffer()) {
                currentPosition = 0;
                currentStartPosition = 0;

                return remains + next();
            } else if (currentStartPosition != currentPosition) {
                currentStartPosition = currentPosition;
                return remains;
            }

        }
        return null;
    }

    public int nextInt() {

        String num = next();
        boolean exception = false;


        for (int i = 0; i < num.length(); i++) {
            char tmp = num.charAt(i);
            if (!(Character.isDigit(tmp))) {
                exception = true;
                break;
            }
        }

        if (exception) throw new InputMismatchException("String is not a number");

        int result = Integer.parseInt(num);
        return result;
    }


    public String nextLine() {
        String remains = "";
        for (; currentPosition < data.length; currentPosition++) {
            if (data[currentPosition] == Character.LINE_SEPARATOR) {
                char[] tmpArray = new char[currentPosition - currentStartPosition];
                System.arraycopy(data, currentStartPosition, tmpArray, 0, currentPosition - currentStartPosition);
                currentPosition++;
                currentStartPosition = currentPosition;
                return new String(tmpArray);
            }

        }
        if (currentStartPosition != data.length) {
            char[] tmpArray = new char[currentPosition - currentStartPosition];
            System.arraycopy(data, currentStartPosition, tmpArray, 0, currentPosition - currentStartPosition);
            remains = new String(tmpArray);
        }
        if (currentPosition == data.length) {
            if (updateBuffer()) {
                currentPosition = 0;
                currentStartPosition = 0;

                return remains + nextLine();
            } else {
                return new String(data);
            }

        }
        return null;
    }

    public boolean hasNext() {
        boolean result = (currentStartPosition < data.length);
        return result;
    }

    public void useDelimiter(String pattern){
        if (pattern!= null) {
            if (pattern.length() == 1) {
                delimiter = pattern.charAt(0);
                defautLineSeparator = pattern.charAt(0);
            } else {
                delimiterString = pattern;
                delimiter = pattern.charAt(0);
                defautLineSeparator = delimiter = pattern.charAt(0);
            }
        }

    }

    public void reset(){
        delimiter = ' ';
        defautLineSeparator = Character.LINE_SEPARATOR;

        delimiterString = null;
    }

    private String checkCoincidence(){
        int index = currentPosition;
        if (data.length - index < delimiterString.length()){
            updateBuffer(currentPosition, data.length - currentPosition);
        }
        index = currentPosition;
        int hits = 1;
            for (int i = hits; i < delimiterString.length(); i++){
                if (data[index+i] != delimiterString.charAt(i)) return null;
                    hits++;
            }

            char[] tmp = new char[currentPosition - currentStartPosition];
            System.arraycopy(data,currentStartPosition,tmp,0,currentPosition - currentStartPosition);
            currentStartPosition = currentPosition + delimiterString.length();
            currentPosition = currentStartPosition;
            return new String(tmp);
    }
//should be void
    private boolean updateBuffer(int saveCharFromPositin, int charsNumber ) {
        if (reader == null) return false;
        int count = 0;
          try {
              count = reader.read(buffer, charsNumber, buffer.length-charsNumber);
              System.arraycopy(data,saveCharFromPositin,buffer,0,charsNumber);
              System.arraycopy(buffer, 0, data, 0, count + charsNumber);
              currentPosition = 0;
              currentStartPosition = 0;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }





    // Constructor which allows you to download whole file to char[] during creation of MyScanner object
   /* public MyScanner(Reader reader){
        this.reader = reader;
        int count = 0;
        try {
            while ((count = reader.read(buffer,0,buffer.length))!= -1){
                if (data == null){
                    data = buffer;
                    buffer = new char[2000];

                } else {
                    char [] tmp = new char[data.length + count];
                    System.arraycopy(data,0,tmp,0,data.length);
                    System.arraycopy(buffer,0,tmp,data.length,count);
                    data = tmp;
                    tmp = null;
                }
                if (count <= data.length) {
                    char[] tmp = new char[count];
                    System.arraycopy(data,0,tmp,0,count);
                    data = tmp;
                    tmp = null;
                }

                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    //Method next which works only with constructor which save whole file to char array during MyScanner creation

   /* public String next(){
        for (; currentPosition < data.length; currentPosition++){
            if (data[currentPosition] == ' '|| data[currentPosition] == Character.LINE_SEPARATOR){
                char[] tmpArray = new char[currentPosition-currentStartPosition];
                System.arraycopy(data,currentStartPosition,tmpArray,0,currentPosition-currentStartPosition);
                currentPosition++;
                currentStartPosition = currentPosition;
                return new String(tmpArray);
            }
        }
        if (currentPosition == data.length){
            char[] tmpArray = new char[currentPosition-currentStartPosition];
            System.arraycopy(data,currentStartPosition,tmpArray,0,currentPosition-currentStartPosition);
            currentPosition++;
            currentStartPosition = currentPosition;
            return new String(tmpArray);
        }
        return null;
    }*/
}










