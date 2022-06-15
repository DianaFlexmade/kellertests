import ShopPages.SearchPage;
import helpers.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    SearchPage searchPage = new SearchPage();
    @BeforeMethod
    void openPage() {
        openMainPage();
    }
    @Description("Тест на коректний пошук рекомендованого товара")
    @Test(description = "Тест на коректний пошук рекомендованого товара", retryAnalyzer = RetryAnalyzer.class)
    void recommendedItemSearchTest() {
        searchPage.acceptCookie()
                .clickOnSearchIcon()
                .selectRecommendedProduct();
        Assert.assertTrue(searchPage.getSearchResult().text().contains("SEARCH RESULTS FOR \"NIKE METCON\""));
    }

    @Description("Тест на коректний пошук довільного товара")
    @Test(description = "Тест на коректний пошук довільного товара", retryAnalyzer = RetryAnalyzer.class)
    void successfulSearchTest() {
        searchPage.acceptCookie()
                .clickOnSearchIcon()
                .search("Adidas");
        Assert.assertTrue(searchPage.getSearchResult().text().contains("SEARCH RESULTS FOR \"ADIDAS\""));
    }

}
