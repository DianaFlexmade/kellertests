package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BasePage {
    private final SelenideElement searchField = $("#searchParamDesktop");

    public void clickOnSearchIcon() {
        click($(".test-search-popup-button"));
    }
    public SearchPage search(String searchString){
        searchField.sendKeys(searchString, Keys.ENTER);
        return new SearchPage();
    }
}

