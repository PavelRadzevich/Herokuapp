package by.teachmeskills.pageobjects;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

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

    public JavaScriptExecutorPage(){
        driver.get("http://the-internet.herokuapp.com/");
        PageFactory.initElements(driver,this);
    }

    public void setDown50pix(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)");
    }

    public void setDownByText(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aMultiWindow);
    }
}
