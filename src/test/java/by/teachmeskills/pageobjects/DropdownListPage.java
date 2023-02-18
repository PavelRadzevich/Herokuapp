package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/*
    Dropdown - Взять все элементы дроп-дауна и проверить их наличие. Выбрать первый, проверить, что он выбран,
    выбрать второй, проверить, что он выбран.
    http://the-internet.herokuapp.com/dropdown
 */
public class DropdownListPage extends BasePage {
    @FindBy(id = "dropdown")
    private WebElement dropDownList;

    public DropdownListPage() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        PageFactory.initElements(driver, this);
    }

    public String getText(int indexList) {
        Select dropDown = new Select(dropDownList);
        List<WebElement> options = dropDown.getOptions();
        return options.get(indexList).getText();
    }

    public boolean checkElement(int indexList) {
        Select dropDown = new Select(dropDownList);
        List<WebElement> options = dropDown.getOptions();
        return options.get(indexList).isSelected();
    }

    /**
     * @param strOptions Select the Options by visible text.
     */
    public void setElement(String strOptions) {
        Select dropDown = new Select(dropDownList);
        dropDown.selectByVisibleText(strOptions);
    }
}