package ShopPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    public void click(SelenideElement element){
        element.click();
    }
    public void acceptCookie(){
        $("#uc-btn-accept-banner").click();
    }

    public void openLoginPage(){
        $(".test-login-link").click();
    }

    public void closeCountryLayer() {
        $("#js_country-layer-close-icon").click();
    }
}
