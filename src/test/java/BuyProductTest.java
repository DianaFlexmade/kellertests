import ShopPages.PDPage;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class BuyProductTest extends BaseTest{

    @Test(description = "Тест на додання товара до кошика")
    public void addToBasketTest() {
        PDPage pdPage = new PDPage();
        open("/p/patagonia-arbor-roll-top-backpack-OEQPG03X000.html");
        pdPage.acceptCookie();
        pdPage.addToBasket();
        pdPage.checkMiniBasket().shouldHave(Condition.text("1"));
    }

    //TODO
    @Test(description = "Тест на успішну покупку товара")
    public void purchaseProductTest() {

    }
}
