import ShopPages.*;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import helpers.TestValues;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BuyProductTest extends BaseTest{
    Faker faker = new Faker();

    @Test(description = "Тест на покупку підписки Premium")
    public void buyPremiumTest() throws InterruptedException {
        open("/");
        LoginPage authPage = new LoginPage();
        PDPage pdPage = new PDPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        authPage.registerUser(faker.internet().emailAddress(), "19111994qQ!", "19111994qQ!");
        authPage.click($(".btn-login"));
        pdPage.buyPremium();
//        open("https://keller:sports17@checkout-stage.keller-sports.com/");
//        checkoutPage.checkAddedPremium();
//        Thread.sleep(7000);
//        checkoutPage.goToPay();
//        checkoutPage.setPersonalDataForPremium();
//        checkoutPage.setPaymentData();
//        checkoutPage.pay();
//        Assert.assertEquals(checkoutPage.getThankYouText().text(), "DONE!");
    }

    @Test(description = "Тест на успішну покупку товара авторизованим користувачем")
    public void purchaseProductTest() throws InterruptedException {
        open("/");
        LoginPage authPage = new LoginPage();
        authPage.acceptCookie();
        PDPage pdPage = new PDPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        open("/p/nike-metcon-7-training-shoe-FSCNI0FH000.html");
        authPage.closeCountryLayer();
//        pdPage.addProductToBasket();
//        open("https://keller:sports17@checkout-stage.keller-sports.com/");
//        checkoutPage.goToPay();
//        checkoutPage.checkoutLogin(TestValues.USER_EMAIL, TestValues.USER_PASS);
//        checkoutPage.goToPay();
//        checkoutPage.goToPayment();
//        checkoutPage.setPayment();
//        checkoutPage.setPaymentData();
//        checkoutPage.pay();
//        Assert.assertEquals(checkoutPage.getThankYouText().text(), "DONE!");
    }
}