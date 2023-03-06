package by.teachmeskills.demoqa;

import by.teachmeskills.pageobjects.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowPage;

    public MainPage() {
        driver.get("https://demoqa.com/");
        PageFactory.initElements(driver, this);
    }

    public AlertsWindowsPage getAlertPage() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", alertsFrameWindowPage);
        return new AlertsWindowsPage();
    }
}