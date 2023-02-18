package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
    Notification Messages - кликнуть на кнопку, дождаться появления нотификации, проверить соответствие
    текста ожиданиям.
    https://stackoverflow.com/questions/20903231/how-to-make-selenium-wait-until-an-element-is-present
    http://the-internet.herokuapp.com/notification_message
 */
public class NotificationMessagePage extends BasePage {

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement actionMsg;

    @FindBy(xpath = " //a[contains(@href,'/notification_message')]")
    private WebElement actionLink;

    public NotificationMessagePage() {
        driver.get("http://the-internet.herokuapp.com/notification_message");
        PageFactory.initElements(driver, this);
    }

    public boolean checkActionMsg(String msg) {
        actionLink.click();
        waitForMessage();
        return actionMsg.getText().equals(msg);
    }

    private void waitForMessage() {
        if (driver != null) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(actionMsg));
        }
    }
}
