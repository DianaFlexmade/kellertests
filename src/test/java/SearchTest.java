import ShopPages.MainPage;
import ShopPages.SearchPage;
import helpers.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Description("Тест на коректний пошук рекомендованого товара")
    @Test
    void recommendedItemSearchTest() {
//        MainPage mainPage = new MainPage();
//        SearchPage searchPage = new SearchPage();
//        openMainPage();
//        mainPage.acceptCookie();
//        mainPage.clickOnSearchIcon();
//        searchPage.selectRecommendedProduct();
        Assert.fail();
//        Assert.assertTrue(searchPage.getSearchResult().text().contains("SEARCH RESULTS FOR \"NIKE METCON\""));
    }

    @Description("Тест на коректний пошук довільного товара")
    @Test
    void successfulSearchTest() {
//        MainPage mainPage = new MainPage();
//        SearchPage searchPage = new SearchPage();
//        openMainPage();
//        searchPage.acceptCookie();
//        mainPage.clickOnSearchIcon();
//        mainPage.search("Adidas");
        Assert.fail();
//        Assert.assertTrue(searchPage.getSearchResult().text().contains("SEARCH RESULTS FOR \"ADIDAS\""));
    }

}
