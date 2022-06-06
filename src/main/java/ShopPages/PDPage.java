package ShopPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class PDPage extends BasePage{
    private final SelenideElement addToBasketButton = $("#js_add_to_basket");

    private SelenideElement addPremiumToBasket = $(byXpath("//button[@class=\"premium-details__button\"]"));
    private SelenideElement premiumLink = $(".test-account-popup-link");
    private SelenideElement pdpWishlistIcon = $("div .wishlist-heart--animated");
    private SelenideElement wishListButton = $(".js-miniwishlist");
    private SelenideElement sizeButton = $("button[data-name='EU 38,5 - US 6']");
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

    public void addToWishlist() {
        actions().moveToElement(pdpWishlistIcon).click(pdpWishlistIcon).perform();
        click(pdpWishlistIcon);
    }

    public WishlistPage goToWishlist(){
        WishlistPage wishlistPage = new WishlistPage();
        click(wishListButton);
        return wishlistPage;
    }

    public void buyPremium(){
        click(premiumLink);
        closeCountryLayer();
        click(addPremiumToBasket);
    }
}
