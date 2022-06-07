package ShopPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class PDPage extends BasePage{
    private SelenideElement addPremiumToBasket = $(byXpath("//button[@class=\"premium-details__button\"]"));
    private SelenideElement premiumLink = $(".test-account-popup-link");
    private SelenideElement pdpWishlistIcon = $("div .wishlist-heart--animated");
    private SelenideElement wishListButton = $(".js-miniwishlist");
    private SelenideElement sizeButton = $("button[data-name='EU 38 - US 5,5']");

    private SelenideElement addToBasket = $("#js_add_to_basket");
    public void addProductToBasket() {
        closeCountryLayer();
        actions().moveToElement(sizeButton).click(sizeButton).perform();
        click(sizeButton);
        click(addToBasket);
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
