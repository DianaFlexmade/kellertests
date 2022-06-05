package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class CheckoutPage extends BasePage {

    private SelenideElement goToPayButton = $(".test-goto-shipping-button");
    private SelenideElement continueToPayment = $(".test-shipping-submit-button");
    private SelenideElement genderMale = $("label[for='shipping-gender-male']");
    private SelenideElement firstNameField = $("input[name='shipping[first_name]']");
    private SelenideElement lastNameField = $("input[name='shipping[last_name]']");
    private SelenideElement shippingStreet = $("input[name='shipping[street]']");
    private SelenideElement shippingStreetNo = $("input[name='shipping[street_no]']");
    private SelenideElement postcode = $("input[name='shipping[postal]']");
    private SelenideElement shippingCity = $("input[name='shipping[city]']");
    private SelenideElement chooseIframeForExpiryDate = $(byXpath("(//iframe[@frameborder=\"0\"])[6]"));
    private SelenideElement iframeForCVC = $(byXpath("(//iframe[@frameborder=\"0\"])[4]"));
    private SelenideElement iframeForCardNumber = $(byXpath("(//iframe[@frameborder=\"0\"])[1]"));
    private SelenideElement cardNumber = $("#cardpan");
    private SelenideElement cardHolder = $("input[name='payment[payone][card_holder]']");
    private SelenideElement cardExpireMonth = $("#cardexpiremonth");
    private SelenideElement cardExpireYear = $("#cardexpireyear");
    private SelenideElement cardCvv = $("#cardcvc2");
    private SelenideElement checkOrder = $(".test-payment-submit");

    private SelenideElement pay = $(".test-pay-now-button");

    public void goToPay() {
        click(goToPayButton);
    }

    public void selectMaleGender() {
        click(genderMale);
    }

    public void setPersonalData() {
//        firstNameField.sendKeys("test");
//        lastNameField.sendKeys("test");
//        shippingStreet.sendKeys("test");
//        shippingStreetNo.sendKeys("1");
//        postcode.sendKeys("45365");
//        shippingCity.sendKeys("test");
        click(continueToPayment);
    }

    public void setPaymentNumber() {
        switchTo().frame(iframeForCardNumber);
        cardNumber.sendKeys("4988438843884305");
    }

    public void setPaymentName(){
        cardHolder.sendKeys("test test");
    }

    public void setPaymentData(){
        cardExpireMonth.selectOptionByValue("3");
        cardExpireYear.selectOptionByValue("2030");
        cardCvv.sendKeys("737");
        click(checkOrder);
    }
    public void pay(){
        click(pay);
    }
}
