package by.teachmeskills.demoqa;

import by.teachmeskills.pageobjects.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*  Автоматизировать тесты для: ToolsQA (demoqa.com). Каждая страница - отдельный тест.
    1.
    Открыть страницу Alerts (https://demoqa.com/alerts )
    Кликнуть по кнопке напротив текста “Click Button to see alert”
    Проверить текст алерта “You clicked a button”
    Принять Alert (кнопка ОК)
    2.
    Кликнуть по кнопке напротив текста  “On button click, alert will appear after 5 seconds”. Использовать вейтер
    чтобы дождаться алерт
    Проверить текст “This alert appeared after 5 seconds”
    Принять Alert (кнопка ОК)
    3.
    Кликнуть по кнопке напротив текста “On button click, confirm box will appear”
    Проверить текст “Do you confirm action?”
    Отклонить алерт (кнопка Отмена)
    Проверить текст “You selected Cancel”
    4.
    Кликнуть на кнопку напротив текста “On button click, prompt box will appear”
    Проверить наличие текста “Please enter your name”
    Ввести свое имя в поле
    Принять Alert (кнопка ОК)
    Проверить введенный текст “You entered ххх”
 */
public class AlertsWindowsPage extends BasePage {
    String msg = "";
    @FindBy(xpath = "//div[@class='main-header'][text()='Alerts, Frame & Windows']")
    private WebElement mainTitle;

    @FindBy(xpath = "//span[@class='text'][text()='Alerts']")
    private WebElement alertMenuBtn;

    @FindBy(xpath = "//div[@class='main-header'][text()='Alerts']")
    private WebElement mainTitleAlerts;

    @FindBy(xpath = "//button[@id='alertButton']")
    private WebElement alertBtn;

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    private WebElement timeAlertBtn;

    @FindBy(xpath = "//button[@id='confirmButton']")
    private WebElement confirmAlertBtn;

    @FindBy(xpath = "//span[@id='confirmResult']")
    private WebElement confirmAlertTxt;

    @FindBy(xpath = "//button[@id='promtButton']")
    private WebElement promptAlertBtn;

    @FindBy(xpath = "//span[@id='promptResult']")
    private WebElement promptAlertTxt;

    public AlertsWindowsPage() {
        PageFactory.initElements(driver, this);
    }

    public AlertsWindowsPage isOpened() {
        waitVisibility(mainTitle);
        return this;
    }

    public AlertsWindowsPage selectMenuBtnAlert() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", alertMenuBtn);
        return this;
    }

    public AlertsWindowsPage isSelectAlert() {
        waitVisibility(mainTitleAlerts);
        return this;
    }

    public String clickAlertBtn() {
        try {
            alertBtn.click();
            Alert alert = waitAlertIsPresent();
            msg = alert.getText();
            alert.accept();
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }
        return msg;
    }

    public String clickTimeAlertBtn() {
        try {
            timeAlertBtn.click();
            Alert alert = waitAlertIsPresent();
            msg = alert.getText();
            alert.accept();
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }
        return msg;
    }

    public String clickConfirmBtn() {
        try {
            confirmAlertBtn.click();
            Alert alert = waitAlertIsPresent();
            msg = alert.getText();
            alert.dismiss();
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }
        return msg;
    }

    public String getConfirmAlertTxt() {
        return confirmAlertTxt.getText();
    }

    public String clickPromptAlertBtn(String name) {
        try {
            promptAlertBtn.click();
            Alert alert = waitAlertIsPresent();
            msg = alert.getText();
            alert.sendKeys(name);
            alert.accept();
        } catch (Exception e) {
            System.out.println("unexpected alert not present");
        }
        return msg;
    }

    public String getPromptAlertTxt() {
        return promptAlertTxt.getText();
    }
}
