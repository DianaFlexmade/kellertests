import ShopPages.SearchPage;
import helpers.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SearchTest extends BaseTest {
    SearchPage searchPage = new SearchPage();

    @Description("Тест на коректний пошук рекомендованого товара")
    @Test(description = "Тест на коректний пошук рекомендованого товара", retryAnalyzer = RetryAnalyzer.class)
    void recommendedItemSearchTest() {
        open("/");
        searchPage.acceptCookie()
                .clickOnSearchIcon()
                .selectRecommendedProduct();
        Assert.assertTrue(searchPage.getSearchResult().text().contains("SEARCH RESULTS FOR \"NIKE METCON\""));
    }

    @Description("Тест на коректний пошук довільного товара")
    @Test(description = "Тест на коректний пошук довільного товара", retryAnalyzer = RetryAnalyzer.class)
    void successfulSearchTest()  {
        open("/");
        searchPage.acceptCookie()
                .clickOnSearchIcon()
                .search("Adidas");
        Assert.assertTrue(searchPage.getSearchResult().text().contains("SEARCH RESULTS FOR \"ADIDAS\""));
    }
}
