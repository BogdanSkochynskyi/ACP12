package face_book_search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dexter on 01.03.16.
 */
public class FaceBookSearcher {

    public final String FACE_BOOK_PATH = "https://www.facebook.com";
    public String currentPage;
    private String pageSource;

    public FaceBookSearcher(String email, String pass) {
        enterOnFaceBook(email, pass);
    }

    private void enterOnFaceBook(String email, String pass) {
        WebDriver driver = new FirefoxDriver();
        driver.get(FACE_BOOK_PATH);
        System.out.println(driver.getTitle());

        do {
            WebElement emailElement = driver.findElement(By.id("email"));
            WebElement passElement = driver.findElement(By.id("pass"));
            WebElement submitElement = driver.findElement(By.id("u_0_v"));

            emailElement.sendKeys(email);
            passElement.sendKeys(pass);

            submitElement.click();
        } while(!"Facebook".equals(driver.getTitle()));
        System.out.println(driver.getTitle());
    }

    // download all from page... for future search
    private String loadPage(String path) throws MalformedURLException {
        URL url = new URL(path);
        StringBuilder stringBuilder = new StringBuilder();
        int kB = 8;

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            char[] buff = new char[8192];

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while(br.read(buff) != -1){
                stringBuilder.append(buff);
                buff = new char[8192];
                kB += 8;
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(kB + " Kb was loaded");
        //System.out.println(stringBuilder.toString());


        return stringBuilder.toString();
    }

    public int getAllFriends() throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {

//        currentPage = yourPage + "/friends_all";
//        pageSource = loadPage(currentPage);


//        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(currentPage);
//
//        XPath xPath = XPathFactory.newInstance().newXPath();
//        String str = xPath.compile("//*[@id=\"u_jsonp_2_0\"]").evaluate(document);
//
//        System.out.println(str);

        return 0;
    }
}
