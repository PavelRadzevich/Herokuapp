package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.DropdownListPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropdownListTest extends BaseTest {

    @Test
    public void dropDownListTest() {
        final String OPTION_0 = "Please select an option";
        final String OPTION_1 = "Option 1";
        final String OPTION_2 = "Option 2";
        final String ERROR_MSG1 = "The option is invalid";

        DropdownListPage dropDownListPage = new DropdownListPage();

        assertEquals(dropDownListPage.getText(0), OPTION_0, ERROR_MSG1);
        assertTrue(dropDownListPage.checkElement(0), ERROR_MSG1);

        dropDownListPage.setElement(OPTION_1);
        assertEquals(dropDownListPage.getText(1), OPTION_1, ERROR_MSG1);
        assertTrue(dropDownListPage.checkElement(1), ERROR_MSG1);

        dropDownListPage.setElement(OPTION_2);
        assertEquals(dropDownListPage.getText(2), OPTION_2, ERROR_MSG1);
        assertTrue(dropDownListPage.checkElement(2), ERROR_MSG1);
    }
}
