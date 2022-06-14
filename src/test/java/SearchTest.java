import ShopPages.SearchPage;
import helpers.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Description("Тест на коректний пошук рекомендованого товара")
    @Test(description = "Тест на коректний пошук рекомендованого товара", retryAnalyzer = RetryAnalyzer.class)
    void recommendedItemSearchTest() {
        SearchPage searchPage = new SearchPage();
        openMainPage();
        searchPage.acceptCookie();
        searchPage.clickOnSearchIcon();
        searchPage.selectRecommendedProduct();
        Assert.assertTrue(searchPage.getSearchResult().text().contains("SEARCH RESULTS FOR \"NIKE METCON\""));
    }

    @Description("Тест на коректний пошук довільного товара")
    @Test(description = "Тест на коректний пошук довільного товара", retryAnalyzer = RetryAnalyzer.class)
    void successfulSearchTest() {
        SearchPage searchPage = new SearchPage();
        openMainPage();
        searchPage.acceptCookie();
        searchPage.clickOnSearchIcon();
        searchPage.search("Adidas");
        Assert.assertTrue(searchPage.getSearchResult().text().contains("SEARCH RESULTS FOR \"ADIDAS\""));
    }

}
