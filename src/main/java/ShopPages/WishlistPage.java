package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WishlistPage extends BasePage {

    public void checkWishlistAmount() {
        $(".wishlist__amount").shouldHave(Condition.text("1"));
    }
    public void removeItemFromWishlist() {
        $("button > .product-block__remove-image").click();
    }

    public SelenideElement removeText() {
        return $(".product-layer__text");
    }

}


