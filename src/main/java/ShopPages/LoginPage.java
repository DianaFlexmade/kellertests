package ShopPages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private final SelenideElement emailField = $("input[type='email']");
    private final SelenideElement loginField = $("#js_login_email");
    private final SelenideElement passwordField = $("input[name='password']");
    private final SelenideElement repeatPasswordField = $("input[name=\"password_confirmation\"]");
    private final SelenideElement termsCheckbox = $("label[for='terms-agree']");
    private final SelenideElement registerButton = $(".test-register-button");
    private final SelenideElement loginButton = $(".test-login-button");
    private final SelenideElement successRegText = $(byXpath("//h4[@class=\"layer-title\"]"));
    private final SelenideElement weakPassMessage = $(byXpath("(//*[@class = 'input-box__note input-box__note--error']) [2]"));
    private final SelenideElement wrongPassMessage = $("div> .input-box__note--error");
    private final SelenideElement myAccount = $(".test-logged-link");
    private final SelenideElement myAccountText = $("span .account__logout-link");

    private final SelenideElement loggedIn = $(byXpath("//div[@class=\"header-top-right__dropdown-hold header-top-right__dropdown-hold--user show-desktop\"]"));

    public SelenideElement openRegPageText() {
        return successRegText;
    }

    public SelenideElement getLoggedIn(){
        return loggedIn;
    }
    public SelenideElement getSuccessRegMessage() {
        return successRegText;
    }

    public SelenideElement getWeakPassMessage() {
        return weakPassMessage;
    }

    public SelenideElement getWrongPassMessage() {
        return wrongPassMessage;
    }

    public void registerUser(String emailFieldValue, String passwordFieldValue, String repeatPasswordFieldValue) {
        LoginPage loginPage = new LoginPage();
        loginPage.acceptCookie();
        loginPage.openLoginPage();
        click($( ".test-register-popup-button"));
        loginPage.openRegPageText().shouldHave(Condition.exactText("CREATE CUSTOMER ACCOUNT"));
        click(emailField);
        emailField.sendKeys(emailFieldValue);
        passwordField.sendKeys(passwordFieldValue);
        repeatPasswordField.sendKeys(repeatPasswordFieldValue);
        termsCheckbox.click(ClickOptions.usingDefaultMethod().offset(-150,0));
        click(registerButton);
    }

    public void authorizeUser(String emailFieldValue, String passwordFieldValue) {
        MainPage mainPage = new MainPage();
        mainPage.acceptCookie();
        mainPage.openLoginPage();
        click(loginField);
        loginField.sendKeys(emailFieldValue);
        passwordField.sendKeys(passwordFieldValue);
        loginButton.click();
    }
}
