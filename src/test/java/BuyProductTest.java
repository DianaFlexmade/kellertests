import ShopPages.CheckoutPage;
import ShopPages.LoginPage;
import ShopPages.PDPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import com.github.javafaker.Faker;
import helpers.RetryAnalyzer;
import helpers.TestValues;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BuyProductTest extends BaseTest{
    Faker faker = new Faker();

    @Description("Тест на покупку підписки Premium")
    @Test(description = "Тест на покупку підписки Premium", retryAnalyzer = RetryAnalyzer.class)
    void buyPremiumTest()  {
        PDPage pdPage = new PDPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        openPremiumPage();
        checkoutPage.acceptCookie();
        checkoutPage.isCountryLayerHidden();
        pdPage.buyPremium();
        openCheckoutPage();
        checkoutPage.goToCheckout();
        checkoutPage.checkoutRegister("test", "test", faker.internet().emailAddress(), "19111994qQ!");
        checkoutPage.setPersonalDataForPremium();
        checkoutPage.setPaymentData();
        checkoutPage.pay();
        Assert.assertEquals(checkoutPage.getThankYouText().text(), "DONE!");
    }
    @Description("Тест на успішну покупку товара авторизованим користувачем")
    @Test(description = "Тест на успішну покупку товара авторизованим користувачем", retryAnalyzer = RetryAnalyzer.class)
    void purchaseProductTest() {
        LoginPage authPage = new LoginPage();
        PDPage pdPage = new PDPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        openProductPage();
        authPage.acceptCookie();
        authPage.isCountryLayerHidden();
        pdPage.addProductToBasket();
        pdPage.getBasketCount().shouldHave(Condition.text("1"));
        openCheckoutPage();
        checkoutPage.goToCheckout();
        checkoutPage.checkoutLogin(TestValues.USER_EMAIL, TestValues.USER_PASS);
        checkoutPage.getAddedProduct().should(Condition.exist);
        checkoutPage.goToCheckout();
        checkoutPage.goToPayment();
        checkoutPage.setPaymentTypeToPayone();
        checkoutPage.setPaymentData();
        checkoutPage.pay();
        Assert.assertEquals(checkoutPage.getThankYouText().text(), "DONE!");
    }
}