package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IFramePage extends BasePage{

    @FindBy(xpath = "//div[@role='application']")
    private WebElement menuForm;

    @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
    private WebElement iframeBox;

    @FindBy(xpath = "//body[@id='tinymce']/p")
    private  WebElement textBox;
    public IFramePage(){
        PageFactory.initElements(driver,this);
    }

    public boolean checkTextInFrame(String msg){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(menuForm));
        driver.switchTo().frame(iframeBox);
        return textBox.getText().equals(msg);
    }
}
