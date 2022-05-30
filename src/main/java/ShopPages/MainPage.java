package ShopPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BasePage {
    private final SelenideElement loggedInLink = $(".test-logged-link");


    private final SelenideElement searchIcon = $(".test-search-popup-button");
    private final SelenideElement searchField = $("#searchParamDesktop");

    public SelenideElement getLoginElementLink() {
        return loggedInLink;
    }

    public void clickOnSearchIcon() {searchIcon.click();}

    public SearchPage search(String searchString){
        searchField.sendKeys(searchString);
        searchField.sendKeys(Keys.ENTER);
        return new SearchPage();
    }
}

