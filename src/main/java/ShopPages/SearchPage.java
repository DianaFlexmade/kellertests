package ShopPages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends BasePage {
    private final SelenideElement searchResult = $("div > .search__headline");
    private final SelenideElement recommendedProduct = $(byXpath("(//a[@class='keywords__list-link']) [2]"));
    public String getSearchResultText(){
        return searchResult.text();
    }
    public void selectRecommendedProduct() {
        click(recommendedProduct);
        logger.info("Selected recommended product");
    }
}
