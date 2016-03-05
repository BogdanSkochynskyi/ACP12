package ua.artcode.week1.rec;

/**
 * Created by master on 14.02.16.
 */
public class RecursionUtils {

    // abcd -
    // abc  d
    // ab  c
    // a b
    public static String reverse(String in){

        if(in.isEmpty()){
           return "";
        }

        String first = in.substring(0,1);
        String rest = in.substring(1,in.length());

        String returnedRec = reverse(rest);

        return returnedRec + first;
    }
}
