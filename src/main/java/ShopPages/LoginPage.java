package ShopPages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private final SelenideElement registerLink = $( ".test-register-popup-button");
    private final SelenideElement emailField = $(".test-register-email");
    private final SelenideElement loginField = $("#js_login_email");
    private final SelenideElement passwordField = $("input[name='password']");
    private final SelenideElement repeatPasswordField = $("input[name='password_confirmation']");
    private final SelenideElement termsCheckbox = $("label[for='terms-agree']");
    private final SelenideElement registerButton = $(".test-register-button");
    private final SelenideElement loginButton = $(".test-login-button");
    private final SelenideElement successRegMessage = $("h4[class='layer-title']");
    private final SelenideElement weakPassMessage = $(byXpath("(//*[@class = 'input-box__note input-box__note--error']) [2]"));
    private final SelenideElement wrongPassMessage = $("div> .input-box__note--error");
    private final SelenideElement myAccount = $(".test-logged-link");
    private final SelenideElement myOrdersText = $("div > h1");


    public SelenideElement getSuccessRegMessage() {
        return successRegMessage;
    }

    public SelenideElement getWeakPassMessage() {
        return weakPassMessage;
    }

    public SelenideElement getWrongPassMessage() {
        return wrongPassMessage;
    }

    public void registerUser(String emailFieldValue, String passwordFieldValue, String repeatPasswordFieldValue) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.acceptCookie();
        loginPage.openLoginPage();
        click($( ".test-register-popup-button"));
        emailField.sendKeys(emailFieldValue);
        passwordField.sendKeys(passwordFieldValue);
        repeatPasswordField.sendKeys(repeatPasswordFieldValue);
        termsCheckbox.click(ClickOptions.usingDefaultMethod().offset(-150,0));
        click(registerButton);
    }

    public MainPage authorizeUser(String emailFieldValue, String passwordFieldValue) throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.acceptCookie();
        mainPage.openLoginPage();
        loginField.sendKeys(emailFieldValue);
        passwordField.sendKeys(passwordFieldValue);
        loginButton.click();

        return mainPage;
    }

    public void goToMyAccount() {
        myAccount.shouldBe(Condition.appear);
        myAccount.click();
    }

    public String checkMyOrdersPage(){
        return myOrdersText.text();
    }

}
