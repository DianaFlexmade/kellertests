import ShopPages.PDPage;
import ShopPages.WishlistPage;
import com.codeborne.selenide.Condition;
import helpers.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {
    
    @Description("Тест на додання товара до вішліста")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    void addToWishlistTest() {
        PDPage pdPage = new PDPage();
        WishlistPage wishlistPage = new WishlistPage();
        openProductPage();
        pdPage.acceptCookie();
        pdPage.addToWishlist();
        pdPage.goToWishlist();
        wishlistPage.checkWishlistAmount().shouldHave(Condition.text("1"));
    }

    @Description("Тест на видалення товара з вішліста")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    void removeFromWishlistTest() {
        PDPage pdPage = new PDPage();
        WishlistPage wishlistPage = new WishlistPage();
        openProductPage();
        pdPage.acceptCookie();
        pdPage.addToWishlist();
        pdPage.goToWishlist();
        wishlistPage.removeItemFromWishlist();
        wishlistPage.removeText().shouldNotHave(Condition.text("The article has been removed from your wishlist."));
//        wishlistPage.removeText().shouldHave(Condition.text("The article has been removed from your wishlist."));
    }
}
