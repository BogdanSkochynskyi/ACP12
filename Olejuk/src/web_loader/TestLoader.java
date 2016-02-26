package web_loader;

/**
 * Created by dexter on 25.02.16.
 */
public class TestLoader {
    public static void main(String[] args) {
        ImageLoader loader = new ImageLoader();
        try {
            loader.load("http://www.ex.ua/11841246?r=82539,80936", "/home/dexter/Pictures/", "picture");
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
