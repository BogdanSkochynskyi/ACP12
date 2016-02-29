package ua.artcode.week3.scanner;

import java.io.IOException;
import java.io.Reader;
import java.util.InputMismatchException;

/**
 * Created by gavri on 25.02.2016.
 */
public class MyScannerG {

    private char[] data = null;
    private char[] buffer = new char[1000];
    private int currentStartPosition;
    private int currentPosition;
    private Reader reader;


    public MyScannerG(String text) {
        if (text != null){
            data = text.toCharArray();
        }
    }

    public MyScannerG(Reader reader) {
        if (reader != null){

            this.reader = reader;
            int count = 0;
            try {
                while ((count = reader.read(buffer, 0, buffer.length)) != -1) {
                    System.arraycopy(buffer, 0, data = new char[count], 0, count);
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


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
            if (data[currentPosition] == ' ' || data[currentPosition] == Character.LINE_SEPARATOR) {
                char[] tmpArray = new char[currentPosition - currentStartPosition];
                System.arraycopy(data, currentStartPosition, tmpArray, 0, currentPosition - currentStartPosition);
                currentPosition++;
                currentStartPosition = currentPosition;
                return new String(tmpArray);
            }
            char[] tmpArray = new char[currentPosition - currentStartPosition];
            System.arraycopy(data, currentStartPosition, tmpArray, 0, currentPosition - currentStartPosition);
            remains = new String(tmpArray);
        }
        if (currentPosition == data.length) {
            if (updateBuffer()) {
                currentPosition = 0;
                currentStartPosition = 0;

                return remains + next();
            } else if (currentStartPosition != currentPosition){
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
        if (currentStartPosition != data.length){
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

    public boolean hasNext(){
        boolean result = (currentStartPosition < data.length);
     //   if (result) result = (data[currentStartPosition] != '\u0000');
        return result;
    }
}






