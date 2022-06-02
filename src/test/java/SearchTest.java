import ShopPages.MainPage;
import ShopPages.SearchPage;
import com.codeborne.selenide.Condition;
import helpers.TestValues;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SearchTest extends BaseTest {

    @Test(description = "Тест на коректний пошук рекомендованого товара")
    public void recommendedItemSearchTest() {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        open("/");
        mainPage.acceptCookie();
        mainPage.clickOnSearchIcon();
        searchPage.selectRecommendedProduct();
        Assert.assertEquals(searchPage.getSearchResultText().text(), TestValues.RECOMMENDED_RESULT);
    }

    @Test(description = "Тест на коректний пошук довільного товара")
    public void successfulSearchTest() {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        open("/");
        searchPage.acceptCookie();
        mainPage.clickOnSearchIcon();
        mainPage.search("Adidas Terrex");
        Assert.assertEquals(searchPage.getSearchResultText().text(), TestValues.SEARCH_RESULT);
    }

}
