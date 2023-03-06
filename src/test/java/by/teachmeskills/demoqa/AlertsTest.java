package by.teachmeskills.demoqa;

import by.teachmeskills.tests.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertsTest extends BaseTest {
    final String ALERT = "You clicked a button";
    final String ALERT_5SEC = "This alert appeared after 5 seconds";
    final String ALERT_CONFIRM = "Do you confirm action?";
    final String ALERT_CANCEL = "You selected Cancel";
    final String ALERT_PROMPT = "Please enter your name";
    final String ALERT_PROMPT_NAME = "NAME";

    @Test
    public void testAlert() {
        AlertsWindowsPage alertPage = new MainPage()
                .getAlertPage()
                .isOpened()
                .selectMenuBtnAlert()
                .isSelectAlert();

        assertThat(alertPage.clickAlertBtn())
                .isEqualTo(ALERT);
    }

    @Test
    public void testAlert5Sec() {
        AlertsWindowsPage alertPage = new MainPage()
                .getAlertPage()
                .isOpened()
                .selectMenuBtnAlert()
                .isSelectAlert();

        assertThat(alertPage.clickTimeAlertBtn())
                .isEqualTo(ALERT_5SEC);
    }

    @Test
    public void testConfirmAlert() {
        AlertsWindowsPage alertPage = new MainPage()
                .getAlertPage()
                .isOpened()
                .selectMenuBtnAlert()
                .isSelectAlert();

        assertThat(alertPage.clickConfirmBtn())
                .isEqualTo(ALERT_CONFIRM);
        assertThat(alertPage.getConfirmAlertTxt())
                .isEqualTo(ALERT_CANCEL);
    }

    @Test
    public void testPromptAlert() {
        AlertsWindowsPage alertPage = new MainPage()
                .getAlertPage()
                .isOpened()
                .selectMenuBtnAlert()
                .isSelectAlert();

        assertThat(alertPage.clickPromptAlertBtn(ALERT_PROMPT_NAME)).
                isEqualTo(ALERT_PROMPT);
        assertThat(alertPage.getPromptAlertTxt())
                .contains(ALERT_PROMPT_NAME);
    }
}
