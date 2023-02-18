package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends BaseTest {
    final String ERROR_MSG1 = "The option is invalid";

    @Test
    public void heckBoxesTest() {
        CheckboxesPage checkBoxesPage = new CheckboxesPage();

        Assert.assertFalse(checkBoxesPage.checkCheckBox(0), ERROR_MSG1);
        checkBoxesPage.setCheckBox(0);
        Assert.assertTrue(checkBoxesPage.checkCheckBox(0), ERROR_MSG1);

        Assert.assertTrue(checkBoxesPage.checkCheckBox(1), ERROR_MSG1);
        checkBoxesPage.clearCheckBox(1);
        Assert.assertFalse(checkBoxesPage.checkCheckBox(1), ERROR_MSG1);
    }
}
