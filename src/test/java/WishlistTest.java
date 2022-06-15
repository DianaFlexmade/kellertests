import ShopPages.PDPage;
import ShopPages.WishlistPage;
import com.codeborne.selenide.Condition;
import helpers.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {
    PDPage pdPage = new PDPage();
    WishlistPage wishlistPage = new WishlistPage();
    @Description("Тест на додання товара до вішліста")
    @Test(description = "Тест на коректний пошук довільного товара", retryAnalyzer = RetryAnalyzer.class)
    void addToWishlistTest() {
        openProductPage();
        pdPage.acceptCookie();
        pdPage.addToWishlist()
                .goToWishlist()
                .checkWishlistAmount().should(Condition.exist);
        Assert.assertEquals(wishlistPage.checkWishlistAmount().text(), "1");
    }

    @Description("Тест на видалення товара з вішліста")
    @Test(description = "Тест на коректний пошук довільного товара", retryAnalyzer = RetryAnalyzer.class)
    void removeFromWishlistTest() {
        openProductPage();
        pdPage.acceptCookie();
        pdPage.addToWishlist()
                .goToWishlist();
        wishlistPage.removeItemFromWishlist()
                .removeText().shouldHave(Condition.text("The article has been removed from your wishlist."));
        Assert.assertEquals(wishlistPage.removeText().text(), "The article has been removed from your wishlist.");
    }
}
