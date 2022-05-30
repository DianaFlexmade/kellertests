package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class WishlistPage extends BasePage {

    private SelenideElement wishlistAmount = $(".wishlist__amount");
    private SelenideElement removeItemIcon = $("button > .product-block__remove-image");

    private SelenideElement removeText = $(".product-layer__text");

    public void checkWishlistAmount() {
        wishlistAmount.shouldHave(Condition.text("1"));
    }

    public void removeItemFromWishlist() {
        removeItemIcon.click();
    }

    public SelenideElement removeText() {
        return removeText;
    }

}


