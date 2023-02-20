package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.JavaScriptExecutorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends BaseTest {
    final String ERROR_MSG1 = "Element not found when moving 50 pix down.";
    final String ERROR_MSG2 = "Element Multiple Windows was not found when moving down.";
    final String ERROR_MSG3 = "The element was not found when moving down the page.";
    final String ERROR_MSG4 = "The element was not found when moving up the page.";

    @Test
    public void javaPage() {
        JavaScriptExecutorPage herokuPage = new JavaScriptExecutorPage();
        Assert.assertTrue(herokuPage.setDown50pix(), ERROR_MSG1);
        Assert.assertTrue(herokuPage.setDownByText(), ERROR_MSG2);
        Assert.assertTrue(herokuPage.setDownPage(), ERROR_MSG3);
        Assert.assertTrue(herokuPage.setUpPage(), ERROR_MSG4);
    }
}
