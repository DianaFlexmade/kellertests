package ShopPages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class PDPage extends BasePage{
    private final SelenideElement addToBasketButton = $("#js_add_to_basket");
    private final SelenideElement miniBasketQuantity = $("#js_product_quantity");
    private final SelenideElement keyfactsScroll = $("section > .js-navi-page-content-item-label");

    private SelenideElement pdpWishlistIcon = $("div > .product-parameters__add-to-wishlist-btn");
    private SelenideElement wishListButton = $(".js-miniwishlist");

    public void scrollToKeyFacts() {
        keyfactsScroll.scrollIntoView(true);
    }
    public void addToBasket() {
        addToBasketButton.click();
    }
    public SelenideElement checkMiniBasket() {
        return miniBasketQuantity;
    }

    public void addToWishlist() {
        pdpWishlistIcon.click();
    }

    public WishlistPage goToWishlist(){
        WishlistPage wishlistPage = new WishlistPage();
        wishListButton.click();
        return wishlistPage;
    }
}
