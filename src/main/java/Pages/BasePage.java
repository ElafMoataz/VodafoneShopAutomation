package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    static WebDriver browser;
    BasePage(WebDriver desiredBrowser){

        browser = desiredBrowser;
        PageFactory.initElements(browser, this);
    }

    public void waitElement(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void scrollElementIntoView(WebElement element){
        JavascriptExecutor j = (JavascriptExecutor) browser;
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
    }
}
