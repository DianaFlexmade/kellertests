import ShopPages.LoginPage;
import ShopPages.MainPage;
import ShopPages.PDPage;
import ShopPages.SearchPage;
import com.codeborne.selenide.Condition;
import helpers.TestValues;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class BuyProductTest extends BaseTest{

    WebDriver driver;
    @Test(description = "Тест на додання товара до кошика")
    public void addToBasketTest() {
        PDPage pdPage = new PDPage();
        open("/p/patagonia-arbor-roll-top-backpack-OEQPG03X000.html");
        pdPage.acceptCookie();
        pdPage.addToBasket();
        pdPage.checkMiniBasket().shouldHave(Condition.text("1"));
    }

    //TODO
//    @Test(description = "Тест на успішну покупку товара")
//    public void purchaseProductTest() throws InterruptedException {
//        open("/");
//        LoginPage authPage = new LoginPage();
//        MainPage mainPage = new MainPage();
//        SearchPage searchPage = new SearchPage();
//        PDPage pdPage = new PDPage();
//        authPage.authorizeUser(TestValues.USER_EMAIL, TestValues.USER_PASS);
//        mainPage.clickOnSearchIcon();
//        searchPage.selectRecommendedProduct();
//        pdPage.addProduct();
//        pdPage.addToBasket();
//        pdPage.goToBasket();
//
//
//    }
}
