package by.teachmeskills.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
    JavaScriptExecutor
      - Проскролить через JS по пикселям на 50 вниз;
      - Проскролить через JS до  видимости элемента Multiple Windows;
      - Реализовать скроллирование в самый низ страницы через JS;
      - Реализовать скроллирование вверх страницы через JS;
    http://the-internet.herokuapp.com/
 */
public class JavaScriptExecutorPage extends BasePage {

    @FindBy(xpath = "//a[text()='Multiple Windows']")
    private WebElement aMultiWindow;

    @FindBy(xpath = "//a[normalize-space()='Geolocation']")
    private WebElement down50PixelElement;
    @FindBy(xpath = "//a[@target='_blank']")
    private WebElement bottomElement;

    @FindBy(xpath = "//h1[@class='heading']")
    private WebElement topElement;

    public JavaScriptExecutorPage() {
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean setDown50pix() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        return waitForElement(15)
                .until(ExpectedConditions.visibilityOf(down50PixelElement))
                .isDisplayed();
    }

    public boolean setDownByText() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aMultiWindow);
        return waitForElement(15)
                .until(ExpectedConditions.visibilityOf(aMultiWindow))
                .isDisplayed();
    }

    public boolean setUpPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,0)");
        return waitForElement(15)
                .until(ExpectedConditions.visibilityOf(topElement))
                .isDisplayed();
    }

    public boolean setDownPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        return waitForElement(15)
                .until(ExpectedConditions.visibilityOf(bottomElement))
                .isDisplayed();
    }
}