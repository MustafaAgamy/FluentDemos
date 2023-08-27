import Utils.JSONClass;
import org.testng.annotations.Test;

public class RegisterFluentTestBase extends BaseTest{

    JSONClass registerData;
    JSONClass loginData;


    @Test
    public void testRegisterFlow(){
        registerData = new JSONClass("registerData.json");

        homePage
                .clickRegisterBtn()
                .register(registerData.readJson("firstName"),
                        registerData.readJson("lastName"), registerData.readJson("birthDay"),
                        registerData.readJson("birthMonth"), registerData.readJson("birthYear"),
                        registerData.readJson("email"), registerData.readJson("password"))
                .validateSuccessfulRegister();

    }

    @Test
    public void testRegisterFlow1(){
        loginData = new JSONClass("loginData.json");

        homePage
                .clickRegisterBtn()
                .register(loginData.readJson("firstName"),
                        loginData.readJson("lastName"), loginData.readJson("birthDay"),
                        loginData.readJson("birthMonth"), loginData.readJson("birthYear"),
                        loginData.readJson("email"), loginData.readJson("password"))
                .validateSuccessfulRegister();

    }
}
