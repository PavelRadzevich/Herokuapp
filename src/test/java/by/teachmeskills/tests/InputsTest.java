package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.Inputs;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputsTest extends BaseTest {

    @Test
    public void inputsNumbersPositiveTest() {
        Inputs inputsPage = new Inputs();
        inputsPage.setField("5");
        inputsPage.fieldDown(6);
        Assert.assertEquals(inputsPage.checkField(), "-1", "");
    }

    @Test
    public void inputsNumbersNegativeTest() {
        Inputs inputsPage = new Inputs();
        inputsPage.setField("a");
        inputsPage.fieldUp(1);
        Assert.assertEquals(inputsPage.checkField(), "1", "");
    }
}
