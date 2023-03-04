package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {
    protected static WebDriver driver;
    protected String baseUrl = "http://the-internet.herokuapp.com";

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    protected WebDriverWait waitForElement(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }
}
