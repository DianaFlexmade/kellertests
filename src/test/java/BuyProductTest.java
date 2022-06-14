import ShopPages.CheckoutPage;
import ShopPages.LoginPage;
import ShopPages.PDPage;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import helpers.ConfigReader;
import helpers.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BuyProductTest extends BaseTest {
    Faker faker = new Faker();
    PDPage pdPage = new PDPage();
    LoginPage authPage = new LoginPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Description("Тест на покупку підписки Premium")
    @Test(description = "Тест на покупку підписки Premium", retryAnalyzer = RetryAnalyzer.class)
    void buyPremiumTest() {
        openPremiumPage();
        checkoutPage.acceptCookie()
                .isCountryLayerVisible();
        pdPage.buyPremium()
                .getBasketCount().shouldHave(Condition.text("1"));
        openCheckoutPage();
        checkoutPage.getAddedPremium()
                .goToCheckout()
                .checkoutRegister("test", "test", faker.internet().emailAddress(), "19111994qQ!")
                .setPersonalDataForPremium()
                .setPaymentData()
                .pay();
        Assert.assertEquals(checkoutPage.getThankYouText().text(), "DONE!");
    }

    @Description("Тест на успішну покупку товара авторизованим користувачем")
    @Test(description = "Тест на успішну покупку товара авторизованим користувачем", retryAnalyzer = RetryAnalyzer.class)
    void purchaseProductTest() throws IOException {
        openProductPage();
        authPage.acceptCookie()
                .isCountryLayerVisible();
        pdPage.addProductToBasket()
                .getBasketCount().shouldHave(Condition.text("1"));
        openCheckoutPage();
        checkoutPage.getAddedProduct()
                .goToCheckout()
                .checkoutLogin(ConfigReader.getUsername(), ConfigReader.getPassword())
                .getAddedProduct()
                .goToCheckout()
                .goToPayment()
                .setPaymentTypeToPayone()
                .setPaymentData()
                .pay();
        Assert.assertEquals(checkoutPage.getThankYouText().text(), "DONE!");
    }
}