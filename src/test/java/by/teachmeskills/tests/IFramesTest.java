package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.FramesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFramesTest extends BaseTest {
    final String INPUT_MSG = "Some text.";
    final String ERROR_MSG = "The entered text is not centered.";

    @Test
    public void editTextFrame() {
        FramesPage framesPage = new FramesPage();
        Assert.assertTrue(framesPage.getIFramePage().editTextFrame(INPUT_MSG).alignCenter(), ERROR_MSG);
    }
}