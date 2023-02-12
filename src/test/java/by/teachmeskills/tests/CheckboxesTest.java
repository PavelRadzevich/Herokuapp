package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.Checkboxes;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest extends BaseTest {
    final String ERR_MSG1 = "The option is invalid";

    @Test
    public void heckBoxesTest() {
        Checkboxes checkBoxesPage = new Checkboxes();

        Assert.assertFalse(checkBoxesPage.checkCheckBox(0), ERR_MSG1);
        checkBoxesPage.setCheckBox(0);
        Assert.assertTrue(checkBoxesPage.checkCheckBox(0), ERR_MSG1);

        Assert.assertTrue(checkBoxesPage.checkCheckBox(1), ERR_MSG1);
        checkBoxesPage.clearCheckBox(1);
        Assert.assertFalse(checkBoxesPage.checkCheckBox(1), ERR_MSG1);
    }
}
