import Utils.JSONClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Setup;

public class LoginTest extends BaseTest{
    JSONClass loginData;

    @Test
    public void testLoginFlow(){
        loginData = new JSONClass("loginData.json");

        homePage
            .given()
                .userAlreadyRegistered(loginData)
            .when()
                .clickLoginBtn()
                .fillLoginData(loginData.readJson("email"), loginData.readJson("password"))
                .clickConfLoginBtn()
                .validateSuccessfulLogin();

        Setup.setUp();

    }
}
