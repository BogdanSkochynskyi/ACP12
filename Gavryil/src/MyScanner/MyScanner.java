package MyScanner;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by gavri on 25.02.2016.
 */
public class MyScanner {

    char[] data = null;
    char[] buffer = new char[10];
    int currentStartPosition;
    int currentPosition;
    Reader reader;


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

    public MyScanner (String text){

        data = text.toCharArray();

    }

    public MyScanner(Reader reader){
        this.reader = reader;
        int count = 0;
        try {
            while ((count = reader.read(buffer,0,buffer.length))!= -1){
                System.arraycopy(buffer,0,data = new char[count],0,count);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String next(){
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
    }

    private void updateBuffer(){
        int count = 0;
        try {
            while ((count = reader.read(buffer,0,buffer.length))!= -1) {
                if (data == null) data = new char[count];
                System.arraycopy(buffer, 0, data, 0, count);
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String nextUsingUpdate(){
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
                updateBuffer();
                currentPosition = 0;
                currentStartPosition = 0;

            return nextUsingUpdate();
        }
        return null;
    }

}



