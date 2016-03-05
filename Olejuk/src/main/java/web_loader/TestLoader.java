package web_loader;

/**
 * Created by dexter on 25.02.16.
 */
public class TestLoader {

    private static final String testWebPath = "http://www.ex.ua/11841246?r=82539,80936";
    private static final String destinationDirectoryPath = "/home/dexter/Pictures/testDownload/";
    private static final String fileType = "jpg";

    public static void main(String[] args) {
        Loader loader = new Loader();
        try {
            loader.load(testWebPath, destinationDirectoryPath, fileType);
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
