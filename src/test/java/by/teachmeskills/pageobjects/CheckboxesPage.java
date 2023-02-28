package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/*
    Checkboxes - проверить, что первый чекбокс unchecked, отметить первый чекбокс, проверить что он checked.
    Проверить, что второй чекбокс checked, сделать unhecked, проверить, что он unchecked
    http://the-internet.herokuapp.com/checkboxes
 */
public class CheckboxesPage extends BasePage {

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxList;

    public CheckboxesPage() {
        driver.get(baseUrl + "/checkboxes");
        PageFactory.initElements(driver, this);
    }

    public boolean checkCheckBox(int numberElementChecked) {
        List<WebElement> element = checkboxList;
        return element.get(numberElementChecked).isSelected();
    }

    public void setCheckBox(int numberElementChecked) {
        List<WebElement> element = checkboxList;
        element.get(numberElementChecked).click();
    }

    public void clearCheckBox(int numberElementChecked) {
        List<WebElement> element = checkboxList;
        if (element.get(numberElementChecked).isEnabled()) {
            element.get(numberElementChecked).click();
        }
    }
}
