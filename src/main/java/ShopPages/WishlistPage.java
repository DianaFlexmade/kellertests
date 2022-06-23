package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class WishlistPage extends BasePage {
    private final SelenideElement removeElement = $("button > .product-block__remove-image");

    public SelenideElement checkWishlistAmount() {
        return $(".wishlist__amount");
    }
    public WishlistPage removeItemFromWishlist() {
        removeElement.should(Condition.exist);
        click(removeElement);
        logger.info("Removed item from wishlist");
        return new WishlistPage();
    }
    public SelenideElement removeText()
    {
        return $(".product-layer__text");
    }
}