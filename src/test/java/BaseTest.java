import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

abstract public class BaseTest {

    public void setUp() {
        Configuration.driverManagerEnabled = true;
        Configuration.baseUrl = "https://keller:sports17@stage.keller-sports.com";
        Configuration.browserSize = "1440x900";
        Configuration.headless = false;
    }

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception{

        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            Configuration.browser = "firefox";
        }
        else if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            Configuration.browser = "chrome";
        }
        else{
            throw new Exception("Browser is not correct");
        }
    }

    @BeforeMethod
    public void init() {
        setUp();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
