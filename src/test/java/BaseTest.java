import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;


abstract public class BaseTest {
    protected final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "helpers.SelenoidWebDriverProvider";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 7000;
        Configuration.baseUrl = "https://keller:sports17@stage.keller-sports.com";
        logger.info("Selenoid is up");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}