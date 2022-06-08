import ShopPages.PDPage;
import ShopPages.WishlistPage;
import com.codeborne.selenide.Condition;
import helpers.RetryAnalyzer;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {

    @Test(description = "Тест на додання товара до вішліста", retryAnalyzer = RetryAnalyzer.class)
    public void addToWishlistTest() {
        PDPage pdPage = new PDPage();
        WishlistPage wishlistPage = new WishlistPage();
        openProductPage();
        pdPage.acceptCookie();
        pdPage.addToWishlist();
        pdPage.goToWishlist();
        wishlistPage.checkWishlistAmount();
    }

    @Test(description = "Тест на видалення товара з вішліста", retryAnalyzer = RetryAnalyzer.class)
    public void removeFromWishlistTest() {
        PDPage pdPage = new PDPage();
        WishlistPage wishlistPage = new WishlistPage();
        openProductPage();
        pdPage.acceptCookie();
        pdPage.addToWishlist();
        pdPage.goToWishlist();
        wishlistPage.removeItemFromWishlist();
        wishlistPage.removeText().shouldHave(Condition.text("The article has been removed from your wishlist."));
    }
}
