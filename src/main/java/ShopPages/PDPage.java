package ShopPages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class PDPage extends BasePage{
    private final SelenideElement addToBasketButton = $("#js_add_to_basket");
    private final SelenideElement miniBasketQuantity = $("#js_product_quantity");
    private SelenideElement pdpWishlistIcon = $("div .wishlist-heart--animated");
    private SelenideElement wishListButton = $(".js-miniwishlist");
    public void addToBasket() {
        actions().moveToElement(addToBasketButton).click(addToBasketButton).perform();
        click(addToBasketButton);
    }
    public SelenideElement checkMiniBasket() {
        return miniBasketQuantity;
    }

    public void addToWishlist() {
        actions().moveToElement(pdpWishlistIcon).click(pdpWishlistIcon).perform();
        click(pdpWishlistIcon);
    }

    public WishlistPage goToWishlist(){
        WishlistPage wishlistPage = new WishlistPage();
        click(wishListButton);
        return wishlistPage;
    }
}
