package by.teachmeskills.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
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

    public boolean getDownloadFileAdnCheck(int downloadNumber) throws InterruptedException {
        WebElement el = linksDownload.get(downloadNumber);
        el.click();
        String fileName = el.getText();
        Thread.sleep(500);
        File folder = new File("D:\\Downloads");
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                if (listOfFile.getName().equals(fileName)) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        assert f != null;
    return found;
    }
}