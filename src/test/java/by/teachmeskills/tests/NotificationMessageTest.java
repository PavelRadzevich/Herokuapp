package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.NotificationMessagePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessageTest extends BaseTest {

    final String ACTION_MSG = "Action successful\n" + "×";
    final String ERROR_MSG1 = "The expected notification window was not displayed.";

    @Test
    public void notificationMessageTest() {
        NotificationMessagePage notificationMsgPage = new NotificationMessagePage();
        Assert.assertTrue(notificationMsgPage.checkActionMsg(ACTION_MSG), ERROR_MSG1);
    }
}