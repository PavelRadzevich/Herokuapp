package by.teachmeskills.pageobjects;

/*
    Dynamic Controls
      - Найти чекбокс;
      - Нажать на кнопку;
      - Дождаться надписи “It’s gone”;
      - Проверить, что чекбокса нет;
      ----
      - Найти инпут;
      - Проверить, что он disabled;
      - Нажать на кнопку;
      - Дождаться надписи “It's enabled!”;
      - Проверить, что инпут enabled.
    http://the-internet.herokuapp.com/dynamic_controls
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlsPage extends BasePage {
    @FindBy(xpath = "//form[@id='checkbox-example']//input")
    private WebElement checkBoxInput;
    @FindBy(xpath = "//form[@id='checkbox-example']//button")
    private WebElement btnRemoveAdd;
    @FindBy(xpath = "//form[@id='checkbox-example']/p[@id='message']")
    private WebElement waitingCheckboxTxt;
    @FindBy(xpath = "//form[@id='input-example']//input")
    private WebElement textBoxInput;
    @FindBy(xpath = "//form[@id='input-example']//button")
    private WebElement btnDisableEnable;
    @FindBy(xpath = "//form[@id='input-example']//p[@id='message']")
    private WebElement waitingInputTxt;

    public DynamicControlsPage() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        PageFactory.initElements(driver, this);
    }

    public boolean checkChkBox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.invisibilityOf(checkBoxInput));
    }

    public boolean checkWaitingChkBoxTxt(String msg) {
        btnRemoveAdd.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(waitingCheckboxTxt));
        return waitingCheckboxTxt.getText().equals(msg);
    }

    public boolean checkInputBox() {
        return textBoxInput.isEnabled();
    }

    public boolean checkWaitingInputBoxTxt(String msg) {
        if (!textBoxInput.isEnabled()) {
            btnDisableEnable.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(waitingInputTxt));
        }
        return waitingInputTxt.getText().equals(msg);
    }
}
