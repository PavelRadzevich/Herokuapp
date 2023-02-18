package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.DynamicControlsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {
    final String CHECK_BOX_TXT = "It's gone!";
    final String INPUT_TXT = "It's enabled!";
    final String ERROR_MSG1 = "The required text did not appear. --> ";
    final String ERROR_MSG2 = "The checkbox element is present on the page.";
    final String ERROR_MSG3 = "The inputbox element is active.";
    final String ERROR_MSG4 = "The inputbox element is missing from the page.";

    @Test
    public void checkBoxTest() {
        DynamicControlsPage controlsPage = new DynamicControlsPage();
        Assert.assertTrue(controlsPage.checkWaitingChkBoxTxt(CHECK_BOX_TXT), ERROR_MSG1 + CHECK_BOX_TXT);
        Assert.assertTrue(controlsPage.checkChkBox(), ERROR_MSG2);
    }

    @Test
    public void inputBoxTest() {
        DynamicControlsPage controlsPage = new DynamicControlsPage();
        Assert.assertFalse(controlsPage.checkInputBox(), ERROR_MSG3);
        Assert.assertTrue(controlsPage.checkWaitingInputBoxTxt(INPUT_TXT), ERROR_MSG1 + INPUT_TXT);
        Assert.assertTrue(controlsPage.checkInputBox(), ERROR_MSG4);
    }
}