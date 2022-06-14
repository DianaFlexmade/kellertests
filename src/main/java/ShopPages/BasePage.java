package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    private final SelenideElement searchField = $("#searchParamDesktop");
    private final SelenideElement searchIcon = $(".test-search-popup-button");

    public void click(SelenideElement element) {
        element.click();
    }

    @Step("Прийняти cookies")
    public BasePage acceptCookie() {
        $("#uc-btn-accept-banner").click();
        return new BasePage();
    }
    @Step("Закрити попап вибору країни")
    public BasePage isCountryLayerVisible() {
        if ($("#js_country-layer-close-icon").is(Condition.visible)) {
            $("#js_country-layer-close-icon").click();
            return new BasePage();
        }
        return new BasePage();
    }
    @Step("Натиснути на іконку пошуку")
    public SearchPage clickOnSearchIcon() {
        click(searchIcon);
        return new SearchPage();
    }
    @Step("Ввести пошуковий запит")
    public SearchPage search(String searchString) {
        searchField.sendKeys(searchString, Keys.ENTER);
        return new SearchPage();
    }
}
