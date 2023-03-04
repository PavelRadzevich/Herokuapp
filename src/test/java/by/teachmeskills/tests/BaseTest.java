package by.teachmeskills.tests;

import by.teachmeskills.pageobjects.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;

abstract public class BaseTest {
    protected WebDriver driver;
    protected static final int TIMOUT = 15;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("safebrowsing.enabled", "false");
        chromePrefs.put("download.default_directory", "user.home" + "/Downloads");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMOUT));
        BasePage.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
