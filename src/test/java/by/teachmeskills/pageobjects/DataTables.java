package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
    Sortable Data Tables - Проверить содержимое нескольких (3-5) ячеек таблицы. Использовать
    xpath типа //table//tr[1]//td[1] - получение первой ячейки из первого ряда первой таблицы
    и так далее.
    http://the-internet.herokuapp.com/tables
 */
public class DataTables extends BasePage {

    @FindBy(xpath = "//table[@id='table1']//tbody//tr[1]/td[1]")
    private WebElement lastNameUser1;
    @FindBy(xpath = "//table[@id='table1']//tbody//tr[1]/td[2]")
    private WebElement firstNameUser1;
    @FindBy(xpath = "//table[@id='table1']//tbody//tr[1]/td[3]")
    private WebElement emailUser1;
    @FindBy(xpath = "//table[@id='table2']//tbody//tr[1]/td[1]")
    private WebElement lastNameUser2;
    @FindBy(xpath = "//table[@id='table2']//tbody//tr[1]/td[2]")
    private WebElement firstNameUser2;
    @FindBy(xpath = "//table[@id='table2']//tbody//tr[1]/td[3]")
    private WebElement emailUser2;

    public DataTables() {
        driver.get("http://the-internet.herokuapp.com/tables");
        PageFactory.initElements(driver, this);
    }

    public boolean checkUserTable1(String lastName, String firstName, String email) {
        return lastNameUser1.getText().equals(lastName)
                && firstNameUser1.getText().equals(firstName)
                && emailUser1.getText().equals(email);
    }

    public boolean checkUserTable2(String lastName, String firstName, String email) {
        return lastNameUser2.getText().equals(lastName)
                && firstNameUser2.getText().equals(firstName)
                && emailUser2.getText().equals(email);
    }
}
