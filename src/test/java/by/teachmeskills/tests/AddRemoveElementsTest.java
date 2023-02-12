package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.AddRemoveElements;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void addRemoveElementsTest() {
        AddRemoveElements addRemovePage = new AddRemoveElements();
        addRemovePage.btnClickAdd(2);
        addRemovePage.btgClickDell();
        Assert.assertEquals(addRemovePage.checkBtnDell(), 1, "ERROR");
    }
}







































