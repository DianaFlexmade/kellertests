package ShopPages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends BasePage {

    private SelenideElement searchResult = $("div > .search__headline");
    private SelenideElement recommendedProduct = $(byXpath("(//a[@class='keywords__list-link']) [2]"));

    public SelenideElement getSearchResultText(){
        return searchResult;
    }

    public void selectRecommendedProduct() {
        click(recommendedProduct);
    }
}
