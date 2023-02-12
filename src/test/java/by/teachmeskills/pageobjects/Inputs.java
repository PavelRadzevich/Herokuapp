package by.teachmeskills.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
    Inputs - Проверить на возможность ввести различные цифровые и нецифровые значения, используя Keys.ARROW_UP
     И Keys.ARROW_DOWN
     http://the-internet.herokuapp.com/inputs
 */
public class Inputs extends BasePage {

    @FindBy(xpath = "//input[@type='number']")
    private WebElement inputField;

    public Inputs() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        PageFactory.initElements(driver, this);
    }

    public String checkField() {
        return inputField.getAttribute("value");
    }

    public void clearField() {
        inputField.clear();
    }

    public void setField(String value) {
        inputField.sendKeys(value);
    }

    public void fieldUp(int count) {
        for (int i = 0; i < count; i++) {
            inputField.sendKeys(Keys.ARROW_UP);
        }
    }

    public void fieldDown(int count) {
        for (int i = 0; i < count; i++) {
            inputField.sendKeys(Keys.ARROW_DOWN);
        }
    }
}
