package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    private final SelenideElement searchField = $("#searchParamDesktop");
    private final SelenideElement searchIcon = $(".test-search-popup-button");
    Logger logger = LoggerFactory.getLogger(BasePage.class);
    public void click(SelenideElement element){
        element.click();
    }
    public void acceptCookie(){
        $("#uc-btn-accept-banner").click();
    }
    public boolean isCountryLayerHidden() {
        if ($("#js_country-layer-close-icon").is(Condition.hidden)) {
            return true;
        } else {
            $("#js_country-layer-close-icon").click();
            return false;
        }
    }
    public void clickOnSearchIcon() {
        click(searchIcon);
    }
    public SearchPage search(String searchString){
        searchField.sendKeys(searchString, Keys.ENTER);
        return new SearchPage();
    }
}
