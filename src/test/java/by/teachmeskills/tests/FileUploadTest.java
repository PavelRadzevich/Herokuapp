package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {
    final String ERROR_MSG = "File not uploaded";

    @Test
    public void chkUploadFile() {
        FileUploadPage uploadPage = new FileUploadPage();
        Assert.assertTrue(uploadPage.checkFileUpload(), ERROR_MSG);
    }
}