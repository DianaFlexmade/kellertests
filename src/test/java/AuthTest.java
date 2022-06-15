import ShopPages.LoginPage;
import com.codeborne.selenide.Condition;
import helpers.ConfigReader;
import helpers.RetryAnalyzer;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthTest extends BaseTest{

    LoginPage authPage = new LoginPage();
    @BeforeMethod
    void openPage() {
        openMainPage();
    }

    @Description("Тест на успішну авторизацію користувача")
    @Test(description = "Тест на успішну авторизацію користувача", retryAnalyzer = RetryAnalyzer.class)
    public void successAuthTest() throws IOException {

        authPage.authorizeUser(ConfigReader.getUsername(), ConfigReader.getPassword())
                .getLoggedIn().shouldBe(Condition.visible);
        Assert.assertTrue(authPage.getLoggedIn().exists());
    }

    @Description("Тест на неуспішну авторизацію із неправильним паролем")
    @Test(description = "Тест на неуспішну авторизацію із неправильним паролем", retryAnalyzer = RetryAnalyzer.class)
    void wrongPassAuthTest() throws IOException {
        authPage.authorizeUser(ConfigReader.getUsername(), "19111993test")
                .getWrongPassMessage().shouldHave(Condition.text("Please check your e-mail address and password."));
        Assert.assertEquals(authPage.getWrongPassMessage().text(), "Please check your e-mail address and password.");
    }
}
