package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.DataTables;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataTablesTest extends BaseTest {
    final String USER_LAST_NAME = "Smith";
    final String USER_FIRST_NAME = "John";
    final String USER_EMAIL = "jsmith@gmail.com";

    @Test
    public void dataBaseTestTable1() {
        DataTables dataTablesPage = new DataTables();
        Assert.assertTrue(dataTablesPage.checkUserTable1(USER_LAST_NAME, USER_FIRST_NAME, USER_EMAIL), "ERROR");
    }

    @Test
    public void dataBaseTestTable2() {
        DataTables dataTablesPage = new DataTables();
        Assert.assertTrue(dataTablesPage.checkUserTable2(USER_LAST_NAME, USER_FIRST_NAME, USER_EMAIL), "ERROR");
    }
}
