import ShopPages.LoginPage;
import com.codeborne.selenide.Condition;
import helpers.ConfigReader;
import helpers.RetryAnalyzer;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest extends BaseTest{
    LoginPage authPage = new LoginPage();

    @Description("Тест на успішну авторизацію користувача")
    @Test(description = "Тест на успішну авторизацію користувача", retryAnalyzer = RetryAnalyzer.class)
    public void successAuthTest() throws IOException {
        open("/");
        authPage.authorizeUser(ConfigReader.getUsername(), ConfigReader.getPassword())
                .getLoggedIn().shouldBe(Condition.visible);
        Assert.assertTrue(authPage.getLoggedIn().exists());
    }

    @Description("Тест на неуспішну авторизацію із неправильним паролем")
    @Test(description = "Тест на неуспішну авторизацію із неправильним паролем", retryAnalyzer = RetryAnalyzer.class)
    void wrongPassAuthTest() throws IOException {
        open("/");
        authPage.authorizeUser(ConfigReader.getUsername(), "19111993test")
                .getWrongPassMessage().shouldHave(Condition.text("Please check your e-mail address and password."));
        Assert.assertEquals(authPage.getWrongPassMessage().text(), "Please check your e-mail address and password.");
    }
}