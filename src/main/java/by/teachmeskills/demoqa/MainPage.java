package by.teachmeskills.demoqa;

import by.teachmeskills.pageobjects.BasePage;
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
public class MainPage extends BasePage {

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    WebElement alertsFrameWindowPage;

    public MainPage() {
        driver.get("https://demoqa.com/");
        PageFactory.initElements(driver, this);
    }

    public alertsWindowsPage getAlertPage() {
        alertsFrameWindowPage.click();
        return new alertsWindowsPage();
    }

}