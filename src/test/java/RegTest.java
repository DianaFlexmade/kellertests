import ShopPages.LoginPage;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import helpers.RetryAnalyzer;
import helpers.TestValues;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegTest extends BaseTest {
    Faker faker = new Faker();
    private final String email = faker.internet().emailAddress();

    @Test(description = "Тест на успішну реєстрацію користувача", retryAnalyzer = RetryAnalyzer.class)
    public void successRegTest() {
        openMainPage();
        LoginPage authPage = new LoginPage();
        authPage.registerUser(email, "TestPassword1!", "TestPassword1!");
        authPage.getSuccessRegMessage().shouldHave(Condition.exactText("REGISTRATION SUCCESSFUL"));
        Assert.assertEquals(authPage.getSuccessRegMessage().text(), TestValues.SUCCESS_MESSAGE); // REGISTRATION SUCCESSFUL
    }

    @Test(description = "Тест на неуспішну реєстрацію зі слабким паролем", retryAnalyzer = RetryAnalyzer.class)
    public void weakPassTest() {
        openMainPage();
        LoginPage authPage = new LoginPage();
        authPage.registerUser(email, "testPass", "testPass");
        authPage.getWeakPassMessage().shouldHave(Condition.text(TestValues.WEAK_PASS_MESSAGE));
        Assert.assertEquals(authPage.getWeakPassMessage().text(), TestValues.WEAK_PASS_MESSAGE);
    }
}
