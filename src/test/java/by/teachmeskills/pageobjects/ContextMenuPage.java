package by.teachmeskills.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
    Context Menu
      - Правый клик по элементу;
      - Валидация текста на алерте "You selected a context menu";
      - Закрытие алерта.
    http://the-internet.herokuapp.com/context_menu
 */
public class ContextMenuPage extends BasePage {
    @FindBy(xpath = "//div[@id='hot-spot']")
    private WebElement areaBox;

    public ContextMenuPage() {
        driver.get(baseUrl + "/context_menu");
        PageFactory.initElements(driver, this);
    }

    public String checkName() {
        Actions action = new Actions(driver);
        action.contextClick(areaBox).perform();
        return getBtnClickAlert();
    }

    public String getBtnClickAlert() {
        Alert alert = waitForElement(15).until(ExpectedConditions.alertIsPresent());
        String msg = alert.getText();
        alert.accept();
        return msg;
    }
}