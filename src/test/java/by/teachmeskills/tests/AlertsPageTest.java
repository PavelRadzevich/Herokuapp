package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsPageTest extends BaseTest {

    final String MSG_ERROR1 = "Expected text after clicking on \"Click for JS Alert\" button";
    final String MSG_ERROR2 = "Expected text after clicking on \"Click for JS Confirm\" button";
    final String MSG_ERROR3 = "Expected text after clicking on \"Click for JS Prompt\" button";
    final String RESULT_ALERT = "You successfully clicked an alert";
    final String RESULT_CONFIRM = "You clicked: Cancel";
    final String RESULT_PROMPT = "You entered: ";
    final String INPUT_TXT = "TeSt";

    @Test
    public void checkResultAlert() {
        AlertsPage alertsPage = new AlertsPage();
        Assert.assertEquals(alertsPage.getBtnClickAlert(), RESULT_ALERT, MSG_ERROR1);
    }

    @Test
    public void checkResultConfirm() {
        AlertsPage alertsPage = new AlertsPage();
        Assert.assertEquals(alertsPage.getBtnClickConfirm(), RESULT_CONFIRM, MSG_ERROR2);
    }

    @Test
    public void checkResultPrompt() {
        AlertsPage alertsPage = new AlertsPage();
        Assert.assertEquals(alertsPage.getBtnClickPrompt(INPUT_TXT), RESULT_PROMPT + INPUT_TXT, MSG_ERROR3);
    }
}