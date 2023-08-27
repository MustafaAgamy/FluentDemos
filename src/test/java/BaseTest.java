import Utils.JSONClass;
import io.qameta.allure.Param;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

import java.time.Duration;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("115");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public String stringMethod(String string){
        return string;
    }
    public HomePage homeoemfe(){
      return  homePage = new HomePage(driver);
    }
    @AfterMethod
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }
}
