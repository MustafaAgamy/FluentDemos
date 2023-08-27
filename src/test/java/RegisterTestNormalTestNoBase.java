import Utils.JSONClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class RegisterTestNormalTestNoBase {
    private WebDriver driver;
    JSONClass registerData;
    JSONClass urlData;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void registerFlow(){
        registerData = new JSONClass("registerData.json");
        urlData = new JSONClass("URLs.json");
        HomePage homePage = new HomePage(driver);

        homePage.navigateToUrl(urlData.readJson("demoNopUrl"));

        var registerPage = homePage.clickRegisterBtn();
        registerPage.register(registerData.readJson("firstName"),
                registerData.readJson("lastName"),registerData.readJson("birthDay"),
                registerData.readJson("birthMonth"), registerData.readJson("birthYear"),
                registerData.readJson("email"), registerData.readJson("password"));

        var confirmRegisterPage = registerPage.clickConfirmRegBtn();

        confirmRegisterPage.validateSuccessfulRegister();

    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
