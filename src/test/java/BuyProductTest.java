import ShopPages.CheckoutPage;
import ShopPages.LoginPage;
import ShopPages.PDPage;
import com.github.javafaker.Faker;
import helpers.RetryAnalyzer;
import helpers.TestValues;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyProductTest extends BaseTest{
    Faker faker = new Faker();

    @Description("Тест на покупку підписки Premium")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    void buyPremiumTest() throws InterruptedException {
        PDPage pdPage = new PDPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        openPremiumPage();
        checkoutPage.acceptCookie();
        checkoutPage.isCountryLayerHidden();
        pdPage.buyPremium();
        openCheckoutPage();
        Thread.sleep(7000);
        checkoutPage.goToCheckout();
        checkoutPage.checkoutRegister("test", "test", faker.internet().emailAddress(), "19111994qQ!");
        checkoutPage.setPersonalDataForPremium();
        checkoutPage.setPaymentData();
        checkoutPage.pay();
        Assert.assertEquals(checkoutPage.getThankYouText().text(), "DONE!");
    }
    @Description("Тест на успішну покупку товара авторизованим користувачем")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    void purchaseProductTest() throws InterruptedException {
        LoginPage authPage = new LoginPage();
        PDPage pdPage = new PDPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        openProductPage();
        authPage.acceptCookie();
        authPage.isCountryLayerHidden();
        pdPage.addProductToBasket();
        Thread.sleep(7000);
        openCheckoutPage();
        Thread.sleep(7000);
        checkoutPage.goToCheckout();
        checkoutPage.checkoutLogin(TestValues.USER_EMAIL, TestValues.USER_PASS);
        checkoutPage.goToCheckout();
        checkoutPage.goToPayment();
        checkoutPage.setPaymentTypeToPayone();
        checkoutPage.setPaymentData();
        checkoutPage.pay();
        Assert.assertEquals(checkoutPage.getThankYouText().text(), "DONE!");
    }
}