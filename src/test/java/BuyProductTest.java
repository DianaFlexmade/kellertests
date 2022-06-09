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
    @Test()
    void buyPremiumTest() throws InterruptedException {
//        PDPage pdPage = new PDPage();
//        CheckoutPage checkoutPage = new CheckoutPage();
//        openPremiumPage();
//        checkoutPage.acceptCookie();
//        checkoutPage.closeCountryLayer();
//        pdPage.buyPremium();
//        openCheckoutPage();
//        Thread.sleep(7000);
//        checkoutPage.goToPay();
//        checkoutPage.checkoutRegister("test", "test", faker.internet().emailAddress(), "19111994qQ!");
//        checkoutPage.setPersonalDataForPremium();
//        checkoutPage.setPaymentData();
//        checkoutPage.pay();
//        Assert.assertEquals(checkoutPage.getThankYouText().text(), "DONE!");
        Assert.fail();
    }
    @Description("Тест на успішну покупку товара авторизованим користувачем")
    @Test
    void purchaseProductTest() throws InterruptedException {
//        LoginPage authPage = new LoginPage();
//        PDPage pdPage = new PDPage();
//        CheckoutPage checkoutPage = new CheckoutPage();
//        openProductPage();
//        authPage.acceptCookie();
//        authPage.closeCountryLayer();
//        pdPage.addProductToBasket();
//        Thread.sleep(7000);
//        openCheckoutPage();
//        Thread.sleep(7000);
//        checkoutPage.goToPay();
//        checkoutPage.checkoutLogin(TestValues.USER_EMAIL, TestValues.USER_PASS);
//        checkoutPage.goToPay();
//        checkoutPage.goToPayment();
//        checkoutPage.setPayment();
//        checkoutPage.setPaymentData();
//        checkoutPage.pay();
//        Assert.assertEquals(checkoutPage.getThankYouText().text(), "DONE!");
        Assert.fail();
    }
}