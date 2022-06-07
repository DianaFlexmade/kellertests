import ShopPages.*;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BuyProductTest extends BaseTest{
    Faker faker = new Faker();

    @Test(description = "Тест на успішну покупку товара авторизованим користувачем")
    public void purchaseProductTest() throws InterruptedException {
        open("/");
        LoginPage authPage = new LoginPage();
        PDPage pdPage = new PDPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        authPage.registerUser(faker.internet().emailAddress(), "19111994qQ!", "19111994qQ!");
        authPage.click($(".btn-login"));
        authPage.getLoggedIn().shouldBe(Condition.visible);
        open("/p/nike-metcon-7-training-shoe-FSCNI0FH000.html");
        pdPage.addProductToBasket();
        Thread.sleep(5000);
        open("https://keller:sports17@checkout-stage.keller-sports.com/");
        checkoutPage.goToPay();
        Thread.sleep(5000);
        checkoutPage.setPersonalData();
        Thread.sleep(5000);
        checkoutPage.setPaymentData();
        Thread.sleep(5000);
        checkoutPage.pay();
        Assert.assertEquals(checkoutPage.getThankYouText(), "DONE!");
    }

    @Test(description = "Тест на покупку підписки Premium")
    public void buyPremiumTest() throws InterruptedException {
        open("/");
        LoginPage authPage = new LoginPage();
        PDPage pdPage = new PDPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        authPage.registerUser(faker.internet().emailAddress(), "19111994qQ!", "19111994qQ!");
        authPage.click($(".btn-login"));
        Thread.sleep(5000);
        pdPage.buyPremium();
        Thread.sleep(5000);
        open("https://keller:sports17@checkout-stage.keller-sports.com/");
        checkoutPage.checkPremiumProduct();
        checkoutPage.goToPay();
        Thread.sleep(5000);
        checkoutPage.setPersonalDataForPremium();
        Thread.sleep(5000);
        checkoutPage.setPaymentData();
        Thread.sleep(5000);
        checkoutPage.pay();
        Assert.assertEquals(checkoutPage.getThankYouText(), "DONE!");
    }
}