import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

abstract public class BaseTest {

    Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public void setUp() {
        Configuration.driverManagerEnabled = true;
        Configuration.baseUrl = "https://keller:sports17@stage.keller-sports.com";
        Configuration.browserSize = "1600x900";
        Configuration.headless = true;
        Configuration.timeout = 7000;

    }

    @BeforeMethod
    @Parameters("browser")

    public void setup(@Optional("chrome") String browser) throws Exception{
            setUp();

        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            Configuration.browser = "firefox";
            logger.info("Firefox launched");

        }
        else if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            Configuration.browser ="chrome";
            logger.info("Chrome launched");
        }
        else{
            throw new Exception("Browser is not correct");
        }
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
