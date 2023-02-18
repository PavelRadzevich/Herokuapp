package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/*
    Add/Remove Elements - добавить 2 элемента, удалить элемент, проверить количество элементов
    http://the-internet.herokuapp.com/add_remove_elements/
 */

public class AddRemoveElementsPage extends BasePage {

    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement btnAdd;

    @FindBy(xpath = " //div[@id='elements']/button[last()]")
    private WebElement btnDell;

    @FindBy(xpath = " //div[@id='elements']/button")
    private List<WebElement> btnDellCount;

    public AddRemoveElementsPage() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        PageFactory.initElements(driver, this);
    }

    public void btnClickAdd(int numberOfClicks) {
        for (int i = 0; i < numberOfClicks; i++) {
            btnAdd.click();
        }
    }

    public void btgClickDell() {
        btnDell.click();
    }

    public int checkBtnDell() {
        List<WebElement> elements = btnDellCount;
        if (elements != null) {
            return elements.size();
        } else {
            return 0;
        }
    }
}