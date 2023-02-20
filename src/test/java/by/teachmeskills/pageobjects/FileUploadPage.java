package by.teachmeskills.pageobjects;

/*
    File Upload
      - Загрузить файл;
      - Проверить, что имя файла на странице совпадает с именем загруженного файла.
    http://the-internet.herokuapp.com/upload
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class FileUploadPage extends BasePage {

    @FindBy(xpath = "//input[@id='file-upload']")
    private WebElement btnChooseFile;

    @FindBy(xpath = "//input[@id='file-submit']")
    private WebElement btnUpload;

    @FindBy(xpath = "//div[@id='uploaded-files']")
    private WebElement fileUploaded;

    public FileUploadPage() {
        driver.get("http://the-internet.herokuapp.com/upload");
        PageFactory.initElements(driver, this);
    }

    public boolean checkFileUpload() {
        File file = new File("src/test/resources/test.txt");
        btnChooseFile.sendKeys(file.getAbsolutePath());
        btnUpload.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOf(fileUploaded)).isDisplayed();
    }
}