package by.teachmeskills.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
/*
    File Download (с зорачкай)
      - Изучить https://www.swtestacademy.com/download-file-in-selenium/ ;
      - Скачать файл;
      - Проверить наличие файла на файловой системе.
    http://the-internet.herokuapp.com/download
 */
public class FileDownloadPage extends BasePage {
    @FindBy(xpath = "//div[@class='example']/a")
    private List<WebElement> linksDownload;

    public FileDownloadPage() {
        driver.get("http://the-internet.herokuapp.com/download");
        PageFactory.initElements(driver, this);
    }

    public void getDownloadFileAdnCheck(int downloadNumber) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement el = linksDownload.get(downloadNumber);
        el.click();
        Thread.sleep(500);
        js.executeScript("document.querySelector(\"html > ins\").style.display='none'");
    }
}