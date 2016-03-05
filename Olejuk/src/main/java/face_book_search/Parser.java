package face_book_search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dexter on 01.03.16.
 */
public class Parser {
    public static List<String> parseHref(String html){

        ArrayList<String> hrefs = new ArrayList<>();

        String httpPattern = "(https://).+?\"";
        Pattern pattern = Pattern.compile(httpPattern);
        Matcher matcher = pattern.matcher(html);

        if (matcher.find()) {
            do {
                String delimiter = matcher.group();
                delimiter = delimiter.substring(0, delimiter.length()-1);
                System.out.println("found" + delimiter);
                hrefs.add(delimiter);
                html = html.substring(matcher.start()+delimiter.length());
                matcher = pattern.matcher(html);
            } while (matcher.find());
        }

        return hrefs;
    }




}
