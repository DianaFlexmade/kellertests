import ShopPages.LoginPage;
import com.codeborne.selenide.Condition;
import helpers.TestValues;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest extends BaseTest{

    @Test(description = "Тест на успішну авторизацію користувача")
    public void successAuthTest()  {
        open("/");
        LoginPage authPage = new LoginPage();
        authPage.authorizeUser(TestValues.USER_EMAIL, TestValues.USER_PASS);
        authPage.checkMyAccount();
        Assert.assertEquals(authPage.checkMyAccount().text(), TestValues.MY_ACCOUNT_TEXT);
    }

    @Test(description = "Тест на неуспішну авторизацію із неправильним паролем")
    public void wrongPassAuthTest() {
        open("/");
        LoginPage authPage = new LoginPage();
        authPage.authorizeUser(TestValues.USER_EMAIL, "19111993test");
        authPage.getWrongPassMessage().shouldHave(Condition.text(TestValues.FAILED_LOGIN_MESSAGE));
        Assert.assertEquals(authPage.getWrongPassMessage().text(), TestValues.FAILED_LOGIN_MESSAGE);
    }
}
