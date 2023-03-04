package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
    Hovers - Сделать цепочку из действий: наведение на профиль, проверка имени, клик по ссылке, проверка что
    нет 404 ошибки. Повторить для каждого из профилей. Использовать класс Actions
    и https://stackoverflow.com/questions/17293914/how-to-perform-mouseover-function-in-selenium-webdriver-using-java
    http://the-internet.herokuapp.com/hovers
 */
public class HoversPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/img")
    private WebElement user1;

    @FindBy(xpath = "//div[@class='example']/div[2]")
    private WebElement user2;

    @FindBy(xpath = "//div[@class='example']/div[3]")
    private WebElement user3;

    @FindBy(xpath = "//div[@class='example']/div[1]//h5")
    private WebElement userName1;

    @FindBy(xpath = "//div[@class='example']/div[2]//h5")
    private WebElement userName2;

    @FindBy(xpath = "//div[@class='example']/div[3]//h5")
    private WebElement userName3;

    @FindBy(xpath = "//div[@class='example']/div[1]//a")
    private WebElement userLink1;

    @FindBy(xpath = "//div[@class='example']/div[2]//a")
    private WebElement userLink2;

    @FindBy(xpath = "//div[@class='example']/div[3]//a")
    private WebElement userLink3;

    public HoversPage() {
        driver.get(baseUrl + "/hovers");
        PageFactory.initElements(driver, this);
    }

    public String checkName1() {
        Actions action = new Actions(driver);
        WebElement we = user1;
        action.moveToElement(we).build().perform();
        return userName1.getText();
    }

    public String checkName2() {
        Actions action = new Actions(driver);
        WebElement we = user2;
        action.moveToElement(we).build().perform();
        return userName2.getText();
    }

    public String checkName3() {
        Actions action = new Actions(driver);
        WebElement we = user3;
        action.moveToElement(we).build().perform();
        return userName3.getText();
    }

    public User1Page getLinkUser1() {
        Actions action = new Actions(driver);
        action.moveToElement(user1).moveToElement(userLink1).click().build().perform();
        return new User1Page();
    }

    public User2Page getLinkUser2() {
        Actions action = new Actions(driver);
        action.moveToElement(user2).moveToElement(userLink2).click().build().perform();
        return new User2Page();
    }

    public User3Page getLinkUser3() {
        Actions action = new Actions(driver);
        action.moveToElement(user3).moveToElement(userLink3).click().build().perform();
        return new User3Page();
    }
}
