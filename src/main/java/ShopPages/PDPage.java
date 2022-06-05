package ShopPages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class PDPage extends BasePage{
    private final SelenideElement addToBasketButton = $("#js_add_to_basket");
    private final SelenideElement miniBasketQuantity = $("#js_product_quantity");
    private SelenideElement pdpWishlistIcon = $("div .wishlist-heart--animated");
    private SelenideElement wishListButton = $(".js-miniwishlist");
    private SelenideElement sizeButton = $("button[data-name='EU 36,5 - US 4,5']");

    private SelenideElement product = $("a[id='FSCNI0FH000']");
    public void addToBasket() {
        actions().moveToElement(addToBasketButton).click(addToBasketButton).perform();
        click(addToBasketButton);
    }

    public void addProduct(){
        click(product);
        closeCountryLayer();
        actions().moveToElement(sizeButton).click(sizeButton).perform();
        click(sizeButton);
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
