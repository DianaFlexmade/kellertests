import ShopPages.PDPage;
import ShopPages.WishlistPage;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class WishlistTest extends BaseTest {

    @Test(description = "Тест на додання товара до вішліста")
    public void addToWishlistTest() throws InterruptedException {
        PDPage pdPage = new PDPage();
        WishlistPage wishlistPage = new WishlistPage();
        open("/p/nike-fury-3.0-headband-REQNI00O000.html");
        pdPage.acceptCookie();
        pdPage.addToWishlist();
        pdPage.goToWishlist();
        wishlistPage.checkWishlistAmount();
    }

    @Test(description = "Тест на видалення товара з вішліста")
    public void removeFromWishlistTest() {
        PDPage pdPage = new PDPage();
        WishlistPage wishlistPage = new WishlistPage();
        open("/p/nike-fury-3.0-headband-REQNI00O000.html");
        pdPage.acceptCookie();
        pdPage.addToWishlist();
        pdPage.goToWishlist();
        wishlistPage.removeItemFromWishlist();
        wishlistPage.removeText().shouldHave(Condition.text("The article has been removed from your wishlist."));
    }
}
