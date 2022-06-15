package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    private final SelenideElement searchField = $("#searchParamDesktop");
    private final SelenideElement searchIcon = $(".test-search-popup-button");

    public void click(SelenideElement element) {
        element.click();
    }

//    @Step("Прийняти cookies")
    public BasePage acceptCookie() {
        $("#uc-btn-accept-banner").click();
        return new BasePage();
    }
//    @Step("Закрити попап вибору країни")
    public void isCountryLayerVisible() {
        if ($("#js_country-layer-close-icon").is(Condition.visible)) {
            $("#js_country-layer-close-icon").click();
            new BasePage();
            return;
        }
        new BasePage();
    }
//    @Step("Натиснути на іконку пошуку")
    public SearchPage clickOnSearchIcon() {
        click(searchIcon);
        return new SearchPage();
    }
//    @Step("Ввести пошуковий запит")
    public SearchPage search(String searchString) {
        searchField.sendKeys(searchString, Keys.ENTER);
        return new SearchPage();
    }
}
