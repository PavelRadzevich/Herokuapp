package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.FramesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {
    final String TEXT_IFRAME = "Your content goes here.";
    final String ERROR_MSG = "The text in the IFrame element does not match.";

    @Test
    public void checkTextIFrame() {
        FramesPage framePage = new FramesPage();
        Assert.assertTrue(framePage.getIFramePage().checkTextInFrame(TEXT_IFRAME), ERROR_MSG);
    }
}