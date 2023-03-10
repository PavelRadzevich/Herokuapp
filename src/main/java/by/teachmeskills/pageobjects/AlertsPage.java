package by.teachmeskills.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
    Alerts
      - Кликнуть по кнопке Click for JS Alert;
      - Принять Alert;
      - Проверить статус - принято;
      - Кликнуть по кнопке Click for JS Confirm;
      - Отказать в Alert-е;
      - Проверить что статус - Отказано;
      - Кликнуть по кнопке Click for JS Prompt;
      - Ввести текст;
      - Принять Alert;
      - Проверить что статус содержит введенный текст.
    http://the-internet.herokuapp.com/javascript_alerts
 */
public class AlertsPage extends BasePage {
    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    private WebElement btnAlert;

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    private WebElement btnConfirm;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    private WebElement btnPrompt;

    @FindBy(xpath = "//p[@id='result']")
    private WebElement txtResult;

    public AlertsPage() {
        driver.get(baseUrl + "/javascript_alerts");
        PageFactory.initElements(driver, this);
    }

    public String getBtnClickAlert() {
        btnAlert.click();
        Alert alert = waitForElement(15).until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return txtResult.getText();
    }

    public String getBtnClickConfirm() {
        btnConfirm.click();
        Alert alert = waitForElement(15).until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        return txtResult.getText();
    }

    public String getBtnClickPrompt(String msg) {
        btnPrompt.click();
        Alert alert = waitForElement(15).until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(msg);
        alert.accept();
        return txtResult.getText();
    }
}