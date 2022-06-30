import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

abstract public class BaseTest {

    @BeforeClass
    public void setUp() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.baseUrl = "https://keller:sports17@stage.keller-sports.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000;
        Configuration.browser = "chrome";
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setCapability("enableVNC", true);
        browser.setCapability("enableVideo", true);
        Configuration.browserCapabilities = browser;
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}