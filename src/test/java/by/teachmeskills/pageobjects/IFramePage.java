package by.teachmeskills.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IFramePage extends BasePage {

    @FindBy(xpath = "//div[@role='application']")
    private WebElement menuForm;

    @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
    private WebElement iframeBox;

    @FindBy(xpath = "//body[@id='tinymce']/p")
    private WebElement textBox;

    @FindBy(xpath = "//p[@style='text-align: center;']")
    private WebElement textAlign;
    @FindBy(xpath = "//button[@title='Align center']")
    private WebElement btnAlignCenter;

    public IFramePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean checkTextInFrame(String msg) {
        waitForElement(15).until(ExpectedConditions.visibilityOf(menuForm));
        driver.switchTo().frame(iframeBox);
        return textBox.getText().equals(msg);
    }

    public IFramePage editTextFrame(String msg) {
        waitForElement(15).until(ExpectedConditions.visibilityOf(menuForm));
        driver.switchTo().frame(iframeBox);
        textBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        textBox.sendKeys(msg);
        return this;
    }

    public boolean alignCenter() {
        driver.switchTo().defaultContent();
        btnAlignCenter.click();
        driver.switchTo().frame(iframeBox);
        return waitForElement(15).until(ExpectedConditions.visibilityOf(textAlign)).isDisplayed();
    }
}