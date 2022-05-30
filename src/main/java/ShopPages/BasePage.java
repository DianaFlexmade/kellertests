package ShopPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    private final SelenideElement loginButton = $(".test-login-link");
    private final SelenideElement acceptCookie = $("#uc-btn-accept-banner");
    public void acceptCookie(){
        acceptCookie.click();
    }

    public void clickElement(SelenideElement element){
        element.click();
    }

    public void openLoginPage(){
        loginButton.click();
    }
}
