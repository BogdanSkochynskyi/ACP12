package blasoUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class Downloader_BS {

    public static void load(String textURL, String destination) {

        URL url = null;
        URLConnection connection = null;
        InputStream inputStream = null;

        try {
            url = new URI(textURL).toURL();
            connection = url.openConnection();
            connection.getContent();
            inputStream = url.openStream();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        final int bytesInMB = 1024 * 1024;

        String[] loadingFilePath = connection.getURL().getFile().split("/");
        String loadingfileName = loadingFilePath[loadingFilePath.length - 1];
        long loadingfileLength = connection.getContentLengthLong();

        String localFileName = destination.endsWith("\\") ? destination + loadingfileName : destination;
        System.out.printf("Downloading: %s (%d MB)\n", localFileName, loadingfileLength / bytesInMB);

        long loadingBytes = 0;
        ProgressBar_BS progress = new ProgressBar_BS();

        try {
            int count = 0;
            byte[] buffer = new byte[8192];
            OutputStream outputStream = new FileOutputStream(localFileName);
            while ((count = inputStream.read(buffer)) != -1) {

                outputStream.write(buffer, 0, count);
                outputStream.flush();

                loadingBytes += count;
                progress.updateProgress(100 * loadingBytes / (double) loadingfileLength);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
