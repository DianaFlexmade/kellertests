import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Urls;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.open;

abstract public class BaseTest {
    protected final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("firefox") String browser) throws Exception{
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1650x950";
        Configuration.timeout = 10000;

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
    public void openMainPage() {
        open(Urls.KELLER_MAIN_PAGE.getUrl());
    }
    public void openCheckoutPage() {
        open(Urls.CHECKOUT_PAGE.getUrl());
    }
    public void openProductPage() {
        open(Urls.PRODUCT_PAGE.getUrl());
    }
    public void openPremiumPage() {
        open(Urls.PREMIUM_PAGE.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
