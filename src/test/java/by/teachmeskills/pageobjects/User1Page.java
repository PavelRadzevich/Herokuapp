package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User1Page extends BasePage {

    @FindBy(xpath = "//h1[text()='Not Found']")
    private WebElement captionMsg;

    public User1Page() {
        PageFactory.initElements(driver, this);
    }

    public String checkCaptionMsg() {
        return captionMsg.getText();
    }
}