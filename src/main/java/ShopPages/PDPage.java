package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class PDPage extends BasePage{
    private final SelenideElement addPremiumToBasket = $(byXpath("//button[@class=\"premium-details__button\"]"));
    private final SelenideElement pdpWishlistIcon = $("div .wishlist-heart--animated");
    private final SelenideElement wishListButton = $(".js-miniwishlist");
    private final SelenideElement addToBasket = $("#js_add_to_basket");
    private SelenideElement basketCount = $("#js_product_quantity");
    public void addProductToBasket() {
        actions().moveToElement(addToBasket).perform();
        click(addToBasket);
    }

    public void addToWishlist() {
        actions().moveToElement(pdpWishlistIcon).perform();
        click(pdpWishlistIcon);
    }

    public void goToWishlist(){
        click(wishListButton);
    }

    public void buyPremium() {
        click(addPremiumToBasket);
    }
    public SelenideElement getBasketCount() {
        return basketCount;
    }
}
