import ShopPages.LoginPage;
import ShopPages.MainPage;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import helpers.TestValues;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegTest extends BaseTest {
    Faker faker = new Faker();

    @Test(description = "Тест на успішну реєстрацію користувача")
    public void successRegTest() throws InterruptedException {
        open("/");
        LoginPage authPage = new LoginPage();
        authPage.registerUser(faker.internet().emailAddress(), "testPass1qQ!", "testPass1qQ!");
        authPage.getSuccessRegMessage().shouldHave(Condition.text(TestValues.SUCCESS_LOGIN_MESSAGE));
        Assert.assertEquals(authPage.getSuccessRegMessage().text(), TestValues.SUCCESS_LOGIN_MESSAGE);
    }

    @Test(description = "Тест на неуспішну реєстрацію зі слабким паролем")
    public void weakPassTest() throws InterruptedException {
        open("/");
        LoginPage authPage = new LoginPage();
        authPage.registerUser(faker.internet().emailAddress(), "testPass", "testPass");
        authPage.getWeakPassMessage().shouldHave(Condition.text(TestValues.WEAK_PASS_MESSAGE));
        Assert.assertEquals(authPage.getWeakPassMessage().text(), TestValues.WEAK_PASS_MESSAGE);
    }
}
