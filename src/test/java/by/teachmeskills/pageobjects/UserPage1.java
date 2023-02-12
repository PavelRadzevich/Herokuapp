package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage1 extends BasePage {

    @FindBy(xpath = "//h1[text()='Not Found']")
    private WebElement captionMsg;

    public UserPage1() {
        PageFactory.initElements(driver, this);
    }

    public String checkCaptionMsg() {
        return captionMsg.getText();
    }
}