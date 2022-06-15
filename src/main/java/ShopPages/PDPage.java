package ShopPages;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.ClickOptions.usingDefaultMethod;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class PDPage extends BasePage{
    private final SelenideElement addPremiumToBasket = $(byXpath("//button[@class=\"premium-details__button\"]"));
    private final SelenideElement pdpWishlistIcon = $("div .wishlist-heart--animated");
    private final SelenideElement wishListButton = $(".js-miniwishlist");
    private final SelenideElement basketCount = $("#js_product_quantity");

    public PDPage addProductToBasket() {
        actions().moveToElement($(byText("Add to basket"))).perform();
        click($(byText("Add to basket")));
        logger.info("Added product to basket");
        return new PDPage();
    }
    public PDPage addToWishlist() {
        actions().moveToElement(pdpWishlistIcon).perform();
        click(pdpWishlistIcon);
        logger.info("Added product to wishlist");
        return new PDPage();
    }

    public WishlistPage goToWishlist(){
        click(wishListButton);
        return new WishlistPage();
    }

    public PDPage buyPremium() {
        addPremiumToBasket.click(usingDefaultMethod().timeout(Duration.ofSeconds(8)));
        return new PDPage();
    }
    public SelenideElement getBasketCount() {
        return basketCount;
    }
}
