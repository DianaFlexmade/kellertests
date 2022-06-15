package ShopPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WishlistPage extends BasePage {

    private final SelenideElement removeElement = $("button > .product-block__remove-image");
    public SelenideElement checkWishlistAmount() {
        return $(".wishlist__amount");
    }
//    @Step("Видалити з обраного")
    public WishlistPage removeItemFromWishlist() {
        removeElement.should(Condition.exist);
        click(removeElement);
        return new WishlistPage();
    }
//    @Step("Видалити текст")
    public SelenideElement removeText() {
        return $(".product-layer__text");
    }

}


