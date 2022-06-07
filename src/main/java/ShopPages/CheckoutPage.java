package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class CheckoutPage extends BasePage {

    private SelenideElement goToCheckoutButton = $(".test-goto-shipping-button");
    private SelenideElement premiumImage = $(".product-list__product-image");
    private SelenideElement continueToPayment = $(".test-shipping-submit-button");
    private SelenideElement iframeForCardNumber = $(byXpath("(//iframe[@frameborder=\"0\"])[1]"));
    private SelenideElement iframeForValidUntilMonth = $(byXpath("(//iframe[@frameborder=\"0\"])[2]"));
    private SelenideElement iframeForValidUntilYear = $(byXpath("(//iframe[@frameborder=\"0\"])[3]"));
    private SelenideElement iframeForCvv = $(byXpath("(//iframe[@frameborder=\"0\"])[4]"));
    private SelenideElement cardNumber = $("#cardpan");
    private SelenideElement cardHolder = $("input[name='payment[payone][card_holder]']");
    private SelenideElement cardExpireMonth = $("#cardexpiremonth");
    private SelenideElement cardExpireYear = $("#cardexpireyear");
    private SelenideElement cardCvv = $("#cardcvc2");
    private SelenideElement checkOrder = $(".test-payment-submit");
    private SelenideElement pay = $(".test-pay-now-button");
    private SelenideElement thankYou = $(".thankyou-header__title");
    private SelenideElement genderSelect = $(byXpath("//label[@for=\"shipping-gender-female\"]"));

    private SelenideElement firstName = $(byXpath("//input[@name=\"shipping[first_name]\"]"));
    private SelenideElement secondName = $(byXpath("//input[@name=\"shipping[last_name]\"]"));
    private SelenideElement street = $(byXpath("//input[@name=\"shipping[street]\"]"));
    private SelenideElement streetNo = $(byXpath("//input[@name=\"shipping[street_no]\"]"));
    private SelenideElement postCode = $(byXpath("//input[@name=\"shipping[postal]\"]"));
    private SelenideElement city = $(byXpath("//input[@name=\"shipping[city]\"]"));

    private SelenideElement dateOfBirthDay = $(byXpath("//select[@name=\"shipping[bday_day]\"]"));
    private SelenideElement dateOfBirthMonth = $(byXpath("//select[@name=\"shipping[bday_month]\"]"));
    private SelenideElement dateOfBirthYear = $(byXpath("//select[@name=\"shipping[bday_year]\"]"));

    public void goToPay() {
        premiumImage.shouldBe(Condition.visible);
        goToCheckoutButton.shouldBe(Condition.visible);
        click(goToCheckoutButton);
    }

    public void setPersonalData() {
        genderSelect.shouldBe(Condition.visible);
        click(genderSelect);
        firstName.sendKeys("test");
        secondName.sendKeys("test");
        street.sendKeys("test");
        streetNo.sendKeys("1");
        postCode.sendKeys("12345");
        city.sendKeys("test");
        click(continueToPayment);
    }

    public void setPersonalDataForPremium() {
        genderSelect.shouldBe(Condition.visible);
        click(genderSelect);
        firstName.sendKeys("test");
        secondName.sendKeys("test");
        dateOfBirthDay.selectOptionByValue("1");
        dateOfBirthMonth.selectOptionByValue("1");
        dateOfBirthYear.selectOptionByValue("1994");
        street.sendKeys("test");
        streetNo.sendKeys("1");
        postCode.sendKeys("12345");
        city.sendKeys("test");
        click(continueToPayment);
    }

    public void setPaymentData() {
        iframeForCardNumber.shouldBe(Condition.visible);
        switchTo().frame(iframeForCardNumber);
        cardNumber.sendKeys("4988438843884305");
        switchTo().parentFrame();
        cardHolder.sendKeys("test test");
        switchTo().frame(iframeForValidUntilMonth);
        cardExpireMonth.selectOptionByValue("3");
        switchTo().parentFrame();
        switchTo().frame(iframeForValidUntilYear);
        cardExpireYear.selectOptionByValue("2030");
        switchTo().parentFrame();
        switchTo().frame(iframeForCvv);
        cardCvv.sendKeys("737");
        switchTo().parentFrame();
        click(checkOrder);
        pay.shouldBe(Condition.visible);
    }

    public void pay(){
        click(pay);
    }

    public SelenideElement getThankYouText() {
        thankYou.shouldBe(Condition.visible);
        return thankYou;
    }
}
