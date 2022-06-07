import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

abstract public class BaseTest {

    Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public void setup() {
        Configuration.driverManagerEnabled = true;
        Configuration.baseUrl = "https://keller:sports17@stage.keller-sports.com";
        Configuration.browserSize = "1650x950";
        Configuration.timeout = 7000;

    }

    @BeforeMethod
    @Parameters("browser")

    public void setUp(@Optional("firefox") String browser) throws Exception{
            setup();

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
