package Tests.stepDefs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver browser;
    public static void  setUp() {
        Properties prop = System.getProperties();
        try {
            prop.load(new FileInputStream("src/test/resources/Test.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        switch (System.getProperty("browserType").toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                browser = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                browser = new FirefoxDriver();
                break;
        }
        browser.manage().deleteAllCookies();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.manage().window().maximize();
    }
    public static void loadVodafoneShopWebsite(){
        browser.get(System.getProperty("vfWebsite"));
    }
    public static void quitBrowser(){
        browser.quit();
    }
}
