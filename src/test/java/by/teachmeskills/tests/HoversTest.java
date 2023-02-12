package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.Hovers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTest extends BaseTest {
    final String USER1_NAME = "name: user1";
    final String USER2_NAME = "name: user2";
    final String USER3_NAME = "name: user3";
    final String MSG_404 = "Not Found";

    @Test
    public void hoversTestUser1() {
        Hovers hoversPage = new Hovers();
        Assert.assertEquals(hoversPage.checkName1(), USER1_NAME, "ERROR");
        Assert.assertEquals(hoversPage.getLinkUser1().checkCaptionMsg(), MSG_404, "ERROR");
    }

    @Test
    public void hoversTestUser2() {
        Hovers hoversPage = new Hovers();
        Assert.assertEquals(hoversPage.checkName2(), USER2_NAME, "ERROR");
        Assert.assertEquals(hoversPage.getLinkUser2().checkCaptionMsg(), MSG_404, "ERROR");
    }

    @Test
    public void hoversTestUser3() {
        Hovers hoversPage = new Hovers();
        Assert.assertEquals(hoversPage.checkName3(), USER3_NAME, "ERROR");
        Assert.assertEquals(hoversPage.getLinkUser3().checkCaptionMsg(), MSG_404, "ERROR");
    }
}
