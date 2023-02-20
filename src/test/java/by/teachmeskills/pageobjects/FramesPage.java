package by.teachmeskills.pageobjects;

import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
    Frames
      - Открыть iFrame;
      - Проверить, что текст внутри параграфа равен “Your content goes here.”.
    http://the-internet.herokuapp.com/frames
 */
public class FramesPage extends BasePage {

    @FindBy(xpath = "//a[@href='/iframe']")
    private WebElement iFrameLink;


    public FramesPage(){
        driver.get("http://the-internet.herokuapp.com/frames");
        PageFactory.initElements(driver,this);
    }

    public IFramePage getIFramePage(){
        iFrameLink.click();
        return new IFramePage();
    }
}
