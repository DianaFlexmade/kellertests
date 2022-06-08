package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    Logger logger = LoggerFactory.getLogger(BasePage.class);
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
        if ($("#js_country-layer-close-icon").exists()) {
            $("#js_country-layer-close-icon").click();
        } else {
            $("#js_country-layer-close-icon").shouldBe(Condition.hidden);
            logger.info("Country Layer is missing");
        }
    }
}
