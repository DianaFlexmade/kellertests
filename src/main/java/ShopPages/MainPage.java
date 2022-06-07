package ShopPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private final SelenideElement searchField = $("#searchParamDesktop");
    private final SelenideElement searchIcon = $(".test-search-popup-button");

    public void clickOnSearchIcon() {
        click(searchIcon);
    }
    public SearchPage search(String searchString){
        searchField.sendKeys(searchString, Keys.ENTER);
        return new SearchPage();
    }
}

