package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.FileDownloadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloadTest extends BaseTest {
    final String ERROR_MSG = "The downloaded file was not found.";
    @Test
    public void checkDownloadFile() throws InterruptedException {
        FileDownloadPage downloadPage = new FileDownloadPage();
        Assert.assertTrue(downloadPage.getDownloadFileAdnCheck(0), ERROR_MSG);
    }
}
