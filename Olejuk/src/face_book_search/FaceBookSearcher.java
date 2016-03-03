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
import java.util.List;

/**
 * Created by dexter on 01.03.16.
 */
public class FaceBookSearcher {

    public final static String FACE_BOOK_PATH = "https://www.facebook.com";
    public String homeUrl;

    private String pageSource;
    private WebDriver driver = new FirefoxDriver();

    private FaceBookSearcher(WebDriver driver) {
        this.driver = driver;
        getHomeUrl();
    }

    public static FaceBookSearcher logIn(String email, String pass) throws LogException{
        return new FaceBookSearcher(enterOnFaceBook(email, pass));
    }

    private static WebDriver enterOnFaceBook(String email, String pass) throws LogException{
        WebDriver driver = new FirefoxDriver();
        driver.get(FACE_BOOK_PATH);

        do {
            WebElement emailElement = driver.findElement(By.id("email"));
            WebElement passElement = driver.findElement(By.id("pass"));
            WebElement submitElement = driver.findElement(By.id("u_0_v"));

            emailElement.sendKeys(email);
            passElement.sendKeys(pass);

            submitElement.click();

            if(driver.getCurrentUrl().equals("https://www.facebook.com/login.php?login_attempt=1&lwv=110")){
                throw new LogException("incorrect login or pass");
            }

        } while (!"Facebook".equals(driver.getTitle()));

        System.out.println(driver.getTitle());

        return driver;
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

        driver.get(homeUrl + "/friends_all");

        WebElement element = driver.findElement(By.xpath("//*[@class='_3c_ _3s-']"));
        List<WebElement> spans = element.findElements(By.tagName("span"));

        System.out.println(spans.get(0).getText() + " - " + spans.get(1).getText());

        return Integer.parseInt(spans.get(1).getText());
    }

    private void getHomeUrl() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"u_0_1\"]/div[1]/div[1]/div/a"));
        homeUrl = element.getAttribute("href");
    }
}
