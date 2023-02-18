package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.AddRemoveElementsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends BaseTest {
    final String ERROR_MSG1 = "Error, one ADD element was expected on the page";

    @Test
    public void addRemoveElementsTest() {
        AddRemoveElementsPage addRemovePage = new AddRemoveElementsPage();
        addRemovePage.btnClickAdd(2);
        addRemovePage.btgClickDell();
        Assert.assertEquals(addRemovePage.checkBtnDell(), 1, ERROR_MSG1);
    }
}