package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {
    final String MSG_ERROR = "Error. Expected text after right click does not match.";
    final String RESULT_ALERT_TXT = "You selected a context menu";

    @Test
    public void checkContextMenuAlerts() {
        ContextMenuPage contextMenuPage = new ContextMenuPage();
        Assert.assertEquals(contextMenuPage.checkName(), RESULT_ALERT_TXT, MSG_ERROR);
    }
}