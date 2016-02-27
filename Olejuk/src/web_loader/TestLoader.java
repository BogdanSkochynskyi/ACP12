package web_loader;

/**
 * Created by dexter on 25.02.16.
 */
public class TestLoader {
    public static void main(String[] args) {
        Loader loader = new Loader();
        try {
            loader.load("http://www.ex.ua/11841246?r=82539,80936", "/home/dexter/Pictures/", "jpg");
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
