import ShopPages.*;
import com.codeborne.selenide.Condition;
import helpers.TestValues;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class BuyProductTest extends BaseTest{

    WebDriver driver;
    @Test(description = "Тест на покупку підписки Premium")
    public void addToBasketTest() {
        PDPage pdPage = new PDPage();
        open("/p/patagonia-arbor-roll-top-backpack-OEQPG03X000.html");
        pdPage.acceptCookie();
        pdPage.addToBasket();
        pdPage.checkMiniBasket().shouldHave(Condition.text("1"));
    }

    //TODO
    @Test(description = "Тест на успішну покупку товара авторизованим користувачем")
    public void purchaseProductTest() throws InterruptedException {
        open("/");
        LoginPage authPage = new LoginPage();
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        PDPage pdPage = new PDPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        authPage.authorizeUser(TestValues.USER_EMAIL, TestValues.USER_PASS);
        mainPage.clickOnSearchIcon();
        searchPage.selectRecommendedProduct();
        pdPage.addProduct();
        pdPage.addToBasket();
        open("https://keller:sports17@checkout-stage.keller-sports.com/");
        checkoutPage.goToPay();
        checkoutPage.setPersonalData();
        checkoutPage.setPaymentNumber();
//        checkoutPage.setPaymentName();
//        checkoutPage.setPaymentData();
//        checkoutPage.pay();
    }
}