package by.teachmeskills.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {
    protected static WebDriver driver;
    protected Alert alert;
    private static final Duration DEFAULT_TIMEOUT_SECONDS = Duration.ofSeconds(10);
    protected String baseUrl = "http://the-internet.herokuapp.com";
    protected WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS);

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    protected WebDriverWait waitForElement(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public Alert waitAlertIsPresent() {
        return alert = new WebDriverWait(driver, DEFAULT_TIMEOUT_SECONDS).until(ExpectedConditions.alertIsPresent());
    }

    protected void waitAndClick(WebElement locator) {
//        new Actions(driver).click(wait.until(ExpectedConditions.elementToBeClickable(locator)));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected WebElement waitVisibility(WebElement locator) {
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }
}
