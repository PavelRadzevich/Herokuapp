package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.DropdownList;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropdownListTest extends BaseTest {

    @Test
    public void dropDownListTest() {
        final String OPTION_0 = "Please select an option";
        final String OPTION_1 = "Option 1";
        final String OPTION_2 = "Option 2";
        final String ERR_MSG1 = "The option is invalid";

        DropdownList dropDownListPage = new DropdownList();

        assertEquals(dropDownListPage.getText(0), OPTION_0, ERR_MSG1);
        assertTrue(dropDownListPage.checkElement(0), ERR_MSG1);

        dropDownListPage.setElement(OPTION_1);
        assertEquals(dropDownListPage.getText(1), OPTION_1, ERR_MSG1);
        assertTrue(dropDownListPage.checkElement(1), ERR_MSG1);

        dropDownListPage.setElement(OPTION_2);
        assertEquals(dropDownListPage.getText(2), OPTION_2, ERR_MSG1);
        assertTrue(dropDownListPage.checkElement(2), ERR_MSG1);
    }
}
