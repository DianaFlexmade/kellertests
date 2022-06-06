import ShopPages.*;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import helpers.TestValues;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BuyProductTest extends BaseTest{
    Faker faker = new Faker();
    private final String email = faker.internet().emailAddress();

    @Test(description = "Тест на покупку підписки Premium")
    public void buyPremiumTest() {
        open("/");
        LoginPage authPage = new LoginPage();
        PDPage pdPage = new PDPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        authPage.registerUser(email, "19111994qQ!", "19111994qQ!");
        authPage.click($(".btn-login"));
        pdPage.buyPremium();
        open("https://keller:sports17@checkout-stage.keller-sports.com/");
        checkoutPage.goToPay();
        checkoutPage.setPersonalDataForPremium();
        checkoutPage.setPaymentData();
        checkoutPage.pay();
        Assert.assertEquals(checkoutPage.getThankYouText(), "DONE!");
    }

    //TODO
    @Test(description = "Тест на успішну покупку товара авторизованим користувачем")
    public void purchaseProductTest() {
        open("/");
        LoginPage authPage = new LoginPage();
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        PDPage pdPage = new PDPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        authPage.registerUser(email, "19111994qQ!", "19111994qQ!");
        authPage.click($(".btn-login"));
        mainPage.clickOnSearchIcon();
        searchPage.selectRecommendedProduct();
        pdPage.addProduct();
        pdPage.addToBasket();
        open("https://keller:sports17@checkout-stage.keller-sports.com/");
        checkoutPage.goToPay();
        checkoutPage.setPersonalData();
        checkoutPage.setPaymentData();
        checkoutPage.pay();
        Assert.assertEquals(checkoutPage.getThankYouText(), "DONE!");
    }
}