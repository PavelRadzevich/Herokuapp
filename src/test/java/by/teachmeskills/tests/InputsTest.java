package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.InputsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsTest extends BaseTest {
    final String ERROR_MSG1 = "The resulting result does not match the expected value in the Input element.";
    @Test
    public void inputsNumbersPositiveTest() {
        InputsPage inputsPage = new InputsPage();
        inputsPage.setField("5");
        inputsPage.fieldDown(6);
        Assert.assertEquals(inputsPage.checkField(), "-1", ERROR_MSG1);
    }

    @Test
    public void inputsNumbersNegativeTest() {
        InputsPage inputsPage = new InputsPage();
        inputsPage.setField("a");
        inputsPage.fieldUp(1);
        Assert.assertEquals(inputsPage.checkField(), "1", ERROR_MSG1);
    }
}