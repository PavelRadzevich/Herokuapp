package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
    Typos - Проверить соответствие параграфа орфографии.
    http://the-internet.herokuapp.com/typos
 */
public class TyposPage extends BasePage {

    @FindBy(xpath = "//div[@class='example']/p[last()]")
    private WebElement paragraphCheck;

    public TyposPage() {
        driver.get(baseUrl + "/typos");
        PageFactory.initElements(driver, this);
    }

    public String getParagraphTxt() {
        return paragraphCheck.getText();
    }
}