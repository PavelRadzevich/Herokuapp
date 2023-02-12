package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.NotificationMessage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessageTest extends BaseTest {

    final String ACTION_MSG = "Action successful\n" + "×";

    @Test
    public void notificationMessageTest() {
        NotificationMessage notificationMsgPage = new NotificationMessage();
        Assert.assertTrue(notificationMsgPage.checkActionMsg(ACTION_MSG), "Not found");
    }
}
