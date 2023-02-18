package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.DataTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataTablesTest extends BaseTest {
    final String USER_LAST_NAME = "Smith";
    final String USER_FIRST_NAME = "John";
    final String USER_EMAIL = "jsmith@gmail.com";
    final String ERROR_MSG1 = "The contents of the cells do not match the specified text.";

    @Test
    public void dataBaseTestTable1() {
        DataTablesPage dataTablesPage = new DataTablesPage();
        Assert.assertTrue(dataTablesPage.checkUserTable1(USER_LAST_NAME, USER_FIRST_NAME, USER_EMAIL), ERROR_MSG1);
    }

    @Test
    public void dataBaseTestTable2() {
        DataTablesPage dataTablesPage = new DataTablesPage();
        Assert.assertTrue(dataTablesPage.checkUserTable2(USER_LAST_NAME, USER_FIRST_NAME, USER_EMAIL), ERROR_MSG1);
    }
}
