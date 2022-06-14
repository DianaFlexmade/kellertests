import ShopPages.LoginPage;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import helpers.RetryAnalyzer;
import helpers.TestValues;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegTest extends BaseTest {
    Faker faker = new Faker();
    private final String email = faker.internet().emailAddress();

    @Description("Тест на успішну реєстрацію користувача")
    @Test(description = "Тест на успішну реєстрацію користувача", retryAnalyzer = RetryAnalyzer.class)
    void successRegTest() {
        openMainPage();
        LoginPage authPage = new LoginPage();
        authPage.registerUser(email, "TestPassword1!", "TestPassword1!");
        authPage.openRegPageText().shouldHave(Condition.text("REGISTRATION SUCCESSFUL"));
        Assert.assertEquals(authPage.openRegPageText().text(), TestValues.SUCCESS_MESSAGE);
    }

    @Description("Тест на неуспішну реєстрацію зі слабким паролем")
    @Test(description = "Тест на неуспішну реєстрацію зі слабким паролем", retryAnalyzer = RetryAnalyzer.class)
    void weakPassTest() {
        openMainPage();
        LoginPage authPage = new LoginPage();
        authPage.registerUser(email, "testPass", "testPass");
        authPage.getWeakPassMessage().shouldHave(Condition.text(TestValues.WEAK_PASS_MESSAGE));
        Assert.assertEquals(authPage.getWeakPassMessage().text(), TestValues.WEAK_PASS_MESSAGE);
    }
}
