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

import java.io.File;

public class FileUploadPage extends BasePage {

    @FindBy(xpath = "//input[@id='file-upload']")
    private WebElement btnChooseFile;

    @FindBy(xpath = "//input[@id='file-submit']")
    private WebElement btnUpload;

    @FindBy(xpath = "//div[@id='uploaded-files']")
    private WebElement fileUploaded;

    public FileUploadPage() {
        driver.get(baseUrl + "/upload");
        PageFactory.initElements(driver, this);
    }

    public boolean checkFileUpload() {
        File file = new File("src/test/resources/test.txt");
        btnChooseFile.sendKeys(file.getAbsolutePath());
        btnUpload.click();
        return waitForElement(15).until(ExpectedConditions.visibilityOf(fileUploaded)).isDisplayed();
    }
}