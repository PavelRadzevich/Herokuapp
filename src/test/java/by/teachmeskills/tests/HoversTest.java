package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.HoversPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTest extends BaseTest {
    final String USER1_NAME = "name: user1";
    final String USER2_NAME = "name: user2";
    final String USER3_NAME = "name: user3";
    final String MSG_404 = "Not Found";
    final String ERROR_MSG1 = "The username doesn't match.";
    final String ERROR_MSG2 = "The link to the user's page does not work.";

    @Test
    public void hoversTestUser1() {
        HoversPage hoversPage = new HoversPage();
        Assert.assertEquals(hoversPage.checkName1(), USER1_NAME, ERROR_MSG1);
        Assert.assertEquals(hoversPage.getLinkUser1().checkCaptionMsg(), MSG_404, ERROR_MSG2);
    }

    @Test
    public void hoversTestUser2() {
        HoversPage hoversPage = new HoversPage();
        Assert.assertEquals(hoversPage.checkName2(), USER2_NAME, ERROR_MSG1);
        Assert.assertEquals(hoversPage.getLinkUser2().checkCaptionMsg(), MSG_404, ERROR_MSG2);
    }

    @Test
    public void hoversTestUser3() {
        HoversPage hoversPage = new HoversPage();
        Assert.assertEquals(hoversPage.checkName3(), USER3_NAME, ERROR_MSG1);
        Assert.assertEquals(hoversPage.getLinkUser3().checkCaptionMsg(), MSG_404, ERROR_MSG2);
    }
}
