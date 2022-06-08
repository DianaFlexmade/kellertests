import ShopPages.LoginPage;
import com.codeborne.selenide.Condition;
import helpers.RetryAnalyzer;
import helpers.TestValues;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest{

    @Description("Тест на успішну авторизацію користувача")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void successAuthTest() {
        openMainPage();
        LoginPage authPage = new LoginPage();
        authPage.authorizeUser(TestValues.USER_EMAIL, TestValues.USER_PASS);
        authPage.getLoggedIn().shouldBe(Condition.visible);
        Assert.assertTrue(authPage.getLoggedIn().exists());
        logger.info("Passed");
    }

    @Description("Тест на неуспішну авторизацію із неправильним паролем")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void wrongPassAuthTest() {
        openMainPage();
        LoginPage authPage = new LoginPage();
        authPage.authorizeUser(TestValues.USER_EMAIL, "19111993test");
        authPage.getWrongPassMessage().shouldHave(Condition.text(TestValues.FAILED_LOGIN_MESSAGE));
        Assert.assertEquals(authPage.getWrongPassMessage().text(), TestValues.FAILED_LOGIN_MESSAGE);
    }
}
