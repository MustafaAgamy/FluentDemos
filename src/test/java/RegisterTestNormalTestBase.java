import Utils.JSONClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTestNormalTestBase extends BaseTest {

    JSONClass jsonData;

    @Test
    public void testRegisterFlow(){
        jsonData = new JSONClass("registerData.json");

        var registerPage = homePage.clickRegisterBtn();
        registerPage.register(jsonData.readJson("firstName"),
                jsonData.readJson("lastName"),jsonData.readJson("birthDay"),
                jsonData.readJson("birthMonth"), jsonData.readJson("birthYear"),
                jsonData.readJson("email"), jsonData.readJson("password"));

        var confirmRegisterPage = registerPage.clickConfirmRegBtn();

        confirmRegisterPage.validateSuccessfulRegister();

    }
}
