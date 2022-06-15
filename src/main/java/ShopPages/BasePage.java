package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    Logger logger = LoggerFactory.getLogger(BasePage.class);
    private final SelenideElement searchField = $("#searchParamDesktop");
    private final SelenideElement searchIcon = $(".test-search-popup-button");

    public void click(SelenideElement element) {
        element.click();
    }

    public BasePage acceptCookie() {
        $("#uc-btn-accept-banner").click();
        return new BasePage();
    }
    public BasePage isCountryLayerVisible() {
        if ($("#js_country-layer-close-icon").is(Condition.visible)) {
            $("#js_country-layer-close-icon").click();
            return new BasePage();
        }
        return new BasePage();
    }
    public SearchPage clickOnSearchIcon() {
        click(searchIcon);
        return new SearchPage();
    }
    public SearchPage search(String searchString) {
        searchField.sendKeys(searchString, Keys.ENTER);
        return new SearchPage();
    }
}
