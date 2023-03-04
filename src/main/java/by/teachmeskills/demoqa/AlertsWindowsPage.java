package by.teachmeskills.demoqa;

import by.teachmeskills.pageobjects.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    @FindBy(xpath = "//div[@class='main-header'][text()='Alerts, Frame & Windows']")
    WebElement mainTitle;

    @FindBy(xpath = "//span[@class='text'][text()='Alerts']")
    WebElement alertMenuBtn;

    @FindBy(xpath = "//div[@class='main-header'][text()='Alerts']")
    WebElement mainTitleAlerts;

    @FindBy(xpath = "//button[@id='alertButton']")
    WebElement alertBtn;

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    WebElement timeAlertBtn;

    @FindBy(xpath = "//button[@id='confirmButton']")
    WebElement confirmBtn;

    @FindBy(xpath = "//button[@id='promtButton']")
    WebElement promptBtn;

    public AlertsWindowsPage() {
        PageFactory.initElements(driver, this);
    }

    public AlertsWindowsPage isOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(mainTitle));
        return this;
    }

    public AlertsWindowsPage isSelectAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(mainTitleAlerts));
        return this;
    }
}
